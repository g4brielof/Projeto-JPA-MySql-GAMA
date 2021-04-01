package com.accenture.ecommerce.service;

import com.accenture.ecommerce.dao.UsuarioDAO;
import com.accenture.ecommerce.model.Usuario;
import com.accenture.ecommerce.utils.JPAUtils;
import javax.persistence.EntityManager;
import java.util.List;

public class CadastraUsuario {

    public static void cadastrar(Usuario usuario) {

        EntityManager entityManager = JPAUtils.getEntity();
        UsuarioDAO UsuarioDAO = new UsuarioDAO(entityManager);

        entityManager.getTransaction().begin();
        UsuarioDAO.criar(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void atualizar(Usuario usuario) {

        EntityManager entityManager = JPAUtils.getEntity();
        UsuarioDAO UsuarioDAO = new UsuarioDAO(entityManager);

        entityManager.getTransaction().begin();
        UsuarioDAO.buscarPorId(usuario.getId());
        UsuarioDAO.alterar(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void apagar(Long id) {

        EntityManager entityManager = JPAUtils.getEntity();
        UsuarioDAO UsuarioDAO = new UsuarioDAO(entityManager);

        entityManager.getTransaction().begin();
        Usuario usuario = UsuarioDAO.buscarPorId(id);
        UsuarioDAO.apagar(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static Usuario buscarPorId(Long id) {

        EntityManager entityManager = JPAUtils.getEntity();
        UsuarioDAO UsuarioDAO = new UsuarioDAO(entityManager);
        return UsuarioDAO.buscarPorId(id);
    }

    public static List<Usuario> buscarTodos() {

        EntityManager entityManager = JPAUtils.getEntity();
        UsuarioDAO UsuarioDAO = new UsuarioDAO(entityManager);
        return UsuarioDAO.buscarTodos();
    }
}
    

