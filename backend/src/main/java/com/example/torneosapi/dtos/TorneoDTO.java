package com.example.torneosapi.dtos;

import java.util.Date;

public class TorneoDTO {
    private Integer idTorneo;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private String organizadorNombre;

    // Getters y Setters
    public Integer getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Integer idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date date) {
        this.fechaFin = date;
    }

    public String getOrganizadorNombre() {
        return organizadorNombre;
    }

    public void setOrganizadorNombre(String organizadorNombre) {
        this.organizadorNombre = organizadorNombre;
    }
}
