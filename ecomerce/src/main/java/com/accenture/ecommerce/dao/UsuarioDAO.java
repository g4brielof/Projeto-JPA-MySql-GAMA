package com.accenture.ecommerce.dao;

import com.accenture.ecommerce.model.Usuario;
import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioDAO {

    private EntityManager entityManager;

    public UsuarioDAO() {}

    public UsuarioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void criar(Usuario usuario){
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(usuario);
        this.entityManager.getTransaction().commit();
    }

    public void alterar(Usuario  usuario){
        this.entityManager.merge(usuario);
    }

    public void apagar(Usuario  usuario){
        usuario = this.entityManager.merge(usuario);
        this.entityManager.remove(usuario);
    }

    public Usuario buscarPorId(long id){
        return this.entityManager.find(Usuario.class, id);
    }

    public List<Usuario> buscarTodos(){
        return this.entityManager.createQuery("Select u from Usuario u ", Usuario.class).getResultList();
    }
}
