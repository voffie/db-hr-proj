package se.iths.statistics;

public record StudentsPerCourse(String name, long count) {

    @Override
    public String toString() {
        return "StudentsPerCourse {" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
