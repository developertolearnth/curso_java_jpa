package com.curso_java.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido; 

    @Column(nullable = false)
    private Integer numero;

    @Column(name = "data_hora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente; 

    @ManyToMany
    @JoinTable(
        name = "pedido_produto",
        joinColumns = @JoinColumn(name = "id_pedido"),
        inverseJoinColumns = @JoinColumn(name = "id_produto")
    )
    private List<Produto> produtos = new ArrayList<>(); 

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 

    public Pedido(){

    }

    public Pedido(Long id_pedido, Integer numero, Date dataHora, Cliente cliente) {
        this.id_pedido = id_pedido;
        this.numero = numero;
        this.dataHora = dataHora;
        this.cliente = cliente;
    }

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    @Override
    public String toString() {
        return "Pedido [id_pedido=" + id_pedido + ", numero=" + numero + ", dataHora=" + sdf.format(dataHora) + "]";
    }

    public void adicionarProduto(Produto produto){
        produtos.add(produto); 
    }

    public void removerProduto(Produto produto){
        produtos.remove(produto); 
    }
}
