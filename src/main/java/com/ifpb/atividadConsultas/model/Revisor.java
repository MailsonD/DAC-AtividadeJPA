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
public class Revisor extends Pessoa implements Serializable {

    private String nota;
    @OneToMany(mappedBy = "revisor", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Publicacao> publicacoes;

    public Revisor() {
    }

    public Revisor(String nome, LocalDate dataNascimento, String nota, List<Publicacao> publicacoes) {
        super(nome, dataNascimento);
        this.nota = nota;
        this.publicacoes = publicacoes;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
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
        if (!(o instanceof Revisor)) return false;
        if (!super.equals(o)) return false;
        Revisor revisor = (Revisor) o;
        return Objects.equals(getNota(), revisor.getNota()) &&
                Objects.equals(getPublicacoes(), revisor.getPublicacoes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNota(), getPublicacoes());
    }

    @Override
    public String toString() {
        return "Revisor{" +
                "nota='" + nota + '\'' +
                "} " + super.toString();
    }
}
