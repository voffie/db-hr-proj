package se.iths;

import jakarta.persistence.EntityManager;
import se.iths.repository.CountryRepository;

import static se.iths.JPAUtil.getEntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = getEntityManager();
        CountryRepository repo = new CountryRepository();
        Countries countries = new Countries();
        System.out.println(repo.findAll());
        System.out.println(repo.findWithName("Sweden"));
        countries.save("Test");
        System.out.println(repo.findAll());
        System.out.println("update test");
        countries.update("Test", "Test1");
        System.out.println(repo.findAll());
        countries.delete("Test1");
        System.out.println(repo.findAll());
    }
}
