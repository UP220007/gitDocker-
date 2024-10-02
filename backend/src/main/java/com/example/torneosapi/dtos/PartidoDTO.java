package com.example.torneosapi.dtos;

import java.util.Date;

public class PartidoDTO {

    private Integer idPartido;
    private String torneoNombre;
    private String equipo1Nombre;
    private String equipo2Nombre;
    private Date fecha;
    private String resultado;

    // Getters y Setters
    public Integer getIdPartido() { return idPartido; }
    public void setIdPartido(Integer idPartido) { this.idPartido = idPartido; }

    public String getTorneoNombre() { return torneoNombre; }
    public void setTorneoNombre(String torneoNombre) { this.torneoNombre = torneoNombre; }

    public String getEquipo1Nombre() { return equipo1Nombre; }
    public void setEquipo1Nombre(String equipo1Nombre) { this.equipo1Nombre = equipo1Nombre; }

    public String getEquipo2Nombre() { return equipo2Nombre; }
    public void setEquipo2Nombre(String equipo2Nombre) { this.equipo2Nombre = equipo2Nombre; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
}
