package se.iths.repository;

import static se.iths.JPAUtil.*;

import jakarta.persistence.EntityManager;
import se.iths.entity.Country;

import java.util.List;
import java.util.Optional;


public class CountryRepository {

    //Add country to table
    public void save(Country country) {
        inTransaction(em -> em.persist(country));

    }

    //Show all countries
    public List<Country> findAllCountries() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT c FROM Country c ", Country.class).getResultList();
    }
    //Show specific country
    public Optional<Country> findCountryWithName(String name) {
        EntityManager em = getEntityManager();
        try {
            return Optional.of(em.createQuery("SELECT c FROM Country c WHERE c.name = : name", Country.class)
                    .setParameter("name", name)
                    .getSingleResult());
        }catch (RuntimeException e) {
            return Optional.empty();
        }
    }
}
