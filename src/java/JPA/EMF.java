/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gianluca Bensabat Calvano
 */
public class EMF {

    private static EntityManagerFactory emf;

    public static EntityManager getEM() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("tarefa02PU");
        }
        return emf.createEntityManager();
    }
}
