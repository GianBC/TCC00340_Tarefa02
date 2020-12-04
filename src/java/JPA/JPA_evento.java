/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import Entidades.Evento;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Gianluca Bensabat Calvano
 */
public class JPA_evento {

    private EntityManager em;

    public JPA_evento() {
    }

    public void setPersistir(Evento evento) {
        em = EMF.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(evento);
        et.commit();
        em.close();
    }

    public Evento getEventoPorID(long id) {
        Evento evento = null;
        try {
            em = EMF.getEM();
            evento = em.find(Evento.class, id);
            em.close();
            return evento;
        } catch (Exception e) {

        }
        return evento;
    }

    public Evento setModificarEvento(long id, Evento evento_novo) {
        Evento evento = null;
        try {
            em = EMF.getEM();
            evento = em.find(Evento.class, id);
            em.getTransaction().begin();
            evento.setNome(evento_novo.getNome());
            evento.setSigla(evento_novo.getSigla());
            evento.setArea(evento_novo.getArea());
            evento.setInst_org(evento_novo.getInst_org());
            em.getTransaction().commit();
            em.close();
            return evento;
        } catch (Exception e) {

        }
        return evento;
    }

    public void setApagarEvento(long id) {
        try {
            em = EMF.getEM();
            Evento evento = em.find(Evento.class, id);
            em.getTransaction().begin();
            em.remove(evento);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {

        }
    }

    public List<Evento> getNomeEventos(String nome) {
        String jpqlQuery = "SELECT e FROM Evento e where e.nome = :n";
        em = EMF.getEM();
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("n", nome);
        List<Evento> eventos = query.getResultList();
        em.close();
        return eventos;
    }
}
