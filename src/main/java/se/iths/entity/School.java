package se.iths.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class School {

    @Id
    @Column(nullable = false, unique = true)
    private String id; // Använd String för skol-ID

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Educator> educators;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public School() {
    }

    public School(String id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Educator> getEducators() {
        return educators;
    }

    public void setEducators(List<Educator> educators) {
        this.educators = educators;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}