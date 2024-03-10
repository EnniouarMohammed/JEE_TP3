package com.tpjee.tp3.dao.repositories;

import com.tpjee.tp3.dao.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
