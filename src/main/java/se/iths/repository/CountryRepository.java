package se.iths.repository;

import static se.iths.JPAUtil.*;

import jakarta.persistence.EntityManager;
import se.iths.entity.Country;
import se.iths.statistics.SchoolPerCountry;
import se.iths.statistics.StudentsPerCountry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CountryRepository {

    //Add country to table
    public void save(Country country) {
        inTransaction(em -> em.persist(country));
    }

    //Show all countries
    public List<Country> findAll() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT c FROM Country c ", Country.class).getResultList();
    }
    //Show specific country
    public Optional<Country> findByName(String name) {
        EntityManager em = getEntityManager();
        try {
            return Optional.of(em.createQuery("SELECT c FROM Country c WHERE c.name = : name", Country.class)
                    .setParameter("name", name)
                    .getSingleResult());
        }catch (RuntimeException e) {
            return Optional.empty();
        }
    }

    public void update(int id, String newName) {
        inTransaction(entityManager -> {
            Country country = entityManager.find(Country.class, id);
            country.setName(newName);
        });
    }
    public void delete(int id) {
        inTransaction(entityManager -> {
            Country country = entityManager.find(Country.class, id);
            entityManager.remove(country);
        });
    }

    public List<StudentsPerCountry> studentsPerCountry() {
        List<StudentsPerCountry> output = new ArrayList<>();
        inTransaction(entityManager -> {
            output.addAll(entityManager.createQuery("SELECT new se.iths.statistics.StudentsPerCountry(c.name, COUNT(st.id)) " +
                            "FROM Country c " +
                            "INNER JOIN Student st on c.id = st.country.id " +
                            "GROUP BY c.name", StudentsPerCountry.class)
                    .getResultList());
        });
        return output;
    }
    public List<SchoolPerCountry> schoolPerCountry() {
        List<SchoolPerCountry> output = new ArrayList<>();
        inTransaction(entityManager -> {
            output.addAll(entityManager.createQuery("SELECT new se.iths.statistics.StudentsPerCountry(c.name, COUNT(sc.id)) " +
                            "FROM Country c " +
                            "INNER JOIN School sc on c.id = sc.country.id " +
                            "GROUP BY c.name ", SchoolPerCountry.class)
                    .getResultList());
        });
        return output;
    }
}
