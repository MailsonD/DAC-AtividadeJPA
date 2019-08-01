package com.ifpb.atividadConsultas.model;

import com.ifpb.atividadConsultas.conversores.ConvertLocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class Aluno extends Pessoa {

    private String matricula;
    @Convert(converter = ConvertLocalDate.class)
    private LocalDate dataIngresso;
    private String turma;

    public Aluno() {
    }

    public Aluno(String nome, String cpf, int idade, LocalDate dataNascimento, Endereco endereco, String matricula, LocalDate dataIngresso, String turma) {
        super(nome, cpf, idade, dataNascimento, endereco);
        this.matricula = matricula;
        this.dataIngresso = dataIngresso;
        this.turma = turma;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;
        if (!super.equals(o)) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(getMatricula(), aluno.getMatricula()) &&
                Objects.equals(getDataIngresso(), aluno.getDataIngresso()) &&
                Objects.equals(getTurma(), aluno.getTurma());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMatricula(), getDataIngresso(), getTurma());
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula='" + matricula + '\'' +
                ", dataIngresso=" + dataIngresso +
                ", turma='" + turma + '\'' +
                "} " + super.toString();
    }
}
