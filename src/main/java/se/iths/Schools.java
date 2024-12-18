package se.iths;

import se.iths.entity.School;
import se.iths.repository.SchoolRepository;

import java.util.List;

public class Schools {
    private final SchoolRepository schoolRepository = new SchoolRepository();

    public void save(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("School name cannot be null or blank");
        }

        if (schoolRepository.findByName(name).isPresent()) {
            throw new IllegalArgumentException("A school with name " + name + " already exists");
        }

        schoolRepository.save(new School(name));
    }

    public School findByName(String name) {
        return schoolRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("School with name " + name + " not found"));
    }

    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    public void update(String currentName, String newName) {
        if (currentName == null || currentName.isBlank() || newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("School names cannot be null or blank");
        }

        School school = findByName(currentName);
        schoolRepository.update(school.getId(), newName);
    }

    public void delete(String name) {
        School school = findByName(name);
        schoolRepository.delete(school.getId());
    }
}
