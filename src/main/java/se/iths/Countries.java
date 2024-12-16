package se.iths;

import se.iths.entity.Country;
import se.iths.repository.CountryRepository;

public class Countries {
    CountryRepository repo  = new CountryRepository();

    public void save(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (repo.findWithName(name).isPresent()) {
            throw new IllegalArgumentException("Country with name " + name + " already exists");
        }
        Country newCountry = new Country();
        newCountry.setName(name);

        repo.save(newCountry);
    }
    public void update(String oldName, String newName) {
        if (oldName == null || oldName.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (repo.findWithName(oldName).isPresent()) {
            Country country = repo.findWithName(oldName).get();
            country.setName(newName);
            repo.update(country.getId(), newName);
        }
    }
    public void delete(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (repo.findWithName(name).isPresent()) {
            Country country = repo.findWithName(name).get();
            repo.delete(country.getId());
        }
    }
}
