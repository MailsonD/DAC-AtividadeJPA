package com.ifpb.atividadConsultas.principal;

import com.ifpb.atividadConsultas.banco.GeradorDeDados;
import com.ifpb.atividadConsultas.model.AlunoVO;
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
        geradorDeDados.inserirDados(em);

//        questao_A_JPQL();
//        questao_B_JPQL();
//        questao_C_JPQL();
//        questao_D_JPQL();
//        questao_E_JPQL();
        questao_F_JPQL();
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
        String jpql = "SELECT NEW com.ifpb.atividadConsultas.model.AlunoVO(a.nome, a.cpf, a.idade) " +
                " FROM Aluno a WHERE a.turma = :turma";
        TypedQuery<AlunoVO> query = em.createQuery(jpql, AlunoVO.class);
        query.setParameter("turma","2019.1");
        query.getResultList().forEach(
                System.out::println
        );
    }

    private void questao_D_JPQL(){
        String jpql = "SELECT p FROM Professor p WHERE EXISTS (SELECT t FROM p.telefones t WHERE t.numero LIKE :telefone)";
        TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
        query.setParameter("telefone","%8");
        query.getResultList().forEach(
                System.out::println
        );
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

    private void questao_F_JPQL(){
        String jpql = "SELECT DISTINCT l FROM Livro l, IN(l.autores) a WHERE a.nome LIKE :expressao";
        TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
        query.setParameter("expressao", "J%");
        query.getResultList().forEach(
                System.out::println
        );
    }

}
