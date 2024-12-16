package se.iths.repository;

import static se.iths.JPAUtil.*;
import jakarta.persistence.EntityManager;
import se.iths.entity.Student;

import java.util.List;
import java.util.Optional;

public class StudentRepository {

        public void save(Student student) {
            inTransaction(em -> em.persist(student));
        }

        public List<Student> findAll() {
            EntityManager em = getEntityManager();
            return em.createQuery("from Student", Student.class).getResultList();
        }

        public Optional<Student> findByName(String name) {
            EntityManager em = getEntityManager();
            try {
                return Optional.of(em.createQuery("SELECT s FROM Student s WHERE s.name = :name", Student.class)
                        .setParameter("name", name).getSingleResult());
            } catch (RuntimeException e) {
                return Optional.empty();
            }
        }

    public List<Student> findByCourse(Course course) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT s FROM Student s WHERE s.course = :course", Student.class)
                    .setParameter("course", course)
                    .getResultList();
        } catch (RuntimeException e) {
            return new ArrayList<>();
        }
    }

    public boolean remove(Student student) {
            EntityManager em = getEntityManager();
            try {
                em.remove(student);
                return true;
            } catch (RuntimeException e) {
                return false;
            }
        }
    }