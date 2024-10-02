package com.example.torneosapi.repository;

import com.example.torneosapi.models.PeriodoPartido;
import com.example.torneosapi.models.PeriodoPartidoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoPartidoRepository extends JpaRepository<PeriodoPartido, PeriodoPartidoId> {
}
