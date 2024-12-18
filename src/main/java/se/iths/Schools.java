package se.iths;

import se.iths.entity.Country;
import se.iths.entity.School;
import se.iths.repository.SchoolRepository;

import java.util.List;

public class Schools {
    private final SchoolRepository schoolRepo = new SchoolRepository();

    public void save(String id, String name, Country country) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (schoolRepo.findById(id).isPresent()) {
            throw new IllegalArgumentException("School with ID " + id + " already exists");
        }

        School school = new School(id, name, country);
        schoolRepo.save(school);
    }

    public School findById(String id) {
        return schoolRepo.findById(id).orElse(null);
    }

    public void update(String id, String newName, Country newCountry) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }

        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("New name cannot be null or empty");
        }

        if (newCountry == null) {
            throw new IllegalArgumentException("New country cannot be null");
        }

        // Hämta skolan med det specifika ID:et
        School school = schoolRepo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("School with ID " + id + " does not exist"));

        // Uppdatera egenskaper
        school.setName(newName);
        school.setCountry(newCountry);

        // Spara uppdaterad skola
        schoolRepo.update(school);
    }

    public void save(String id, String name, Country country) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (country == null) {
            throw new IllegalArgumentException("Country cannot be null");
        }

        if (schoolRepo.findById(id).isPresent()) {
            throw new IllegalArgumentException("School with ID " + id + " already exists");
        }

        School school = new School(id, name, country);
        schoolRepo.save(school);
    }

    public List<School> findAll() {
        return schoolRepo.findAll();
    }

}
