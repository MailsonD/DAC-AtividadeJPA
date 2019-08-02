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
    }


}
