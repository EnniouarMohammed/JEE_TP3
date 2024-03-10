package com.tpjee.tp3.dao.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Name;
    private String Matricule;

    @ManyToMany(mappedBy = "studentsList")
    private Collection<Session> sessionList = new ArrayList<>();

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + Name + '\'' +
                ", matricule='" + Matricule + '\'' +
                '}';
    }
}
