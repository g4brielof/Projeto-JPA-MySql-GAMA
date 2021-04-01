package com.accenture.ecommerce.dao;

import com.accenture.ecommerce.model.Categoria;
import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDAO {

    private EntityManager entityManager;

    public CategoriaDAO() {}

    public CategoriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void criar(Categoria categoria){
        this.entityManager.persist(categoria);
    }

    public void alterar(Categoria  categoria){
        this.entityManager.merge(categoria);
    }

    public void apagar(Categoria  categoria){
        categoria = this.entityManager.merge(categoria);
        this.entityManager.remove(categoria);
    }

    public Categoria buscarPorId(long id){
        return this.entityManager.find(Categoria.class, id);
    }

    public List<Categoria> buscarTodos(){
        return this.entityManager.createQuery("Select c from Categoria c ", Categoria.class).getResultList();
    }
}
