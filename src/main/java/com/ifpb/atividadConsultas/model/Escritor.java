package com.ifpb.atividadConsultas.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Escritor extends Pessoa implements Serializable {

    private int premios;
    @OneToMany(mappedBy = "escritor", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Publicacao> publicacoes;

    public Escritor() {

    }

    public Escritor(String nome, LocalDate dataNascimento, int premios, List<Publicacao> publicacoes) {
        super(nome, dataNascimento);
        this.premios = premios;
        this.publicacoes = publicacoes;
    }

    public int getPremios() {
        return premios;
    }

    public void setPremios(int premios) {
        this.premios = premios;
    }

    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Escritor)) return false;
        if (!super.equals(o)) return false;
        Escritor escritor = (Escritor) o;
        return getPremios() == escritor.getPremios() &&
                Objects.equals(getPublicacoes(), escritor.getPublicacoes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPremios(), getPublicacoes());
    }

    @Override
    public String toString() {
        return "Escritor{" +
                "premios=" + premios +
                "} " + super.toString();
    }
}
