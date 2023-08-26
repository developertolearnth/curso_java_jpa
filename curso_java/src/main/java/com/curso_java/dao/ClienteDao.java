package com.curso_java.dao;

import java.util.List;

import com.curso_java.entities.Cliente;
import com.curso_java.enums.Bairro;
import com.curso_java.manager.Manager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ClienteDao implements InterfaceDao<Cliente> {

    private EntityManager em = Manager.getEntityManager();

    @Override
    public void salvar(Cliente obj) {
        em.getTransaction().begin();
        if (obj.getId_cliente() == null) {
            em.persist(obj);
        } else {
            em.merge(obj);
        }
        em.getTransaction().commit();
    }

    @Override
    public void remover(Cliente obj) {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
    }

    @Override
    public Cliente consultar(Long id) {
        return em.find(Cliente.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Cliente> listar() {
        Query query = em.createQuery("SELECT T FROM " + Cliente.class.getName() + " T ");
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Cliente> listarClientesPorBairro(Bairro bairro) {
        Query query = em.createQuery("SELECT T FROM " + Cliente.class.getName() + " T WHERE bairro = :bairro");
        query.setParameter("bairro", bairro);
        return query.getResultList();
    }
}
