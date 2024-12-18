package se.iths;

import se.iths.entity.Course;
import se.iths.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

public class Courses {
    final CourseRepository courseRepo = new CourseRepository();
    final EducatorRepository educatorRepo = new EducatorRepository();
    final SchoolRepository schoolRepo = new SchoolRepository();
//    final StudentRepository studentRepo = new StudentRepository();

    public void save(String id, String name, String educatorName, String schoolName) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Course ID cannot be null or empty");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Course name cannot be null or empty");
        }

        Optional<Educator> educator = educatorRepo.findByName(educatorName);
        Optional<School> school = schoolRepo.findByName(schoolName);
//        Optional<Student> student = studentRepo.findByName(studentName);

        if (educator.isPresent() && school.isPresent()) {
            Course course = new Course();
            course.setId(id);
            course.setName(name);
            course.setEducator(educator.get());
            course.setSchool(school.get());
            courseRepo.save(course);
        } else {
            throw new IllegalArgumentException("Invalid educator or school");
        }
    }

    public Course findById(String id) {
        Optional<Course> course = courseRepo.findById(id);
        return course.orElse(null);
    }

    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    public void update(String id, String newName, String newEducatorName, String newSchoolName) {
        Optional<Educator> newEducator = educatorRepo.findByName(newEducatorName);
        Optional<School> newSchool = schoolRepo.findByName(newSchoolName);

        if (newEducator.isPresent() && newSchool.isPresent()) {
            courseRepo.update(id, newName, newEducator.get(), newSchool.get());
        } else {
            throw new IllegalArgumentException("Invalid educator or school");
        }
    }

    public void delete(String id) {
        courseRepo.delete(id);
    }
    public void addStudentToCourse(String courseId, String studentName) {
        Optional<Student> student = studentRepo.findByName(studentName);
        if (student.isPresent()) {
            courseRepo.addStudentToCourse(courseId, student.get());
        } else {
            throw new IllegalArgumentException("Student not found");
        }
    }
}
