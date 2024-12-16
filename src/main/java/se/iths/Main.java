package se.iths;

import jakarta.persistence.EntityManager;
import se.iths.repository.CountryRepository;
import se.iths.entity.Country;
import static se.iths.JPAUtil.getEntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = getEntityManager();
        CountryRepository repo = new CountryRepository();
        Countries countries = new Countries();
        System.out.println(repo.findAllCountries());
        System.out.println(repo.findCountryWithName("Sweden"));
        countries.addCountry("Test");
        System.out.println(repo.findAllCountries());

    }
}
