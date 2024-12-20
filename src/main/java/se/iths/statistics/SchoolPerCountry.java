package se.iths.statistics;

public record SchoolPerCountry(String countryName, long schools) {
    @Override
    public String toString() {
        return countryName + " has " + schools + " schools";

    }
}
