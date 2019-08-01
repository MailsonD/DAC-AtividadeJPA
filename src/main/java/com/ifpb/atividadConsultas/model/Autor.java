package com.ifpb.atividadConsultas.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Autor extends Pessoa implements Serializable {

    private String instituicaoVinculada;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Livro> livros;

    public Autor() {
    }

    public Autor(String nome, String cpf, int idade, LocalDate dataNascimento, Endereco endereco, String instituicaoVinculada, List<Livro> livros) {
        super(nome, cpf, idade, dataNascimento, endereco);
        this.instituicaoVinculada = instituicaoVinculada;
        this.livros = livros;
    }

    public String getInstituicaoVinculada() {
        return instituicaoVinculada;
    }

    public void setInstituicaoVinculada(String instituicaoVinculada) {
        this.instituicaoVinculada = instituicaoVinculada;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor)) return false;
        if (!super.equals(o)) return false;
        Autor autor = (Autor) o;
        return Objects.equals(getInstituicaoVinculada(), autor.getInstituicaoVinculada()) &&
                Objects.equals(getLivros(), autor.getLivros());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getInstituicaoVinculada(), getLivros());
    }

    @Override
    public String toString() {
        return "Autor{" +
                "instituicaoVinculada='" + instituicaoVinculada + '\'' +
                ", livros=" + livros +
                "} " + super.toString();
    }
}
