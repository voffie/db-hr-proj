package se.iths.repository;

import static se.iths.JPAUtil.*;
import jakarta.persistence.EntityManager;
import se.iths.entity.Course;
import se.iths.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepository {

    //add student
    public void save(Student student) {
        inTransaction(em -> em.persist(student));
    }
    //update student
    public void update(String id, String newName) {
        inTransaction(em -> {
            Student student = em.find(Student.class, id);
            if (student != null) {
                student.setName(newName);
            } else {
                throw new RuntimeException("Student not found with ID: " + id);
            }
        });
    }
    //delete student
    public void delete(String id) {
        inTransaction(em -> {
            Student student = em.find(Student.class, id);
            if (student != null) {
                em.remove(student);
            }
        });
    }
    //find all students
    public List<Student> findAll() {
        EntityManager em = getEntityManager();
        return em.createQuery("from Student", Student.class).getResultList();
    }

    //find students by name
    public Optional<Student> findByName(String name) {
        EntityManager em = getEntityManager();
            try {
                return Optional.of(em.createQuery("SELECT s FROM Student s WHERE s.name = :name", Student.class)
                        .setParameter("name", name).getSingleResult());
            } catch (RuntimeException e) {
                return Optional.empty();
            }
        }

        //Extra för kul =)
    //find students by course
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
    //finds students by course and country
    public List<Object[]> getStudentCountByCountryAndCourse() {
        EntityManager em = getEntityManager();
            try {
                return em.createQuery(
                            "SELECT s.country.name, s.course.name, COUNT(s) " +
                                    "FROM Student s " +
                                    "GROUP BY s.country.name, s.course.name " +
                                    "ORDER BY s.country.name, s.course.name",
                            Object[].class)
                    .getResultList();
            } catch (RuntimeException e) {
                return new ArrayList<>();
            }
        }
}
