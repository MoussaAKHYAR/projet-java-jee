package com.aegisi.dao;

import com.aegisi.entities.Membre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MembreImpl implements IMembre {

    private EntityManager em;

    public MembreImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aegisiPU");

        em = emf.createEntityManager();
    }

    @Override
    public int add(Membre membre) {
        try {
            em.getTransaction().begin();
            em.persist(membre);
            em.getTransaction().commit();
            return 1;
        }catch (Exception ex){
            ex.printStackTrace();
            return  0;
        }
    }

    @Override
    public List<Membre> list() {
        return em.createQuery("SELECT m FROM Membre m").getResultList();
    }
}
