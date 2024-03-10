package com.tpjee.tp3.dao.repositories;

import com.tpjee.tp3.dao.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
