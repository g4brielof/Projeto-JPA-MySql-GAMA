package com.accenture.ecommerce.service;

import com.accenture.ecommerce.dao.CategoriaDAO;
import com.accenture.ecommerce.model.Categoria;
import com.accenture.ecommerce.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class CadastraCategoria {
    
    public static void cadastrar(Categoria categoria) {

        EntityManager entityManager = JPAUtils.getEntity();
        CategoriaDAO CategoriaDAO = new CategoriaDAO(entityManager);

        entityManager.getTransaction().begin();
        CategoriaDAO.criar(categoria);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void atualizar(Categoria categoria) {

        EntityManager entityManager = JPAUtils.getEntity();
        CategoriaDAO CategoriaDAO = new CategoriaDAO(entityManager);

        entityManager.getTransaction().begin();
        CategoriaDAO.buscarPorId(categoria.getId());
        CategoriaDAO.alterar(categoria);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void apagar(Long id) {

        EntityManager entityManager = JPAUtils.getEntity();
        CategoriaDAO CategoriaDAO = new CategoriaDAO(entityManager);

        entityManager.getTransaction().begin();
        Categoria usuario = CategoriaDAO.buscarPorId(id);
        CategoriaDAO.apagar(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static Categoria buscarPorId(Long id) {

        EntityManager entityManager = JPAUtils.getEntity();
        CategoriaDAO CategoriaDAO = new CategoriaDAO(entityManager);
        return CategoriaDAO.buscarPorId(id);
    }

    public static List<Categoria> buscarTodos() {

        EntityManager entityManager = JPAUtils.getEntity();
        CategoriaDAO CategoriaDAO = new CategoriaDAO(entityManager);
        return CategoriaDAO.buscarTodos();
    }
}
