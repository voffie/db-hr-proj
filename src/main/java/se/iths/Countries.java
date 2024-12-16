package se.iths;

import se.iths.entity.Country;
import se.iths.repository.CountryRepository;

public class Countries {
    CountryRepository repo  = new CountryRepository();

    public void addCountry(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (repo.findCountryWithName(name).isPresent()) {
            throw new IllegalArgumentException("Country with name " + name + " already exists");
        }
        Country newCountry = new Country();
        newCountry.setName(name);

        repo.save(newCountry);


    }
}
