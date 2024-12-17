package se.iths;

import jakarta.persistence.*;

@Entity
@Table(name = "courses", schema = "db_proj")

public class Course {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "educator", nullable = false)
    private Educator educator;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "school", nullable = false)
    private School school;

    // Getters and Setters
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

    public Educator getEducator() {
        return educator;
    }

    public void setEducator(Educator educator) {
        this.educator = educator;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Course { " +
                "id = '" + id + '\'' +
                ", name = '" + name + '\'' +
                " }";
    }
}
