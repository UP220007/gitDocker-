package com.example.torneosapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "jugadores_equipos")
public class JugadorEquipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_jugador", nullable = false)
    private Usuario jugador;

    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Usuario getJugador() { return jugador; }
    public void setJugador(Usuario jugador) { this.jugador = jugador; }

    public Equipo getEquipo() { return equipo; }
    public void setEquipo(Equipo equipo) { this.equipo = equipo; }
}
