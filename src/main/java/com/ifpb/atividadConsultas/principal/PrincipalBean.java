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
        geradorDeDados.inserirDados(em);
        cb = em.getCriteriaBuilder();
//        questao_A_JPQL();
//        questao_A_CRITERIA();
//        questao_B_JPQL();
//        questao_B_CRITERIA();
//        questao_C_JPQL();
//        questao_C_CRITERIA();
//        questao_D_JPQL();
//        questao_D_CRITERIA();
//        questao_E_JPQL();
//        questao_E_CRITERIA();
//        questao_F_JPQL();
        questao_F_CRITERIA();
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

    private void questao_A_CRITERIA(){
        CriteriaQuery<Livro> query = cb.createQuery(Livro.class);
        Subquery<Autor> subquery = query.subquery(Autor.class);

        Root<Livro> from = subquery.from(Livro.class);
        Join<Livro, Autor> join = from.join("autores");

        Predicate notEqual = cb.notEqual(
                join.get("dataNascimento"), LocalDate.of(1982, 11, 21)
        );

        subquery.select(join).where(notEqual);

        query.select(from)
                .where(
                        cb.exists(subquery)
                );
        em.createQuery(query)
                .getResultList()
                .forEach(System.out::println);

    }

    private void questao_B_JPQL(){
        String jpql = "SELECT p FROM Professor p WHERE p.telefones IS NOT EMPTY AND p.endereco.rua = :rua";
        TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
        query.setParameter("rua","Que atividade facil");
        query.getResultList().forEach(
                System.out::println
        );
    }

    private void questao_B_CRITERIA(){
        CriteriaQuery<Professor> query = cb.createQuery(Professor.class);
        Root<Professor> from = query.from(Professor.class);
        Join<Professor, Endereco> join = from.join("endereco");

        Predicate notEmpty = cb.isNotEmpty(from.get("telefones"));

        Predicate equal = cb.equal(join.get("rua"), "Que atividade facil");

        query.select(from).where(cb.and(notEmpty,equal));

        em.createQuery(query)
                .getResultList()
                .forEach(System.out::println);

    }

    private void questao_C_JPQL(){
        String jpql = "SELECT NEW com.ifpb.atividadConsultas.model.AlunoVO(a.nome, a.cpf, a.idade) " +
                " FROM Aluno a WHERE a.turma = :turma";
        TypedQuery<AlunoVO> query = em.createQuery(jpql, AlunoVO.class);
        query.setParameter("turma","2019.1");
        query.getResultList().forEach(
                System.out::println
        );
    }

    private void questao_C_CRITERIA(){
        CriteriaQuery<AlunoVO> query = cb.createQuery(AlunoVO.class);
        Root<Aluno> from = query.from(Aluno.class);

        Predicate equal = cb.equal(from.get("turma"), "2019.1");

        query.multiselect(
                from.get("nome"),
                from.get("cpf"),
                from.get("idade")
        ).where(equal);

        em.createQuery(query)
                .getResultList()
                .forEach(System.out::println);
    }

    private void questao_D_JPQL(){
        String jpql = "SELECT DISTINCT p FROM Professor p, IN(p.telefones) t WHERE t.numero LIKE :telefone";
        TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
        query.setParameter("telefone","%8");
        query.getResultList().forEach(
                System.out::println
        );
    }

    private void questao_D_CRITERIA(){
        CriteriaQuery<Professor> query = cb.createQuery(Professor.class);
        Root<Professor> from = query.from(Professor.class);

        Join<Professor, Telefone> join = from.join("telefones");

        Predicate like = cb.like(join.get("numero"), "%8");

        query.select(from).where(like).distinct(true);

        em.createQuery(query)
                .getResultList()
                .forEach(System.out::println);


    }

    private void questao_E_JPQL(){
        String jpql = "SELECT DISTINCT l FROM Livro l, IN(l.autores) a WHERE a.endereco.cidade LIKE :cidade AND (l.lancamento BETWEEN :inicio AND :fim)";
        TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
        query.setParameter("cidade","cajazeiras");
        query.setParameter("inicio",LocalDate.of(2019,1,1));
        query.setParameter("fim",LocalDate.of(2019,12,12));
        query.getResultList().forEach(
                System.out::println
        );
    }

    private void questao_E_CRITERIA(){
        CriteriaQuery<Livro> query = cb.createQuery(Livro.class);
        Root<Livro> from = query.from(Livro.class);
        Join<Livro, Autor> join = from.join("autores");
        Join<Autor, Endereco> join1 = join.join("endereco");

        Predicate like = cb.like(join1.get("cidade"), "cajazeiras");

        Predicate between = cb.between(from.get("lancamento"),
                LocalDate.of(2019, 1, 1),
                LocalDate.of(2019, 12, 12)
        );

        query.select(from).where(
                cb.and(like,between)
        );

        em.createQuery(query)
                .getResultList()
                .forEach(System.out::println);
    }

    private void questao_F_JPQL(){
        String jpql = "SELECT DISTINCT l FROM Livro l, IN(l.autores) a WHERE a.nome LIKE :expressao";
        TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
        query.setParameter("expressao", "J%");
        query.getResultList().forEach(
                System.out::println
        );
    }

    private void questao_F_CRITERIA(){
        CriteriaQuery<Livro> query = cb.createQuery(Livro.class);
        Root<Livro> from = query.from(Livro.class);

        Join<Livro, Autor> join = from.join("autores");

        Predicate like = cb.like(join.get("nome"), "J%");

        query.select(from).where(like);

        em.createQuery(query)
                .getResultList()
                .forEach(System.out::println);
    }

}
