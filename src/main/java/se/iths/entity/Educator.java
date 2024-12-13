package se.iths.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "educator", schema = "db_proj")
public class Educator {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private School school;

    @OneToMany(mappedBy = "educator", fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList();

    public List<Course> getCourses() {
        return courses;
    }

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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Educator { " +
                "id = " + id +
                ", name = '" + name + "'" +
                " }";
    }
}
