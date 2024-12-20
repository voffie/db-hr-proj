package se.iths.statistics;

public record StudentsPerCourse(String courseID, long students) {

    @Override
    public String toString() {
        return "Course ID = '" + courseID + "', Students = " + students;
    }
}
