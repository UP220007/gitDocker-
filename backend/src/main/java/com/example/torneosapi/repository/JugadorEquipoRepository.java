package com.example.torneosapi.repository;

import com.example.torneosapi.models.JugadorEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorEquipoRepository extends JpaRepository<JugadorEquipo, Integer> {
}
