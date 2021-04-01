package com.accenture.ecommerce.dao;

import com.accenture.ecommerce.model.Marca;
import javax.persistence.EntityManager;
import java.util.List;

public class MarcaDAO {

    private EntityManager entityManager;

    public MarcaDAO() {}

    public MarcaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void criar(Marca marca){
        this.entityManager.persist(marca);
    }

    public void alterar(Marca  marca){
        this.entityManager.merge(marca);
    }

    public void apagar(Marca  marca){
        marca = this.entityManager.merge(marca);
        this.entityManager.remove(marca);
    }

    public Marca buscarPorId(long id){
        return this.entityManager.find(Marca.class, id);
    }

    public List<Marca> buscarTodos(){
        return this.entityManager.createQuery("Select m from Marca m ", Marca.class).getResultList();
    }

}
