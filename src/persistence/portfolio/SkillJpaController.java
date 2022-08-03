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
import logic.portfolio.Skill;
import persistence.portfolio.exceptions.NonexistentEntityException;

/**
 *
 * @author amaccan
 */
public class SkillJpaController implements Serializable {

    public SkillJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public SkillJpaController() {
        emf = Persistence.createEntityManagerFactory("backend-portfolioPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Skill skill) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(skill);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Skill skill) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            skill = em.merge(skill);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = skill.getId();
                if (findSkill(id) == null) {
                    throw new NonexistentEntityException("The skill with id " + id + " no longer exists.");
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
            Skill skill;
            try {
                skill = em.getReference(Skill.class, id);
                skill.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The skill with id " + id + " no longer exists.", enfe);
            }
            em.remove(skill);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Skill> findSkillEntities() {
        return findSkillEntities(true, -1, -1);
    }

    public List<Skill> findSkillEntities(int maxResults, int firstResult) {
        return findSkillEntities(false, maxResults, firstResult);
    }

    private List<Skill> findSkillEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Skill.class));
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

    public Skill findSkill(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Skill.class, id);
        } finally {
            em.close();
        }
    }

    public int getSkillCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Skill> rt = cq.from(Skill.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
