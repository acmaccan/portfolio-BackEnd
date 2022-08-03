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
import logic.portfolio.Education;
import persistence.portfolio.exceptions.NonexistentEntityException;

/**
 *
 * @author amaccan
 */
public class EducationJpaController implements Serializable {

    public EducationJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EducationJpaController() {
        emf = Persistence.createEntityManagerFactory("backend-portfolioPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Education education) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(education);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Education education) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            education = em.merge(education);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = education.getId();
                if (findEducation(id) == null) {
                    throw new NonexistentEntityException("The education with id " + id + " no longer exists.");
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
            Education education;
            try {
                education = em.getReference(Education.class, id);
                education.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The education with id " + id + " no longer exists.", enfe);
            }
            em.remove(education);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Education> findEducationEntities() {
        return findEducationEntities(true, -1, -1);
    }

    public List<Education> findEducationEntities(int maxResults, int firstResult) {
        return findEducationEntities(false, maxResults, firstResult);
    }

    private List<Education> findEducationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Education.class));
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

    public Education findEducation(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Education.class, id);
        } finally {
            em.close();
        }
    }

    public int getEducationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Education> rt = cq.from(Education.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
