package se.iths;

import se.iths.entity.School;

public class Main {
    public static void main(String[] args) {
        Schools schools = new Schools();

        // Skapa skolor
        schools.save("Hogwarts");
        schools.save("Beauxbatons");
        schools.save("Durmstrang");

        // Hämta och visa alla skolor
        System.out.println("Alla skolor:");
        schools.findAll().forEach(school -> System.out.println(school.getName()));

        // Uppdatera en skola
        System.out.println("\nUppdaterar Hogwarts...");
        schools.update("Hogwarts", "Hogwarts School of Witchcraft and Wizardry");

        // Visa uppdaterade skolor
        System.out.println("\nUppdaterade skolor:");
        schools.findAll().forEach(school -> System.out.println(school.getName()));

        // Ta bort en skola
        System.out.println("\nTar bort Beauxbatons...");
        schools.delete("Beauxbatons");

        // Visa kvarvarande skolor
        System.out.println("\nKvarvarande skolor:");
        schools.findAll().forEach(school -> System.out.println(school.getName()));
    }
}
