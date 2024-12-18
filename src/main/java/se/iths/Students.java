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
            Optional<Country> country = countryRepo.findByName();

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

        public void update(int studentId, String newName, String newSchoolId, String newCourseId, int newCountryId) {
            if (newName == null || newName.isBlank()) {
                throw new IllegalArgumentException("New name cannot be null or empty");
            }

            Optional<School> newSchool = schoolRepo.findById(newSchoolId);
            Optional<Course> newCourse = courseRepo.findById(newCourseId);
            Optional<Country> newCountry = countryRepo.findById(newCountryId);

            if (newSchool.isPresent() && newCourse.isPresent() && newCountry.isPresent()) {
                studentRepo.findById(studentId).ifPresent(student -> {
                    student.setName(newName);
                    student.setSchool(newSchool.get());
                    student.setCourse(newCourse.get());
                    student.setCountry(newCountry.get());
                    studentRepo.save(student);  // Uppdatera student i databasen
                });
            } else {
                throw new IllegalArgumentException("Invalid school, course, or country");
            }
        }


        public void delete(int studentId) {
            studentRepo.findById(studentId).ifPresent(student -> {
                studentRepo.delete(studentId);
            });
        }

        public void addStudentToCourse(int studentId, String courseId) {
            Optional<Student> student = studentRepo.findById(studentId);
            Optional<Course> course = courseRepo.findById(courseId);

            if (student.isPresent() && course.isPresent()) {
                studentRepo.addStudentToCourse(student.get(), course.get());
            } else {
                throw new IllegalArgumentException("Student or course not found");
            }
        }
    }
