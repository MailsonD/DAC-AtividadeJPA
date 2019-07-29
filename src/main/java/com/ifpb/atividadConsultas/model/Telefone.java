package com.ifpb.atividadConsultas.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Telefone implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String numero;
    @Enumerated(EnumType.STRING)
    private TelefoneType tipo;

    public Telefone() {
    }

    public Telefone(String numero, TelefoneType tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TelefoneType getTipo() {
        return tipo;
    }

    public void setTipo(TelefoneType tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telefone)) return false;
        Telefone telefone = (Telefone) o;
        return getId() == telefone.getId() &&
                Objects.equals(getNumero(), telefone.getNumero()) &&
                getTipo() == telefone.getTipo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumero(), getTipo());
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
