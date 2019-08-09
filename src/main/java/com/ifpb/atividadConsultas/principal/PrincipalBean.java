package com.ifpb.atividadConsultas.principal;

import com.ifpb.atividadConsultas.banco.GeradorDeDados;
import com.ifpb.atividadConsultas.model.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.Arrays;

@Singleton
@Startup
public class PrincipalBean {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private GeradorDeDados geradorDeDados;

    private CriteriaBuilder cb;

    @PostConstruct
    private void init(){
        geradorDeDados.inserirDados();
        cb = em.getCriteriaBuilder();
//        questao_A_JPQL();
        questao_A_CRITERIA();
//        questao_B_JPQL();
//        questao_B_CRITERIA();
//        questao_C_JPQL();
//        questao_C_CRITERIA();
//        questao_D_JPQL();
//        questao_D_CRITERIA();
    }


    private void questao_A_JPQL() {
        String jpql = "SELECT p FROM Pessoa p WHERE     ";
        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        query.getResultList().forEach(p -> {
            System.out.println(p[0]);
            System.out.println(p[1]);
            System.out.println(p[2]);
            System.out.println(p[3]);
        });

    }


    private void questao_A_CRITERIA() {
        CriteriaQuery<Object> query = cb.createQuery();

    }

    private void questao_B_JPQL() {
//        String jpql = "SELECT p.titulo, r.nome FROM Revisor r, IN(r.publicacoes) p, Area a " +
//                " WHERE a MEMBER OF p.areas AND a.nome LIKE :area";
        String jpql = "SELECT p.titulo, r.nome FROM Revisor r, IN(r.publicacoes) p, IN(p.areas) a " +
                " WHERE a.nome LIKE :area";
        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        query.setParameter("area","industria");
        query.getResultList().forEach(a -> {
            System.out.println("Titulo: "+a[0]+" | Revisor: "+a[1]);
        });
    }

    private void questao_B_CRITERIA() {
        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
        Root<Revisor> fromRevisor = query.from(Revisor.class);
        Join<Revisor, Publicacao> joinPub = fromRevisor.join("publicacoes");
        Join<Publicacao, Area> joinAreas = joinPub.join("areas");

        Predicate like = cb.like(joinAreas.get("nome"), "industria");

        query.multiselect(
                fromRevisor.get("nome"),joinPub.get("titulo")
        ).where(like);

        em.createQuery(query)
                .getResultList()
                .forEach(a -> {
                    System.out.println("Titulo: "+a[0]+" | Revisor: "+a[1]);
                });


    }

    private void questao_C_JPQL() {
        String jpql = "SELECT r.nome FROM Revisor r, IN(r.publicacoes) p WHERE p.titulo LIKE :expressao";
        TypedQuery<String> query = em.createQuery(jpql, String.class);
        query.setParameter("expressao","Java%");
        query.getResultList().forEach(System.out::println);
    }

    private void questao_C_CRITERIA() {
        CriteriaQuery<String> query = cb.createQuery(String.class);
        Root<Revisor> from = query.from(Revisor.class);

        Join<Object, Object> join = from.join("publicacoes");

        Predicate like = cb.like(join.get("titulo"), "Java%");

        query.select(from.get("nome")).where(like);

        em.createQuery(query)
                .getResultList()
                .forEach(System.out::println);

    }

    private void questao_D_JPQL() {
        String jpql = "SELECT e.nome, COUNT(p) FROM Escritor e, IN(e.publicacoes) p WHERE e.premios = :qtdPremios GROUP BY e.nome";
        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        query.setParameter("qtdPremios",3);
        query.getResultList().forEach(a -> {
            System.out.println("Nome: "+a[0]+" | Quantidade: "+a[1]);
        });
    }

    private void questao_D_CRITERIA() {
        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
        Root<Escritor> from = query.from(Escritor.class);

        Join<Object, Object> join = from.join("publicacoes");

        Predicate equal = cb.equal(from.get("premios"), 3);

        query.multiselect(from.get("nome"),cb.count(join))
                .where(equal)
                .groupBy(from.get("nome"));

         em.createQuery(query)
                 .getResultList()
                 .forEach(v -> {
                     System.out.println("Nome: "+v[0]+" | Quantidade: "+v[1]);
                 });
    }




}
