package com.curso_java.entities;

import java.util.ArrayList;
import java.util.List;

import com.curso_java.enums.ReferenciaProduto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto; 

    @Column(nullable = false)
    private String sabor;

    @Column(name = "referencia_produto", nullable = false)
    @Enumerated(EnumType.STRING)
    private ReferenciaProduto referenciaProduto;
    
    @Column(nullable = false)
    private Double valor; 

    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos = new ArrayList<>();

    public Produto(){
        
    }

    public Produto(Long id_produto, String sabor, ReferenciaProduto referenciaProduto, Double valor) {
        this.id_produto = id_produto;
        this.sabor = sabor;
        this.referenciaProduto = referenciaProduto;
        this.valor = valor;
    }

    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public ReferenciaProduto getReferenciaProduto() {
        return referenciaProduto;
    }

    public void setReferenciaProduto(ReferenciaProduto referenciaProduto) {
        this.referenciaProduto = referenciaProduto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    @Override
    public String toString() {
        return "Produto [id_produto=" + id_produto + ", sabor=" + sabor + ", referenciaProduto=" + referenciaProduto + ", valor="
                + valor + "]";
    }
    
    public void adicionarPedido(Pedido pedido){
        pedidos.add(pedido); 
    }

    public void removerPedido(Pedido pedido){
        pedidos.remove(pedido); 
    }
}
