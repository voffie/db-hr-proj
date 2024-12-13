package se.iths.repository;

import static se.iths.JPAUtil.*;

import jakarta.persistence.EntityManager;
import se.iths.entity.Educator;

import java.util.List;
import java.util.Optional;

public class EducatorRepository {
    public void save(Educator educator) {
        inTransaction(em -> em.persist(educator));
    }

    public List<Educator> findAll() {
        EntityManager em = getEntityManager();
        return em.createQuery("from Educator", Educator.class).getResultList();
    }

    public Optional<Educator> findByName(String name) {
        EntityManager em = getEntityManager();
        try {
            return Optional.of(em.createQuery("SELECT e FROM Educator e WHERE e.name = :name", Educator.class)
                    .setParameter("name", name).getSingleResult());
        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }

    public boolean remove(Educator educator) {
        EntityManager em = getEntityManager();
        try {
            em.remove(educator);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
