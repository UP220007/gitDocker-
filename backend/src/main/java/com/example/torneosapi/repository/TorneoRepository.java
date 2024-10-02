package com.example.torneosapi.repository;

import com.example.torneosapi.models.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneoRepository extends JpaRepository<Torneo, Integer> {
}
