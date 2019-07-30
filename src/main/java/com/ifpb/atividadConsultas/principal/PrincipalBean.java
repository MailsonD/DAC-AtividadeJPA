package com.ifpb.atividadConsultas.principal;

import com.ifpb.atividadConsultas.banco.GeradorDeDados;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    }

    private void questao_A(){

    }
    private void questao_B(){

    }
    private void questao_C(){

    }
    private void questao_D(){

    }
    private void questao_E(){

    }
    private void questao_F(){
    }

}
