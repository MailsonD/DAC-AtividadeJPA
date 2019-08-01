package com.ifpb.atividadConsultas.principal;

import com.ifpb.atividadConsultas.banco.GeradorDeDados;
import com.ifpb.atividadConsultas.model.Livro;
import com.ifpb.atividadConsultas.model.Professor;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDate;

@Singleton
@Startup
public class PrincipalBean {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private GeradorDeDados geradorDeDados;

    @PostConstruct
    private void init(){
//        geradorDeDados.inserirDados(em);

//        questao_A_JPQL();
        questao_B_JPQL();
    }

    private void questao_A_JPQL(){
        String jpql = "SELECT l FROM Livro l WHERE NOT EXISTS " +
                "(SELECT a FROM l.autores a WHERE a.dataNascimento = :idade) ";
        TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
        query.setParameter("idade", LocalDate.of(1982, 11, 21));
        query.getResultList().forEach(
                System.out::println
        );
    }

    private void questao_B_JPQL(){
        String jpql = "SELECT p FROM Professor p WHERE p.telefones IS NOT EMPTY AND p.endereco.rua = :rua";
        TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
        query.setParameter("rua","Que atividade facil");
        query.getResultList().forEach(
                System.out::println
        );
    }

    private void questao_C_JPQL(){
        String jpql = "SELECT p FROM Professor p WHERE p.telefones IS NOT EMPTY AND p.endereco.rua = :rua";
        TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
        query.setParameter("rua","Que atividade facil");
        query.getResultList().forEach(
                System.out::println
        );
    }

    private void questao_D_JPQL(){

    }

    private void questao_E_JPQL(){

    }

    private void questao_F_JPQL(){
    }

}
