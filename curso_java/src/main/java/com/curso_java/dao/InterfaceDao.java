package com.curso_java.dao;

import java.util.List;

public interface InterfaceDao <G> {
    
    public void salvar(G obj);
    public void remover(G obj);
    public G consultar(Long id); 
    public List<G> listar(); 

}
