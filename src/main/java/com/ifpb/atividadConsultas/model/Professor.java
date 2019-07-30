package com.ifpb.atividadConsultas.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Professor extends Pessoa {

    private Double salario;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Telefone> telefones;

    public Professor() {
    }

    public Professor(String nome, String cpf, int idade, Date dataNascimento, Endereco endereco, Double salario, List<Telefone> telefones) {
        super(nome, cpf, idade, dataNascimento, endereco);
        this.salario = salario;
        this.telefones = telefones;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor)) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return Objects.equals(getSalario(), professor.getSalario()) &&
                Objects.equals(getTelefones(), professor.getTelefones());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSalario(), getTelefones());
    }

    @Override
    public String toString() {
        return "Professor{" +
                "salario=" + salario +
                ", telefones=" + telefones +
                '}';
    }
}
