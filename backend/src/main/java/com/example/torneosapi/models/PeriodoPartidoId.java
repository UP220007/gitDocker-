package com.example.torneosapi.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PeriodoPartidoId implements Serializable {

    private Integer idPartido;
    private Integer numeroPeriodo;

    // Getters, Setters, Equals y HashCode
    public Integer getIdPartido() { return idPartido; }
    public void setIdPartido(Integer idPartido) { this.idPartido = idPartido; }

    public Integer getNumeroPeriodo() { return numeroPeriodo; }
    public void setNumeroPeriodo(Integer numeroPeriodo) { this.numeroPeriodo = numeroPeriodo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PeriodoPartidoId)) return false;
        PeriodoPartidoId that = (PeriodoPartidoId) o;
        return idPartido.equals(that.idPartido) && numeroPeriodo.equals(that.numeroPeriodo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPartido, numeroPeriodo);
    }
}
