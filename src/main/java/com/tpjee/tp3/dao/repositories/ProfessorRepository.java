package com.tpjee.tp3.dao.repositories;

import com.tpjee.tp3.dao.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
