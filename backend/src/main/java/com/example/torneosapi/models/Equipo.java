package com.example.torneosapi.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_equipo;
    
    private String nombre;
    private LocalDate fechaCreacion = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "id_organizador", nullable = false)
    private Usuario organizador;

    @ManyToOne
    @JoinColumn(name = "id_torneo", nullable = false)  // Nueva propiedad para la relación con Torneo
    private Torneo torneo;

    // Getters y Setters
    public Integer getId_equipo() {
        return id_equipo;
    }
    
    public void setId_equipo(Integer id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getOrganizador() {
        return organizador;
    }
    
    public void setOrganizador(Usuario organizador) {
        this.organizador = organizador;
    }

    public Torneo getTorneo() {
        return torneo;
    }
    
    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }
}
