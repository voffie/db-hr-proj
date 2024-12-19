package se.iths;

import se.iths.entity.Country;
import se.iths.entity.School;
import se.iths.repository.CountryRepository;
import se.iths.repository.SchoolRepository;
import se.iths.statistics.StudentsPerSchool;

import java.util.List;
import java.util.Optional;

public class Schools {
    private final SchoolRepository schoolRepo = new SchoolRepository();
    private final CountryRepository countryRepo = new CountryRepository();

    public void save(String name, String newCountry) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (schoolRepo.findByName(name).isPresent()) {
            throw new IllegalArgumentException("School with name " + name + " already exists");
        }

        Optional<Country> country = countryRepo.findByName(newCountry);
        country.ifPresent(entry -> {
            School school = new School();
            school.setCountry(entry);
            schoolRepo.save(school);
        });
    }

    public void findByName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        schoolRepo.findByName(name);
    }

    public void update(String name, String newName, Country newCountry) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("New name cannot be null or empty");
        }

        if (newCountry == null) {
            throw new IllegalArgumentException("New country cannot be null");
        }

        // Hämta skolan med det specifika ID:et
        School school = schoolRepo.findByName(name).orElseThrow(() ->
                new IllegalArgumentException("School with name " + name + " does not exist"));

        // Uppdatera egenskaper
        school.setName(newName);
        school.setCountry(newCountry);

        // Spara uppdaterad skola
        schoolRepo.update(school);
    }

    public void delete(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        // Hämta skolan med det specifika namnet
        School school = schoolRepo.findByName(name).orElseThrow(() ->
            new IllegalArgumentException("School with name " + name + " does not exist"));

        // Radera skolan
        schoolRepo.delete(String.valueOf(school));
    }

    public List<School> findAll() {
        return schoolRepo.findAll();
    }

    public List<StudentsPerSchool> studentsPerSchool() {
        return schoolRepo.studentsPerSchool();
    }
}
