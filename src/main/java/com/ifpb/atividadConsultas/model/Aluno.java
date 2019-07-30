package com.ifpb.atividadConsultas.model;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;

@Entity
public class Aluno extends Pessoa {

    private String matricula;
    @Temporal(TemporalType.DATE)
    private Date dataIngresso;
    private String turma;

    public Aluno() {
    }

    public Aluno(String nome, String cpf, int idade, Date dataNascimento, Endereco endereco, String matricula, Date dataIngresso, String turma) {
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

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
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
                '}';
    }
}
