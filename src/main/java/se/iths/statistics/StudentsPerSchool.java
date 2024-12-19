package se.iths.statistics;

public record StudentsPerSchool(String name, long count) {
    @Override
    public String toString() {
        return "StudentsPerSchool {" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
