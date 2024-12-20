package se.iths;

import se.iths.entity.Course;
import se.iths.entity.Educator;
import se.iths.entity.School;
import se.iths.entity.Student;
import se.iths.repository.CourseRepository;
import se.iths.repository.EducatorRepository;
import se.iths.repository.SchoolRepository;
import se.iths.repository.StudentRepository;
import se.iths.statistics.StudentsPerCourse;

import java.util.List;
import java.util.Optional;

public class Courses {
    final CourseRepository courseRepo = new CourseRepository();
    final EducatorRepository educatorRepo = new EducatorRepository();
    final SchoolRepository schoolRepo = new SchoolRepository();
    final StudentRepository studentRepo = new StudentRepository();

    public void save(String id, String name, String educatorName, String schoolId) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Course ID cannot be null or empty");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Course name cannot be null or empty");
        }

        Optional<Educator> educator = educatorRepo.findByName(educatorName);
        Optional<School> school = schoolRepo.findByName(schoolId);

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

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Course ID cannot be null or empty");
        }

        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("New name cannot be null or empty");
        }

        if (newEducatorName == null || newEducatorName.isBlank()) {
            throw new IllegalArgumentException("Educator name cannot be null or empty");
        }

        if (newSchoolName == null || newSchoolName.isBlank()) {
            throw new IllegalArgumentException("School name cannot be null or empty");
        }

        courseRepo.findById(id).ifPresent(course -> {
            Optional<Educator> newEducator = educatorRepo.findByName(newEducatorName);
            Optional<School> newSchool = schoolRepo.findByName(newSchoolName);

            if (newEducator.isPresent() && newSchool.isPresent()) {
            courseRepo.update(course.getId(), newName, newEducator.get(), newSchool.get());
            }
        });
    }

    public void delete(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }

        courseRepo.findById(id).ifPresent(course -> courseRepo.delete(course.getId()));
    }

    public void addStudentToCourse(String courseId, String studentName) {
        Optional<Student> student = studentRepo.findByName(studentName);
        if (student.isPresent()) {
            courseRepo.addStudentToCourse(courseId, student.get());
        } else {
            throw new IllegalArgumentException("Student not found");
        }
    }

    public List<StudentsPerCourse> studentsPerCourse() {
        return courseRepo.studentsPerCourse();
    }
}
