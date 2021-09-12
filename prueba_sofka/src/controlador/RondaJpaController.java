/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.IllegalOrphanException;
import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Jugador;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Categoria;
import modelo.Ronda;

/**
 *
 * @author zulur
 */
public class RondaJpaController implements Serializable {

    public RondaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("prueba_sofkaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ronda ronda) {
        if (ronda.getJugadorList() == null) {
            ronda.setJugadorList(new ArrayList<Jugador>());
        }
        if (ronda.getCategoriaList() == null) {
            ronda.setCategoriaList(new ArrayList<Categoria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Jugador> attachedJugadorList = new ArrayList<Jugador>();
            for (Jugador jugadorListJugadorToAttach : ronda.getJugadorList()) {
                jugadorListJugadorToAttach = em.getReference(jugadorListJugadorToAttach.getClass(), jugadorListJugadorToAttach.getId());
                attachedJugadorList.add(jugadorListJugadorToAttach);
            }
            ronda.setJugadorList(attachedJugadorList);
            List<Categoria> attachedCategoriaList = new ArrayList<Categoria>();
            for (Categoria categoriaListCategoriaToAttach : ronda.getCategoriaList()) {
                categoriaListCategoriaToAttach = em.getReference(categoriaListCategoriaToAttach.getClass(), categoriaListCategoriaToAttach.getId());
                attachedCategoriaList.add(categoriaListCategoriaToAttach);
            }
            ronda.setCategoriaList(attachedCategoriaList);
            em.persist(ronda);
            for (Jugador jugadorListJugador : ronda.getJugadorList()) {
                Ronda oldRondaOfJugadorListJugador = jugadorListJugador.getRonda();
                jugadorListJugador.setRonda(ronda);
                jugadorListJugador = em.merge(jugadorListJugador);
                if (oldRondaOfJugadorListJugador != null) {
                    oldRondaOfJugadorListJugador.getJugadorList().remove(jugadorListJugador);
                    oldRondaOfJugadorListJugador = em.merge(oldRondaOfJugadorListJugador);
                }
            }
            for (Categoria categoriaListCategoria : ronda.getCategoriaList()) {
                Ronda oldRondaOfCategoriaListCategoria = categoriaListCategoria.getRonda();
                categoriaListCategoria.setRonda(ronda);
                categoriaListCategoria = em.merge(categoriaListCategoria);
                if (oldRondaOfCategoriaListCategoria != null) {
                    oldRondaOfCategoriaListCategoria.getCategoriaList().remove(categoriaListCategoria);
                    oldRondaOfCategoriaListCategoria = em.merge(oldRondaOfCategoriaListCategoria);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ronda ronda) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ronda persistentRonda = em.find(Ronda.class, ronda.getId());
            List<Jugador> jugadorListOld = persistentRonda.getJugadorList();
            List<Jugador> jugadorListNew = ronda.getJugadorList();
            List<Categoria> categoriaListOld = persistentRonda.getCategoriaList();
            List<Categoria> categoriaListNew = ronda.getCategoriaList();
            List<String> illegalOrphanMessages = null;
            for (Jugador jugadorListOldJugador : jugadorListOld) {
                if (!jugadorListNew.contains(jugadorListOldJugador)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Jugador " + jugadorListOldJugador + " since its ronda field is not nullable.");
                }
            }
            for (Categoria categoriaListOldCategoria : categoriaListOld) {
                if (!categoriaListNew.contains(categoriaListOldCategoria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Categoria " + categoriaListOldCategoria + " since its ronda field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Jugador> attachedJugadorListNew = new ArrayList<Jugador>();
            for (Jugador jugadorListNewJugadorToAttach : jugadorListNew) {
                jugadorListNewJugadorToAttach = em.getReference(jugadorListNewJugadorToAttach.getClass(), jugadorListNewJugadorToAttach.getId());
                attachedJugadorListNew.add(jugadorListNewJugadorToAttach);
            }
            jugadorListNew = attachedJugadorListNew;
            ronda.setJugadorList(jugadorListNew);
            List<Categoria> attachedCategoriaListNew = new ArrayList<Categoria>();
            for (Categoria categoriaListNewCategoriaToAttach : categoriaListNew) {
                categoriaListNewCategoriaToAttach = em.getReference(categoriaListNewCategoriaToAttach.getClass(), categoriaListNewCategoriaToAttach.getId());
                attachedCategoriaListNew.add(categoriaListNewCategoriaToAttach);
            }
            categoriaListNew = attachedCategoriaListNew;
            ronda.setCategoriaList(categoriaListNew);
            ronda = em.merge(ronda);
            for (Jugador jugadorListNewJugador : jugadorListNew) {
                if (!jugadorListOld.contains(jugadorListNewJugador)) {
                    Ronda oldRondaOfJugadorListNewJugador = jugadorListNewJugador.getRonda();
                    jugadorListNewJugador.setRonda(ronda);
                    jugadorListNewJugador = em.merge(jugadorListNewJugador);
                    if (oldRondaOfJugadorListNewJugador != null && !oldRondaOfJugadorListNewJugador.equals(ronda)) {
                        oldRondaOfJugadorListNewJugador.getJugadorList().remove(jugadorListNewJugador);
                        oldRondaOfJugadorListNewJugador = em.merge(oldRondaOfJugadorListNewJugador);
                    }
                }
            }
            for (Categoria categoriaListNewCategoria : categoriaListNew) {
                if (!categoriaListOld.contains(categoriaListNewCategoria)) {
                    Ronda oldRondaOfCategoriaListNewCategoria = categoriaListNewCategoria.getRonda();
                    categoriaListNewCategoria.setRonda(ronda);
                    categoriaListNewCategoria = em.merge(categoriaListNewCategoria);
                    if (oldRondaOfCategoriaListNewCategoria != null && !oldRondaOfCategoriaListNewCategoria.equals(ronda)) {
                        oldRondaOfCategoriaListNewCategoria.getCategoriaList().remove(categoriaListNewCategoria);
                        oldRondaOfCategoriaListNewCategoria = em.merge(oldRondaOfCategoriaListNewCategoria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ronda.getId();
                if (findRonda(id) == null) {
                    throw new NonexistentEntityException("The ronda with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ronda ronda;
            try {
                ronda = em.getReference(Ronda.class, id);
                ronda.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ronda with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Jugador> jugadorListOrphanCheck = ronda.getJugadorList();
            for (Jugador jugadorListOrphanCheckJugador : jugadorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ronda (" + ronda + ") cannot be destroyed since the Jugador " + jugadorListOrphanCheckJugador + " in its jugadorList field has a non-nullable ronda field.");
            }
            List<Categoria> categoriaListOrphanCheck = ronda.getCategoriaList();
            for (Categoria categoriaListOrphanCheckCategoria : categoriaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ronda (" + ronda + ") cannot be destroyed since the Categoria " + categoriaListOrphanCheckCategoria + " in its categoriaList field has a non-nullable ronda field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(ronda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ronda> findRondaEntities() {
        return findRondaEntities(true, -1, -1);
    }

    public List<Ronda> findRondaEntities(int maxResults, int firstResult) {
        return findRondaEntities(false, maxResults, firstResult);
    }

    private List<Ronda> findRondaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ronda.class));
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

    public Ronda findRonda(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ronda.class, id);
        } finally {
            em.close();
        }
    }

    public int getRondaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ronda> rt = cq.from(Ronda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
