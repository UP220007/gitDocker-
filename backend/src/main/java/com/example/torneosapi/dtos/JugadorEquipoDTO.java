package com.example.torneosapi.dtos;

public class JugadorEquipoDTO {
    private Integer id;
    private String jugadorNombre;
    private String equipoNombre;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getJugadorNombre() { return jugadorNombre; }
    public void setJugadorNombre(String jugadorNombre) { this.jugadorNombre = jugadorNombre; }

    public String getEquipoNombre() { return equipoNombre; }
    public void setEquipoNombre(String equipoNombre) { this.equipoNombre = equipoNombre; }
}
