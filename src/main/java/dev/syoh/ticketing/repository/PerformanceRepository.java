package dev.syoh.ticketing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.syoh.ticketing.domain.Performance;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {
}
