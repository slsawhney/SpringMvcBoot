package com.foodelthy.springmvcboot.student.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students") // optional, but recommended to control table name
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // optional
    private Integer id;   // use Integer so null indicates "not persisted yet"

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    // Required by JPA
    public Student() {}

    // Convenience constructor for new students (no id)
    public Student(String name) {
        this.name = name;
    }

    // Getters only for id; avoid public setter to prevent manual assignment
    public Integer getId() {
        return id;
    }

    // If you must keep a setter, make it protected to discourage use
    protected void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
