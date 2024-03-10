package com.tpjee.tp3.dao.entities;
import jakarta.persistence.*;
import lombok.*;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@ToString
@NoArgsConstructor

public class Session {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    private Date h_start;
    private Date h_end;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("dd/mm/yy HH:mm");


    @ManyToOne
    private Course sessionCourse;

    @ManyToMany
    private Collection<Student> studentsList = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return dateFormat.format(date);
    }

    public void setDate(String date) throws ParseException {
        this.date = dateFormat.parse(date);
    }

    public String getStartTime() {
        return timeFormat.format(h_start);
    }

    public void setStartTime(String startTime) throws ParseException {
        this.h_start = timeFormat.parse(startTime);
    }

    public String getEndTime() {
        return timeFormat.format(h_end);

    }

    public void setEndTime(String endTime) throws ParseException {
        this.h_end = timeFormat.parse(endTime);
    }

    public void setSessionCourse(Course course){
        this.sessionCourse = course;
    }
    public Course getSessionCourse(){
        return sessionCourse;
    }

    public void setStudentsList(Collection<Student>s){
        this.studentsList = s;
    }

    public Collection<Student> getStudentsList(){
        return studentsList;
    }
    public Session(Integer id, String date, String startTime, String endTime, Course sessionCourse, Collection<Student> studentsList ) throws ParseException{

        this.id = id;
        this.date = dateFormat.parse(date);
        this.h_start = timeFormat.parse(startTime);
        this.h_end = timeFormat.parse(endTime);
        this.sessionCourse = sessionCourse;
        this.studentsList = studentsList;
    }
}
