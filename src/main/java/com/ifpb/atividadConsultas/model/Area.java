package com.ifpb.atividadConsultas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Area implements Serializable {

    @Id
    private int cod;
    private String nome;


    public Area(int cod, String nome) {
        this.cod = cod;
        this.nome = nome;
    }

    public Area() {

    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Area)) return false;
        Area area = (Area) o;
        return getCod() == area.getCod() &&
                Objects.equals(getNome(), area.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCod(), getNome());
    }

    @Override
    public String toString() {
        return "Area{" +
                "cod=" + cod +
                ", nome='" + nome + '\'' +
                '}';
    }
}
