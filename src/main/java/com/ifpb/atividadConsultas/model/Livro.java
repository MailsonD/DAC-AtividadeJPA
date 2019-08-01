package com.ifpb.atividadConsultas.model;

import com.ifpb.atividadConsultas.conversores.ConvertLocalDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Livro implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String titulo;
    private String ISBN;
    @Convert(converter = ConvertLocalDate.class)
    private LocalDate lancamento;
    @ManyToMany(mappedBy = "livros")
    private List<Autor> autores;

    public Livro(String titulo, String ISBN, LocalDate lancamento, List<Autor> autores) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.lancamento = lancamento;
        this.autores = autores;
    }

    public Livro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro)) return false;
        Livro livro = (Livro) o;
        return getId() == livro.getId() &&
                Objects.equals(getTitulo(), livro.getTitulo()) &&
                Objects.equals(getISBN(), livro.getISBN()) &&
                Objects.equals(getLancamento(), livro.getLancamento()) &&
                Objects.equals(getAutores(), livro.getAutores());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitulo(), getISBN(), getLancamento(), getAutores());
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", lancamento=" + lancamento +
                '}';
    }
}
