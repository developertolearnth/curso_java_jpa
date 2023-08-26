package com.curso_java.entities;

import java.util.ArrayList;
import java.util.List;

import com.curso_java.enums.Bairro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente; 

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone; 

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Bairro bairro; 

    @Column(name = "ano_cadastro",nullable = false)
    private Integer anoCadastro;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>(); 

    public Cliente(){

    }
    
    public Cliente(Long id_cliente, String nome, String telefone, Bairro bairro, Integer anoCadastro) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.telefone = telefone;
        this.bairro = bairro;
        this.anoCadastro = anoCadastro;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Integer getAnoCadastro() {
        return anoCadastro;
    }

    public void setAnoCadastro(Integer anoCadastro) {
        this.anoCadastro = anoCadastro;
    }  

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    @Override
    public String toString() {
        return "Cliente [id_cliente=" + id_cliente + ", nome=" + nome + ", telefone=" + telefone + ", bairro=" + bairro
                + ", anoCadastro=" + anoCadastro + "]";
    } 

    
}
