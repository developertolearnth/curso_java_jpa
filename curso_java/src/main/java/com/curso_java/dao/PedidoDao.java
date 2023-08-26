package com.curso_java.dao;

import java.util.List;

import com.curso_java.entities.Pedido;
import com.curso_java.manager.Manager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class PedidoDao implements InterfaceDao<Pedido> {

    private EntityManager em = Manager.getEntityManager();

    @Override
    public void salvar(Pedido obj) {
        em.getTransaction().begin();
        if (obj.getId_pedido() == null) {
            em.persist(obj);
        } else {
            em.merge(obj);
        }
        em.getTransaction().commit();
    }

    @Override
    public void remover(Pedido obj) {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
    }

    @Override
    public Pedido consultar(Long id) {
        return em.find(Pedido.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Pedido> listar() {
        Query query = em.createQuery("SELECT T FROM " + Pedido.class.getName() + " T ");
        return query.getResultList();
    }
    
}
