package se.iths.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="school", schema = "db_proj")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "school", fetch = FetchType.LAZY)
    private List<Educator> educators;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return name + ", " + country;
    }
}
