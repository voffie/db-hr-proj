package se.iths;

import se.iths.entity.Country;
import se.iths.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

public class Countries {
    CountryRepository repo  = new CountryRepository();

    public void save(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (repo.findByName(name).isPresent()) {
            throw new IllegalArgumentException("Country with name " + name + " already exists");
        }
        Country newCountry = new Country();
        newCountry.setName(name);

        repo.save(newCountry);
    }
    public List<Country> findAll(){
        return repo.findAll();
    }

    public Country findByName(String name) {
        Optional<Country> country = repo.findByName(name);
        return country.orElse(null);

    }

    public void update(String oldName, String newName) {
        if (oldName == null || oldName.isBlank()) {
            throw new IllegalArgumentException("Old name cannot be null or empty");
        }
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("New name cannot be null or empty");
        }
        repo.findByName(oldName).ifPresent(country ->{
            repo.update(country.getId(), newName);
        });
    }
    public void delete(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (repo.findByName(name).isPresent()) {
            Country country = repo.findByName(name).get();
            repo.delete(country.getId());
        }
    }
}
