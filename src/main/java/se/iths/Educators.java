package se.iths;

import se.iths.entity.Educator;
import se.iths.entity.School;
import se.iths.repository.EducatorRepository;
import se.iths.repository.SchoolRepository;

import java.util.List;
import java.util.Optional;

public class Educators {
    final EducatorRepository educatorRepo = new EducatorRepository();
    final SchoolRepository schoolRepo = new SchoolRepository();

    public void save(String name, String schoolName) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (schoolName == null || schoolName.isBlank()) {
            throw new IllegalArgumentException("School name cannot be null or empty");
        }

        if (educatorRepo.findByName(name).isPresent()) {
            throw new IllegalArgumentException("Educator with name " + name + " already exists");
        }

        Optional<School> school = schoolRepo.findByName(schoolName);
        school.ifPresent(entry -> {
            Educator educator = new Educator();
            educator.setName(name);
            educator.setSchool(entry);
            educatorRepo.save(educator);
        });
    }

    public Educator findByName(String name) {
        Optional<Educator> educator = educatorRepo.findByName(name);
        return educator.orElse(null);
    }

    public List<Educator> findAll() {
        return educatorRepo.findAll();
    }

    public void update(String oldName, String newName, School newSchool) {
        if (oldName == null || oldName.isBlank()) {
            throw new IllegalArgumentException("Old name cannot be null or empty");
        }

        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("New name cannot be null or empty");
        }

        if (newSchool == null) {
            throw new IllegalArgumentException("New school cannot be null");
        }

        educatorRepo.findByName(oldName).ifPresent(educator -> {
            educatorRepo.update(educator.getId(), newName);
        });
    }

    public void delete(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        educatorRepo.findByName(name).ifPresent(educator -> {
            educatorRepo.delete(educator.getId());
        });
    }
}
