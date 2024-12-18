package se.iths.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import se.iths.JPAUtil;
import se.iths.entity.School;

import java.util.List;
import java.util.Optional;

public class SchoolRepository {

    public List<School> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<School> query = em.createQuery("SELECT s FROM School s", School.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Optional<School> findById(String id) {
        EntityManager em = JPAUtil.getEntityManager();
        School school = em.find(School.class, id);
        em.close();
        return Optional.ofNullable(school);
    }

    public void save(School school) {
        JPAUtil.inTransaction(em -> em.persist(school));
    }

    public void update(School school) {
        JPAUtil.inTransaction(em -> em.merge(school));
    }

    public void delete(String id) {
        JPAUtil.inTransaction(em -> {
            School school = em.find(School.class, id);
            if (school != null) {
                em.remove(school);
            }
        });
    }
}
