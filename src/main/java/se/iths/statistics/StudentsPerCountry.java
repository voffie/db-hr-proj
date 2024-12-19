package se.iths.statistics;

public record StudentsPerCountry(String name, long count) {
    @Override
    public String toString() {
        return "StudentsPerCountry {" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
