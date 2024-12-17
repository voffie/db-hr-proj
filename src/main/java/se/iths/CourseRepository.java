package se.iths;

import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import static se.iths.JPAUtil.getEntityManager;
import static se.iths.JPAUtil.inTransaction;

public class CourseRepository {
    public void save(Course course) {
        inTransaction(em -> em.persist(course));
    }

    public List<Course> findAll() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT c from Course c", Course.class).getResultList();
    }

    public Optional<Course> findById(String id) {
        EntityManager em = getEntityManager();
        try {
            return Optional.of(em.find(Course.class, id));
        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }

    public void update(String id, String newName, Educator newEducator, School newSchool) {
        inTransaction(em -> {
            Course course = em.find(Course.class, id);
            if (course != null) {
                course.setName(newName);
                course.setEducator(newEducator);
                course.setSchool(newSchool);
            } else {
                throw new RuntimeException("Course not found with ID: " + id);
            }
        });
    }

    public void delete(String id) {
        inTransaction(em -> {
            Course course = em.find(Course.class, id);
            if (course != null) {
                em.remove(course);
            }
        });
    }
    public void addStudentToCourse(String id, Student student) {
        inTransaction(em -> {
            // Fetch the course by its ID
            Course course = em.find(Course.class, id);

            if (course == null) {
                throw new RuntimeException("Course not found with ID: " + id);
            }

            // Check if the student is already enrolled in the course
            if (course.getStudents().contains(student)) {
                throw new RuntimeException("Student is already enrolled in the course.");
            }

            // Add the student to the course's students list
            course.getStudents().add(student);

            // Persist the changes
            em.merge(course);
        });
}
