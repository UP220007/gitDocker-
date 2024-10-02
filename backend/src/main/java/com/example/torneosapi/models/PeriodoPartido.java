package com.example.torneosapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "periodos_partido")
public class PeriodoPartido {

    @EmbeddedId
    private PeriodoPartidoId id;

    private Integer duracionMinutos;

    // Getters y Setters
    public PeriodoPartidoId getId() { return id; }
    public void setId(PeriodoPartidoId id) { this.id = id; }

    public Integer getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(Integer duracionMinutos) { this.duracionMinutos = duracionMinutos; }
}
