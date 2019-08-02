package com.ifpb.atividadConsultas.banco;

import com.ifpb.atividadConsultas.model.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
public class GeradorDeDados {


    public void inserirDados(EntityManager em) {

        Area industria = new Area(233,"industria");
        Area tecnologia = new Area(246,"Tecnologia");
        Area medicina = new Area(246,"Medicina");

        List<Area> areas = new ArrayList<>();
        areas.add(industria);
        areas.add(tecnologia);
        areas.add(medicina);

        //===================================================

        Escritor Matheus = new Escritor(
                "Matheus",
                LocalDate.of(1989,6,3),
                3,
                null
        );

        Escritor Ednaldo = new Escritor(
                "Ednaldo",
                LocalDate.of(1970,2,11),
                1,
                null
        );


        Revisor Andre = new Revisor(
                "André",
                LocalDate.of(1950,8,25),
                "Eu sou um revisor criterioso",
                null
        );

        Revisor Lucas = new Revisor(
                "Lucas",
                LocalDate.of(1970,4,20),
                "Eu sou um ótimo revisor",
                null
        );


        //===================================================

        Publicacao maquinario = new Publicacao(
                11,
                "Máquinas pesadas",
                Collections.singletonList(industria)
        );

        Publicacao novaTecnologia = new Publicacao(
                22,
                "Uma nova tecnologia",
                Collections.singletonList(tecnologia)
        );

        Publicacao curaFebre = new Publicacao(
                11,
                "Nova cura para a febre",
                Collections.singletonList(medicina)
        );

        Publicacao meuHelloWorld = new Publicacao(
                11,
                "Hello world em tudo quanto é linguagem",
                Collections.singletonList(tecnologia)
        );

        List<Publicacao> de_Matheus_revisado_Andre = new ArrayList<>();
        List<Publicacao> de_Ednaldo_revisado_Lucas = new ArrayList<>();

        de_Matheus_revisado_Andre.add(novaTecnologia);
        de_Matheus_revisado_Andre.add(meuHelloWorld);
        de_Ednaldo_revisado_Lucas.add(curaFebre);
        de_Ednaldo_revisado_Lucas.add(maquinario);

        Matheus.setPublicacoes(de_Matheus_revisado_Andre);
        Andre.setPublicacoes(de_Matheus_revisado_Andre);
        Ednaldo.setPublicacoes(de_Ednaldo_revisado_Lucas);
        Lucas.setPublicacoes(de_Ednaldo_revisado_Lucas);

        //===================================================

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(Matheus);
        pessoas.add(Andre);
        pessoas.add(Ednaldo);
        pessoas.add(Lucas);

        //===================================================

        for (Area a: areas) {
            em.persist(a);
        }

        for (Pessoa p: pessoas) {
            em.persist(p);
        }


    }
}
