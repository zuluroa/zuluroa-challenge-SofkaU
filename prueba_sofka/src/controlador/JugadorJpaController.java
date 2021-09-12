/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Jugador;
import modelo.Ronda;
import modelo.Premio;

/**
 *
 * @author zulur
 */
public class JugadorJpaController implements Serializable {

    public JugadorJpaController() {
        this.emf = Persistence.createEntityManagerFactory("prueba_sofkaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Jugador jugador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ronda ronda = jugador.getRonda();
            if (ronda != null) {
                ronda = em.getReference(ronda.getClass(), ronda.getId());
                jugador.setRonda(ronda);
            }
            Premio premio = jugador.getPremio();
            if (premio != null) {
                premio = em.getReference(premio.getClass(), premio.getId());
                jugador.setPremio(premio);
            }
            em.persist(jugador);
            if (ronda != null) {
                ronda.getJugadorList().add(jugador);
                ronda = em.merge(ronda);
            }
            if (premio != null) {
                premio.getJugadorList().add(jugador);
                premio = em.merge(premio);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Jugador jugador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Jugador persistentJugador = em.find(Jugador.class, jugador.getId());
            Ronda rondaOld = persistentJugador.getRonda();
            Ronda rondaNew = jugador.getRonda();
            Premio premioOld = persistentJugador.getPremio();
            Premio premioNew = jugador.getPremio();
            if (rondaNew != null) {
                rondaNew = em.getReference(rondaNew.getClass(), rondaNew.getId());
                jugador.setRonda(rondaNew);
            }
            if (premioNew != null) {
                premioNew = em.getReference(premioNew.getClass(), premioNew.getId());
                jugador.setPremio(premioNew);
            }
            jugador = em.merge(jugador);
            if (rondaOld != null && !rondaOld.equals(rondaNew)) {
                rondaOld.getJugadorList().remove(jugador);
                rondaOld = em.merge(rondaOld);
            }
            if (rondaNew != null && !rondaNew.equals(rondaOld)) {
                rondaNew.getJugadorList().add(jugador);
                rondaNew = em.merge(rondaNew);
            }
            if (premioOld != null && !premioOld.equals(premioNew)) {
                premioOld.getJugadorList().remove(jugador);
                premioOld = em.merge(premioOld);
            }
            if (premioNew != null && !premioNew.equals(premioOld)) {
                premioNew.getJugadorList().add(jugador);
                premioNew = em.merge(premioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = jugador.getId();
                if (findJugador(id) == null) {
                    throw new NonexistentEntityException("The jugador with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Jugador jugador;
            try {
                jugador = em.getReference(Jugador.class, id);
                jugador.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The jugador with id " + id + " no longer exists.", enfe);
            }
            Ronda ronda = jugador.getRonda();
            if (ronda != null) {
                ronda.getJugadorList().remove(jugador);
                ronda = em.merge(ronda);
            }
            Premio premio = jugador.getPremio();
            if (premio != null) {
                premio.getJugadorList().remove(jugador);
                premio = em.merge(premio);
            }
            em.remove(jugador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Jugador> findJugadorEntities() {
        return findJugadorEntities(true, -1, -1);
    }

    public List<Jugador> findJugadorEntities(int maxResults, int firstResult) {
        return findJugadorEntities(false, maxResults, firstResult);
    }

    private List<Jugador> findJugadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Jugador.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Jugador findJugador(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Jugador.class, id);
        } finally {
            em.close();
        }
    }

    public int getJugadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Jugador> rt = cq.from(Jugador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
