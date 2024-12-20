package se.iths.statistics;

public record StudentsPerSchool(String schoolName, long students) {
    @Override
    public String toString() {
        return schoolName + " has " + students + " students";
    }
}
