package com.ifpb.atividadConsultas.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Autor extends Pessoa implements Serializable {

    private String instituicaoVinculada;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Livro> livros;
}
