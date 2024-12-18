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
        final CourseRepository courseRepo = new CourseRepository();
        final SchoolRepository schoolRepo = new SchoolRepository();
        final CountryRepository countryRepo = new CountryRepository();

        public void save(String name, String schoolId, String courseId, int countryId) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }

            Optional<School> school = schoolRepo.findById(schoolId);
            Optional<Course> course = courseRepo.findById(courseId);
            Optional<Country> country = countryRepo.findByName(name);

            if (school.isPresent() && course.isPresent() && country.isPresent()) {
                Student student = new Student();
                student.setName(name);
                student.setSchool(school.get());
                student.setCourse(course.get());
                student.setCountry(country.get());

                studentRepo.save(student);
            } else {
                throw new IllegalArgumentException("Invalid school, course, or country");
            }
        }

        public List<Student> findAll() {
            return studentRepo.findAll();
        }

        public Student findByName(String name) {
            Optional<Student> student = studentRepo.findByName(name);
            return student.orElse(null);
        }

        public void update(String oldName, String newName) {
            if (newName == null || newName.isBlank()) {
                throw new IllegalArgumentException("New name cannot be null or empty");
            }
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

        public void addStudentToCourse(String studentName, String courseId) {
            Optional<Student> student = studentRepo.findByName(studentName);
            Optional<Course> course = courseRepo.findById(courseId);

            if (student.isPresent() && course.isPresent()) {
                studentRepo.addStudentToCourse(student.get(), course.get());
            } else {
                throw new IllegalArgumentException("Student or course not found");
            }
        }
    }
