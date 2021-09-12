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
import modelo.Categoria;
import modelo.Opcion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Pregunta;

/**
 *
 * @author zulur
 */
public class PreguntaJpaController implements Serializable {

    public PreguntaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("prueba_sofkaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pregunta pregunta) {
        if (pregunta.getOpcionList() == null) {
            pregunta.setOpcionList(new ArrayList<Opcion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria categoria = pregunta.getCategoria();
            if (categoria != null) {
                categoria = em.getReference(categoria.getClass(), categoria.getId());
                pregunta.setCategoria(categoria);
            }
            List<Opcion> attachedOpcionList = new ArrayList<Opcion>();
            for (Opcion opcionListOpcionToAttach : pregunta.getOpcionList()) {
                opcionListOpcionToAttach = em.getReference(opcionListOpcionToAttach.getClass(), opcionListOpcionToAttach.getId());
                attachedOpcionList.add(opcionListOpcionToAttach);
            }
            pregunta.setOpcionList(attachedOpcionList);
            em.persist(pregunta);
            if (categoria != null) {
                categoria.getPreguntaList().add(pregunta);
                categoria = em.merge(categoria);
            }
            for (Opcion opcionListOpcion : pregunta.getOpcionList()) {
                Pregunta oldPreguntaOfOpcionListOpcion = opcionListOpcion.getPregunta();
                opcionListOpcion.setPregunta(pregunta);
                opcionListOpcion = em.merge(opcionListOpcion);
                if (oldPreguntaOfOpcionListOpcion != null) {
                    oldPreguntaOfOpcionListOpcion.getOpcionList().remove(opcionListOpcion);
                    oldPreguntaOfOpcionListOpcion = em.merge(oldPreguntaOfOpcionListOpcion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pregunta pregunta) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pregunta persistentPregunta = em.find(Pregunta.class, pregunta.getId());
            Categoria categoriaOld = persistentPregunta.getCategoria();
            Categoria categoriaNew = pregunta.getCategoria();
            List<Opcion> opcionListOld = persistentPregunta.getOpcionList();
            List<Opcion> opcionListNew = pregunta.getOpcionList();
            List<String> illegalOrphanMessages = null;
            for (Opcion opcionListOldOpcion : opcionListOld) {
                if (!opcionListNew.contains(opcionListOldOpcion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Opcion " + opcionListOldOpcion + " since its pregunta field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (categoriaNew != null) {
                categoriaNew = em.getReference(categoriaNew.getClass(), categoriaNew.getId());
                pregunta.setCategoria(categoriaNew);
            }
            List<Opcion> attachedOpcionListNew = new ArrayList<Opcion>();
            for (Opcion opcionListNewOpcionToAttach : opcionListNew) {
                opcionListNewOpcionToAttach = em.getReference(opcionListNewOpcionToAttach.getClass(), opcionListNewOpcionToAttach.getId());
                attachedOpcionListNew.add(opcionListNewOpcionToAttach);
            }
            opcionListNew = attachedOpcionListNew;
            pregunta.setOpcionList(opcionListNew);
            pregunta = em.merge(pregunta);
            if (categoriaOld != null && !categoriaOld.equals(categoriaNew)) {
                categoriaOld.getPreguntaList().remove(pregunta);
                categoriaOld = em.merge(categoriaOld);
            }
            if (categoriaNew != null && !categoriaNew.equals(categoriaOld)) {
                categoriaNew.getPreguntaList().add(pregunta);
                categoriaNew = em.merge(categoriaNew);
            }
            for (Opcion opcionListNewOpcion : opcionListNew) {
                if (!opcionListOld.contains(opcionListNewOpcion)) {
                    Pregunta oldPreguntaOfOpcionListNewOpcion = opcionListNewOpcion.getPregunta();
                    opcionListNewOpcion.setPregunta(pregunta);
                    opcionListNewOpcion = em.merge(opcionListNewOpcion);
                    if (oldPreguntaOfOpcionListNewOpcion != null && !oldPreguntaOfOpcionListNewOpcion.equals(pregunta)) {
                        oldPreguntaOfOpcionListNewOpcion.getOpcionList().remove(opcionListNewOpcion);
                        oldPreguntaOfOpcionListNewOpcion = em.merge(oldPreguntaOfOpcionListNewOpcion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pregunta.getId();
                if (findPregunta(id) == null) {
                    throw new NonexistentEntityException("The pregunta with id " + id + " no longer exists.");
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
            Pregunta pregunta;
            try {
                pregunta = em.getReference(Pregunta.class, id);
                pregunta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pregunta with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Opcion> opcionListOrphanCheck = pregunta.getOpcionList();
            for (Opcion opcionListOrphanCheckOpcion : opcionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pregunta (" + pregunta + ") cannot be destroyed since the Opcion " + opcionListOrphanCheckOpcion + " in its opcionList field has a non-nullable pregunta field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Categoria categoria = pregunta.getCategoria();
            if (categoria != null) {
                categoria.getPreguntaList().remove(pregunta);
                categoria = em.merge(categoria);
            }
            em.remove(pregunta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pregunta> findPreguntaEntities() {
        return findPreguntaEntities(true, -1, -1);
    }

    public List<Pregunta> findPreguntaEntities(int maxResults, int firstResult) {
        return findPreguntaEntities(false, maxResults, firstResult);
    }

    private List<Pregunta> findPreguntaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pregunta.class));
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

    public Pregunta findPregunta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pregunta.class, id);
        } finally {
            em.close();
        }
    }

    public int getPreguntaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pregunta> rt = cq.from(Pregunta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
