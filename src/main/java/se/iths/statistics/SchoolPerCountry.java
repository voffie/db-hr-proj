package se.iths.statistics;

public record SchoolPerCountry(String name, long count) {
    @Override
    public String toString() {
        return "SchoolPerCountry {" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
