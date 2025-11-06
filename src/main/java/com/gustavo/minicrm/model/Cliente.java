package com.gustavo.minicrm.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes_tb")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference // Evitar loop na hora de criar os objetos
    private List<Contato> contatos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nome, String email, List<Contato> contatos) {
        this.nome = nome;
        this.email = email;
        this.contatos = contatos;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<Contato> getContatos() {
        return contatos;
    }
    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}
