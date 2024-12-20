package se.iths.repository;

import jakarta.persistence.EntityManager;
import se.iths.JPAUtil;
import se.iths.entity.School;
import se.iths.statistics.StudentsPerSchool;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SchoolRepository {

    public List<School> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        return em.createQuery("SELECT s FROM School s", School.class).getResultList();
    }

    public Optional<School> findByName(String name) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return Optional.of(em.createQuery("SELECT s FROM School s WHERE s.name = :name", School.class)
                    .setParameter("name", name).getSingleResult());
        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }

    public void save(School school) {
        JPAUtil.inTransaction(em -> em.persist(school));
    }

    public void update(School school) {
        JPAUtil.inTransaction(em -> em.merge(school));
    }

    public void delete(int id) {
        JPAUtil.inTransaction(em -> {
            School school = em.find(School.class, id);
            if (school != null) {
                em.remove(school);
            }
        });
    }

    public List<StudentsPerSchool> studentsPerSchool() {
        List<StudentsPerSchool> output = new ArrayList<>();
        JPAUtil.inTransaction(entityManager -> {
            output.addAll(entityManager.createQuery("SELECT new se.iths.statistics.StudentsPerSchool(s.name, COUNT(st.id)) " +
                    "FROM School s " +
                    "INNER JOIN Student st on s.id = st.school.id " +
                    "GROUP BY s.name", StudentsPerSchool.class)
                    .getResultList());
        });
        return output;
    }
}
