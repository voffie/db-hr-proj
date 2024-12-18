package se.iths.repository;

import static se.iths.JPAUtil.*;

import jakarta.persistence.EntityManager;
import se.iths.entity.Educator;
import se.iths.entity.School;

import java.util.List;
import java.util.Optional;

public class EducatorRepository {
    public void save(Educator educator) {
        inTransaction(em -> em.persist(educator));
    }

    public List<Educator> findAll() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT e from Educator e", Educator.class).getResultList();
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

    public void update(int id, String newName, School newSchool) {
        inTransaction(em -> {
            Educator educator = em.find(Educator.class, id);
            if (educator != null) {
                educator.setName(newName);
                educator.setSchool(newSchool);
            } else {
                throw new RuntimeException("Educator not found with ID: " + id);
            }
        });
    }

    public void delete(int id) {
        inTransaction(em -> {
            Educator educator = em.find(Educator.class, id);
            if (educator != null) {
                em.remove(educator);
            }
        });
    }
}
