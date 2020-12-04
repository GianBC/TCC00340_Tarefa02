/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import Entidades.Edicao;
import Entidades.Evento;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Gianluca Bensabat Calvano
 */
public class JPA_edicao {

    private EntityManager em;

    public void setPersistir(Edicao edicao) {
        em = EMF.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(edicao);
        et.commit();
        em.close();
    }

    public void setModificarEdicao(long id, Edicao edicao_nova) {
        Edicao edicao;
        try {
            em = EMF.getEM();
            edicao = em.find(Edicao.class, id);
            em.getTransaction().begin();
            edicao.setNumero(edicao_nova.getNumero());
            edicao.setAno(edicao_nova.getAno());
            edicao.setDataini(edicao_nova.getDataini());
            edicao.setDatafim(edicao_nova.getDatafim());
            edicao.setCidade(edicao_nova.getCidade());
            edicao.setPais(edicao_nova.getPais());
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {

        }
    }

    public Evento getEventoUnico(String nome) {
        try {
            String jpqlQuery = "SELECT e FROM Evento e where e.nome = :n";
            em = EMF.getEM();
            Query query = em.createQuery(jpqlQuery);
            query.setParameter("n", nome);
            List<Evento> eventos = query.getResultList();
            em.close();
            return eventos.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    public void setApagarEdicao(long id) {
        try {
            em = EMF.getEM();
            Edicao edicao = em.find(Edicao.class, id);
            em.getTransaction().begin();
            em.remove(edicao);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {

        }
    }

    public Edicao getEdicaoPorID(long id) {
        Edicao edicao = null;
        try {
            em = EMF.getEM();
            edicao = em.find(Edicao.class, id);
            em.close();
            return edicao;
        } catch (Exception e) {

        }
        return edicao;
    }
}
