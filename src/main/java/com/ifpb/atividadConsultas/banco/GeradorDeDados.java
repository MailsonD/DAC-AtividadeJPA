package com.ifpb.atividadConsultas.banco;

import com.ifpb.atividadConsultas.model.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
public class GeradorDeDados {

    private final String turma1 = "2019.1";
    private final String turma2 = "2019.2";
    private final Endereco endereco1 =
            new Endereco(
            "Rua minha rua",
            "Bairro do bagui",
            "testerCity",
            "50000");
    private final Endereco endereco2 =
            new Endereco(
                    "Que atividade facil",
                    "Bairro de dac",
                    "cajazeiras",
                    "50000");

    public void inserirDados(EntityManager em){
        for (Aluno aluno: gerarAlunos()){
            em.persist(aluno);
        }
        for (Autor autor: gerarAutoresLivros()){
            em.persist(autor);
        }
        for (Professor professor: gerarProfessores()){
            em.persist(professor);
        }

    }


    private List<Aluno> gerarAlunos(){
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(
                new Aluno(
                        "Lucas","1233211565",19,
                        new Date(2000,03,11),
                        endereco1,
                        "282828282",
                        new Date(2018,05,16),
                        turma1
                        )
        );
        alunos.add(
                new Aluno(
                        "Jonas","1457311565",21,
                        new Date(1998,05,18),
                        endereco1,
                        "272178282",
                        new Date(2016,04,20),
                        turma1
                )
        );
        alunos.add(
                new Aluno(
                        "Marcos","7853211565",16,
                        new Date(2003,07,05),
                        endereco1,
                        "282828282",
                        new Date(2018,05,16),
                        turma2
                )
        );
        return alunos;
    }

    private List<Autor> gerarAutoresLivros(){
        List<Autor> autores = new ArrayList<>();
        Autor diego = new Autor(
                "Diego",
                "521264511",
                37,
                new Date(1984,07,26),
                endereco2,
                "IFPB",
                null
        );
        Autor paulo = new Autor(
                "Paulo",
                "61458021",
                37,
                new Date(1982,11,21)
                ,
                endereco1,
                "IFPB",
                null
        );


        Livro meu_banco_e_o_melhor = new Livro(
                "Meu banco é o melhor",
                "111111",
                new Date(2019,03,25),
                Collections.singletonList(diego)
        );

        Livro meu_ejb_e_o_melhor = new Livro(
                "Meu EJB é o melhor",
                "222222",
                new Date(),
                Collections.singletonList(diego)
        );

        Livro meu_poo_e_o_melhor = new Livro(
                "Meu POO é o melhor",
                "444444",
                new Date(),
                Collections.singletonList(paulo)
        );

        List<Livro> livros_de_paulo = new ArrayList<>();
        List<Livro> livros_de_diego = new ArrayList<>();

        livros_de_diego.add(meu_banco_e_o_melhor);
        livros_de_diego.add(meu_ejb_e_o_melhor);
        livros_de_paulo.add(meu_poo_e_o_melhor);

        diego.setLivros(livros_de_diego);
        paulo.setLivros(livros_de_paulo);

        autores.add(diego);
        autores.add(paulo);

        return autores;
    }

    private List<Professor> gerarProfessores(){
        List<Professor> professores = new ArrayList<>();

        Telefone telefone1 = new Telefone("8980678",TelefoneType.COMERICAL);
        Telefone telefone2 = new Telefone("9768589",TelefoneType.RESIDENCIAL);
        Telefone telefone3 = new Telefone("5634134",TelefoneType.COMERICAL);

        List<Telefone> telefonesDeJob = new ArrayList<>();
        telefonesDeJob.add(telefone1);
        telefonesDeJob.add(telefone2);

        List<Telefone> telefonesDeAri = new ArrayList<>();
        telefonesDeAri.add(telefone3);

        Professor job = new Professor(
                "Ricardo Job",
                "68423143",
                45,
                new Date(),
                endereco1,
                9000.0,
                telefonesDeJob
        );
        Professor ari = new Professor(
                "Aristofanio",
                "656824114",
                48,
                new Date(),
                endereco1,
                8000.0,
                telefonesDeAri
        );

        professores.add(job);
        professores.add(ari);

        return professores;
    }

}
