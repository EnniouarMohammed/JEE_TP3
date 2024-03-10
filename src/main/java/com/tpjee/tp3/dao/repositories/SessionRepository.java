package com.tpjee.tp3.dao.repositories;

import com.tpjee.tp3.dao.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Integer> {
}
