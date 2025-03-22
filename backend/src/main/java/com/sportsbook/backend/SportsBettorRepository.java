package com.sportsbook.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportsBettorRepository extends JpaRepository<SportsBettor, Long> {
}
