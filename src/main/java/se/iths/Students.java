package se.iths;

import se.iths.entity.School;
import se.iths.entity.Course;
import se.iths.entity.Country;
import se.iths.entity.Student;
import se.iths.repository.StudentRepository;
import se.iths.repository.SchoolRepository;
import se.iths.repository.CourseRepository;
import se.iths.repository.CountryRepository;
import se.iths.statistics.StudentsPerCourse;

import java.util.List;
import java.util.Optional;

    public class Students {
        final StudentRepository studentRepo = new StudentRepository();
        final SchoolRepository schoolRepo = new SchoolRepository();
        final CourseRepository courseRepo = new CourseRepository();
        final CountryRepository countryRepo = new CountryRepository();

        public void save(String name, String schoolName, String courseId, String countryName) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
            if (schoolName == null || schoolName.isBlank()) {
                throw new IllegalArgumentException("School cannot be null or empty");
            }
            if (courseId == null || courseId.isBlank()) {
                throw new IllegalArgumentException("Course cannot be null or empty");
            }
            if (countryName == null || countryName.isBlank()) {
                throw new IllegalArgumentException("Country cannot be null or empty");
            }

            if (studentRepo.findByName(name).isPresent()) {
                throw new IllegalArgumentException("Student with name: " + name + " already exists");
            }

            Optional<School> school = schoolRepo.findByName(schoolName);
            Optional<Course> course = courseRepo.findById(courseId);
            Optional<Country> country = countryRepo.findByName(countryName);

            if (school.isPresent() && course.isPresent() && country.isPresent()) {
                Student newStudent = new Student();
                newStudent.setName(name);
                newStudent.setSchool(school.get());
                newStudent.setCourse(course.get());
                newStudent.setCountry(country.get());
                studentRepo.save(newStudent);
                System.out.println("Student saved successfully: " + name);
            } else {
                throw new IllegalArgumentException("Student with name: " + name + " does not exist");
            }
        }

        public List<Student> findAll() {
            return studentRepo.findAll();
        }

        public Student findByName(String name) {
            Optional<Student> student = studentRepo.findByName(name);
            return student.orElse(null);
        }

        public void update(String oldName, String newName, String updateStudentCourse) {
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
