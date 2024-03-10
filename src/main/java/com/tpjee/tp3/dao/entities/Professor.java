package com.tpjee.tp3.dao.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

@Entity
@NoArgsConstructor
@ToString
public class Professor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Date d_affectation;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

    @Setter @Getter
    @OneToOne(mappedBy = "courseGivenByProfessor")
    private Course courseToGive;

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

    public String getD_affectation() {
        return dateFormat.format(d_affectation);
    }

    public void setD_affectation(String d_affectation) throws ParseException {
        this.d_affectation = dateFormat.parse(d_affectation);
    }

    public Professor(Integer id, String name, String d_affectation,Course courseToGive) throws ParseException {
        this.id = id;
        this.name = name;
        this.d_affectation = dateFormat.parse(d_affectation);
        this.courseToGive = courseToGive;
    }
    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", d_affectation=" + dateFormat.format(d_affectation) +
                '}';
    }
}
