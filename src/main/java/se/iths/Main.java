package se.iths;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.w3c.dom.ls.LSOutput;
import se.iths.entity.Country;
import se.iths.repository.CountryRepository;

import static se.iths.JPAUtil.getEntityManager;
import static se.iths.JPAUtil.inTransaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CountryRepository repo = new CountryRepository();
        EntityManager em = getEntityManager();


        System.out.println(repo.findAllCountries());

    }
}
