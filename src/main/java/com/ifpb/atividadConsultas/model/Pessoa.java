package com.ifpb.atividadConsultas.model;

import com.ifpb.atividadConsultas.conversores.ConvertLocalDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    @Column(unique = true)
    private String cpf;
    private int idade;
    @Convert(converter = ConvertLocalDate.class)
    private LocalDate dataNascimento;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, int idade, LocalDate dataNascimento, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return getId() == pessoa.getId() &&
                getIdade() == pessoa.getIdade() &&
                Objects.equals(getNome(), pessoa.getNome()) &&
                Objects.equals(getCpf(), pessoa.getCpf()) &&
                Objects.equals(getDataNascimento(), pessoa.getDataNascimento()) &&
                Objects.equals(getEndereco(), pessoa.getEndereco());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCpf(), getIdade(), getDataNascimento(), getEndereco());
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", dataNascimento=" + dataNascimento +
                ", endereco=" + endereco +
                '}';
    }
}
