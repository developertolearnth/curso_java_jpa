package com.curso_java.dao;

import java.util.List;

import com.curso_java.entities.Produto;
import com.curso_java.manager.Manager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ProdutoDao implements InterfaceDao<Produto> {

    private EntityManager em = Manager.getEntityManager();

    @Override
    public void salvar(Produto obj) {
        em.getTransaction().begin();
        if (obj.getId_produto() == null) {
            em.persist(obj);
        } else {
            em.merge(obj);
        }
        em.getTransaction().commit();
    }

    @Override
    public void remover(Produto obj) {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
    }

    @Override
    public Produto consultar(Long id) {
        return em.find(Produto.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Produto> listar() {
        Query query = em.createQuery("SELECT T FROM " + Produto.class.getName() + " T ");
        return query.getResultList();
    }
    
}
