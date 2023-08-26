package com.curso_java;

import java.util.ArrayList;
import java.util.List;


//import com.curso_java.dao.ClienteDao;
import com.curso_java.dao.PedidoDao;
//import com.curso_java.dao.ProdutoDao;
import com.curso_java.entities.Pedido;

public class Main {
    public static void main(String[] args) {

        //ClienteDao clienteDao = new ClienteDao();
        //ProdutoDao produtoDao = new ProdutoDao(); 
        PedidoDao pedidoDao = new PedidoDao(); 

        // Listar os Pedidos 
        List<Pedido> lista = new ArrayList<>();
        lista = pedidoDao.listar(); 
        for (Pedido pedido : lista) {
            System.out.println(pedido);
        }
        

        //Cliente cliente = clienteDao.consultar(12L); 

        //Produto produto1 = new Produto(null, "Calabresa", ReferenciaProduto.PIZZA_GRANDE, 40.0); 
        //Produto produto2 = new Produto(null, "Bebida", ReferenciaProduto.REFRIGERANTE_2L, 40.0); 
        
        //produtoDao.salvar(produto1);
        //produtoDao.salvar(produto2);
        
        //Produto produto1 = produtoDao.consultar(1L);     
        //Produto produto2 = produtoDao.consultar(2L);
        
        //Pedido pedido = new Pedido(null, 123, new Date(), cliente);
        
        //pedido.adicionarProduto(produto1);
        //pedido.adicionarProduto(produto2);

        //pedidoDao.salvar(pedido);

        // Adicionar os clientes

        // Cliente c1 = new Cliente(null, "Ana", "123456", Bairro.GUARA, 2023);
        // Cliente c2 = new Cliente(null, "Bob", "654789", Bairro.TAGUATINGA, 2023);
        // Cliente c3 = new Cliente(null, "Carlos", "165198", Bairro.AGUAS_CLARAS,
        // 2023);

        // clienteDao.salvar(c1);
        // clienteDao.salvar(c2);
        // clienteDao.salvar(c3);

        // Listar os clientes
        // List<Cliente> list = clienteDao.listar();

        // for (Cliente c : list) {
        // System.out.println(c);
        // }

        // Remover um cliente

        // Cliente cliente = new Cliente();
        // cliente = clienteDao.consultar(10L);
        // clienteDao.remover(cliente);

        // Alterar um cliente

        // Cliente cliente = new Cliente();
        // cliente = clienteDao.consultar(12L);
        // cliente.setNome("Everton");
        // cliente.setAnoCadastro(2020);
        // cliente.setBairro(Bairro.GUARA);
        // clienteDao.salvar(cliente);

        // Listar clientes por bairro
        // List<Cliente> list = clienteDao.listarClientesPorBairro(Bairro.GUARA);

        
        

        System.out.println("Done!");

    }
}