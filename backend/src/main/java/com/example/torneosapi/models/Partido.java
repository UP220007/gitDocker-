package com.example.torneosapi.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "partidos")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPartido;

    @ManyToOne
    @JoinColumn(name = "id_torneo", nullable = false)
    private Torneo torneo;

    @ManyToOne
    @JoinColumn(name = "id_equipo1", nullable = false)
    private Equipo equipo1;

    @ManyToOne
    @JoinColumn(name = "id_equipo2", nullable = false)
    private Equipo equipo2;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String resultado;

    // Getters y Setters
    public Integer getIdPartido() { return idPartido; }
    public void setIdPartido(Integer idPartido) { this.idPartido = idPartido; }

    public Torneo getTorneo() { return torneo; }
    public void setTorneo(Torneo torneo) { this.torneo = torneo; }

    public Equipo getEquipo1() { return equipo1; }
    public void setEquipo1(Equipo equipo1) { this.equipo1 = equipo1; }

    public Equipo getEquipo2() { return equipo2; }
    public void setEquipo2(Equipo equipo2) { this.equipo2 = equipo2; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
}
