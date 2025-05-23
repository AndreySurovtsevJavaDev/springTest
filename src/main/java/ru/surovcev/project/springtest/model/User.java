package ru.surovcev.project.springtest.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

//    @Override
//    public String toString() {
//        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
//    }

//    public long getId() {return id;}
//    public void setId(long id) {this.id = id;}
//
//    public String getName() {return name;}
//    public void setName(String name) {this.name = name;}
//
//    public int getAge() {return age;}
//
//    public void setAge(int age) {this.age = age;}
}
