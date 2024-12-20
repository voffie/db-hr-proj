package se.iths.statistics;

public record StudentsPerCourse(String courseName, long students) {

    @Override
    public String toString() {
        return students + " students are enrolled in " + courseName;
    }
}
