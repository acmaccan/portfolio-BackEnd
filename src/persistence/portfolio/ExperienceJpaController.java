/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence.portfolio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logic.portfolio.Experience;
import persistence.portfolio.exceptions.NonexistentEntityException;

/**
 *
 * @author amaccan
 */
public class ExperienceJpaController implements Serializable {

    public ExperienceJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ExperienceJpaController() {
        emf = Persistence.createEntityManagerFactory("backend-portfolioPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Experience experience) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(experience);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Experience experience) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            experience = em.merge(experience);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = experience.getId();
                if (findExperience(id) == null) {
                    throw new NonexistentEntityException("The experience with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Experience experience;
            try {
                experience = em.getReference(Experience.class, id);
                experience.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The experience with id " + id + " no longer exists.", enfe);
            }
            em.remove(experience);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Experience> findExperienceEntities() {
        return findExperienceEntities(true, -1, -1);
    }

    public List<Experience> findExperienceEntities(int maxResults, int firstResult) {
        return findExperienceEntities(false, maxResults, firstResult);
    }

    private List<Experience> findExperienceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Experience.class));
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

    public Experience findExperience(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Experience.class, id);
        } finally {
            em.close();
        }
    }

    public int getExperienceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Experience> rt = cq.from(Experience.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
