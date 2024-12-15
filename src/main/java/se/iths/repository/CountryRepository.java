package se.iths.repository;

import static se.iths.JPAUtil.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import se.iths.JPAUtil;
import se.iths.entity.Country;

import java.util.List;
import java.util.Optional;


public class CountryRepository {

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
    public List<Country> findAllCountries() {
        EntityManager em = getEntityManager();
        return em.createQuery("FROM Country ", Country.class).getResultList();
    }

}
