/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import model.entities.Mesa;
import model.entities.Usuario;

/**
 *
 * @author puchy
 */
@Stateless
public class DAO {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceUnit
    EntityManagerFactory emf;

    public Usuario userByUserName(String username) {
        EntityManager em = emf.createEntityManager();
        Usuario u = em.find(Usuario.class, username);
        return u;
    }

    public Mesa getMesaByNumero(int numMesa) {
        EntityManager em = emf.createEntityManager();
        Mesa m = em.find(Mesa.class, numMesa);
        return m;
    }

    public void updateTableState(Mesa m) {
        EntityManager em = emf.createEntityManager();
        Mesa mUpdated = em.find(Mesa.class, m.getNumero());
        mUpdated.setEstado(m.getEstado());
        em.merge(mUpdated);
        em.close();
    }



}
