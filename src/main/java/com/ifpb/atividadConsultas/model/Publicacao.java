package com.ifpb.atividadConsultas.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Publicacao implements Serializable {

    @Id
    private int codPublicacao;
    private String titulo;
    @ManyToOne
    private Escritor escritor;
    @ManyToOne
    private Revisor revisor;
    @OneToMany
    private List<Area> areas;

    public Publicacao(int codPublicacao, String titulo, Escritor escritor, Revisor revisor, List<Area> areas) {
        this.codPublicacao = codPublicacao;
        this.titulo = titulo;
        this.escritor = escritor;
        this.revisor = revisor;
        this.areas = areas;
    }

    public Publicacao(int codPublicacao, String titulo, List<Area> areas) {
        this.codPublicacao = codPublicacao;
        this.titulo = titulo;
        this.areas = areas;
    }

    public int getCodPublicacao() {
        return codPublicacao;
    }

    public void setCodPublicacao(int codPublicacao) {
        this.codPublicacao = codPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Escritor getEscritor() {
        return escritor;
    }

    public void setEscritor(Escritor escritor) {
        this.escritor = escritor;
    }

    public Revisor getRevisor() {
        return revisor;
    }

    public void setRevisor(Revisor revisor) {
        this.revisor = revisor;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publicacao)) return false;
        Publicacao that = (Publicacao) o;
        return getCodPublicacao() == that.getCodPublicacao() &&
                Objects.equals(getTitulo(), that.getTitulo()) &&
                Objects.equals(getEscritor(), that.getEscritor()) &&
                Objects.equals(getRevisor(), that.getRevisor()) &&
                Objects.equals(getAreas(), that.getAreas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodPublicacao(), getTitulo(), getEscritor(), getRevisor(), getAreas());
    }

    @Override
    public String toString() {
        return "Publicacao{" +
                "codPublicacao=" + codPublicacao +
                ", titulo='" + titulo + '\'' +
                ", escritor=" + escritor +
                ", revisor=" + revisor +
                ", areas=" + areas +
                '}';
    }
}
