package com.accenture.ecommerce.service;

import com.accenture.ecommerce.dao.MarcaDAO;
import com.accenture.ecommerce.model.Marca;
import com.accenture.ecommerce.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class CadastraMarca {

    public static void cadastrar(Marca marca) {

        EntityManager entityManager = JPAUtils.getEntity();
        MarcaDAO MarcaDAO = new MarcaDAO(entityManager);

        entityManager.getTransaction().begin();
        MarcaDAO.criar(marca);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void atualizar(Marca marca) {

        EntityManager entityManager = JPAUtils.getEntity();
        MarcaDAO MarcaDAO = new MarcaDAO(entityManager);

        entityManager.getTransaction().begin();
        MarcaDAO.buscarPorId(marca.getId());
        MarcaDAO.alterar(marca);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void apagar(Long id) {

        EntityManager entityManager = JPAUtils.getEntity();
        MarcaDAO MarcaDAO = new MarcaDAO(entityManager);

        entityManager.getTransaction().begin();
        Marca usuario = MarcaDAO.buscarPorId(id);
        MarcaDAO.apagar(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static Marca buscarPorId(Long id) {

        EntityManager entityManager = JPAUtils.getEntity();
        MarcaDAO MarcaDAO = new MarcaDAO(entityManager);
        return MarcaDAO.buscarPorId(id);
    }

    public static List<Marca> buscarTodos() {

        EntityManager entityManager = JPAUtils.getEntity();
        MarcaDAO MarcaDAO = new MarcaDAO(entityManager);
        return MarcaDAO.buscarTodos();
    }
}
