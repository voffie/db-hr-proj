package se.iths.repository;

import jakarta.persistence.EntityManager;
import se.iths.JPAUtil;
import se.iths.entity.School;

import java.util.List;
import java.util.Optional;

public class SchoolRepository {

    public void save(School school) {
        JPAUtil.inTransaction(entityManager -> entityManager.persist(school));
    }

    public Optional<School> findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        return Optional.ofNullable(em.find(School.class, id));
    }

    public Optional<School> findByName(String name) {
        EntityManager em = JPAUtil.getEntityManager();
        List<School> schools = em.createQuery("SELECT s FROM School s WHERE s.name = :name", School.class)
                .setParameter("name", name)
                .getResultList();
        return schools.stream().findFirst();
    }

    public List<School> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        return em.createQuery("SELECT s FROM School s", School.class).getResultList();
    }

    public void update(Long id, String newName) {
        JPAUtil.inTransaction(entityManager -> {
            School school = entityManager.find(School.class, id);
            if (school != null) {
                school.setName(newName);
            }
        });
    }

    public void delete(Long id) {
        JPAUtil.inTransaction(entityManager -> {
            School school = entityManager.find(School.class, id);
            if (school != null) {
                entityManager.remove(school);
            }
        });
    }
}
