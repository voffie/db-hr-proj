package se.iths;

import se.iths.entity.Student;
import se.iths.entity.Course;
import se.iths.entity.School;
import se.iths.entity.Country;
import se.iths.repository.StudentRepository;
import se.iths.repository.CourseRepository;
import se.iths.repository.SchoolRepository;
import se.iths.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

    public class Students {
        final StudentRepository studentRepo = new StudentRepository();

        public void save(String name) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
            if (studentRepo.findByName(name).isPresent()) {
                throw new IllegalArgumentException("Student with name: " + name + " already exists");
            }
            Student newStudent = new Student();
            newStudent.setName(name);

            studentRepo.save(newStudent);
        }

        public List<Student> findAll() {
            return studentRepo.findAll();
        }

        public Student findByName(String name) {
            Optional<Student> student = studentRepo.findByName(name);
            return student.orElse(null);
        }

        public void update(String oldName, String newName) {
            if (oldName == null || oldName.isBlank()) {
                throw new IllegalArgumentException("Old name cannot be null or empty");
            }
            if (newName == null || newName.isBlank()) {
                throw new IllegalArgumentException("New name cannot be null or empty");
            }
            studentRepo.findByName(oldName).ifPresent(student ->{
                studentRepo.update(student.getName(), newName);
            });
        }

        public void delete(String name) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
            if (studentRepo.findByName(name).isPresent()) {
                Student student = studentRepo.findByName(name).get();
                studentRepo.delete(student.getName());
            }
        }
    }
