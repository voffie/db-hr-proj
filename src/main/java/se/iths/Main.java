package se.iths;

import se.iths.entity.School;
import se.iths.entity.Country;

public class Main {
    public static void main(String[] args) {
        Schools schools = new Schools();

        // Lägg till länder
        Country sweden = new Country("SE", "Sweden");
        countries.save(sweden);
        Countries countries = new Countries();

        // Skapa skolor
        schools.save("Hogwarts", "Hogwarts School of Witchcraft and Wizardry", sweden);
        schools.save("Beauxbatons", "Beauxbatons Academy of Magic", sweden);
        schools.save("Durmstrang", "Durmstrang Institute", sweden);

        // Hämta och visa alla skolor
        System.out.println("Alla skolor:");
        schools.findAll().forEach(school -> System.out.println(school.getName()));

        // Uppdatera en skola
        System.out.println("\nUppdaterar Hogwarts...");
        schools.update("Hogwarts", "Hogwarts School of Witchcraft and Wizardry", sweden);

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
