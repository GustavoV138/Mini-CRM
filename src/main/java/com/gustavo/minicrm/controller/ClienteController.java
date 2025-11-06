package com.gustavo.minicrm.controller;

import com.gustavo.minicrm.model.Cliente;
import com.gustavo.minicrm.model.Contato;
import com.gustavo.minicrm.repository.ClienteRepository;
import com.gustavo.minicrm.repository.ContatoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final ContatoRepository contatoRepository;

    public ClienteController( ContatoRepository contatoRepository, ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
        this.contatoRepository = contatoRepository;
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente payload) {
        Cliente cliente = clienteRepository.save(payload);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    @PostMapping("/{id}/contatos")
    public ResponseEntity<Contato> criarContato(@PathVariable Long id, @RequestBody Contato payload) {
        var opt = clienteRepository.findById(id);

        if(opt.isEmpty()) ResponseEntity.notFound().build();

        var cliente = opt.get();

        payload.setId(null);
        payload.setCliente(cliente);

        var salvo = contatoRepository.save(payload);

        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<Contato>> listarContatos(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(c -> ResponseEntity.ok(c.getContatos()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
