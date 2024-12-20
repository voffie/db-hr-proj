package se.iths.statistics;

public record SchoolPerCountry(String schoolName, long countries) {
    @Override
    public String toString() {
        return "School name = '" + schoolName + "', Countries=" + countries;
    }
}
