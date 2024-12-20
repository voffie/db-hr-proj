package se.iths.statistics;

public record StudentsPerCountry(String countryName, long students) {
    @Override
    public String toString() {
        return "Country name = '" + countryName + "', Students=" + students;
    }
}
