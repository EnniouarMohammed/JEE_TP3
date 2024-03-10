package com.tpjee.tp3.dao.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Course {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String description;


    @OneToOne
    private Professor courseGivenByProfessor;

    @OneToMany(mappedBy = "sessionCourse")
    private Collection<Session> SessionList = new ArrayList<>();

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", courseGivenByProfessor=" + courseGivenByProfessor +
                ", sessionList=" + SessionList +
                '}';
    }
}