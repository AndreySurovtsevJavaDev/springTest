package ru.surovcev.project.springtest.model;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public int getAge() {return age;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public void setAge(int age) {this.age = age;}

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
