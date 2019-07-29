package com.ifpb.atividadConsultas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String rua;
    private String bairro;
    private String cidade;
    private String CEP;

    public Endereco() {
    }

    public Endereco(String rua, String bairro, String cidade, String CEP) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.CEP = CEP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco)) return false;
        Endereco endereco = (Endereco) o;
        return getId() == endereco.getId() &&
                Objects.equals(getRua(), endereco.getRua()) &&
                Objects.equals(getBairro(), endereco.getBairro()) &&
                Objects.equals(getCidade(), endereco.getCidade()) &&
                Objects.equals(getCEP(), endereco.getCEP());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRua(), getBairro(), getCidade(), getCEP());
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", CEP='" + CEP + '\'' +
                '}';
    }
}
