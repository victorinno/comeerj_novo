/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultradata.comeerj1.controllers;

import br.com.ultradata.comeerj1.beans.RelacaoFacade;
import br.com.ultradata.comeerj1.beans.TurmaEvangelizandosFacade;
import br.com.ultradata.comeerj1.entidades.Relacao;
import br.com.ultradata.comeerj1.entidades.TurmaEvangelizandos;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Victor
 */
@Named(value = "presencaController")
@ViewScoped
public class PresencaConfraternistaController
        implements Serializable {

    @EJB
    private RelacaoFacade rf;

    @EJB
    private TurmaEvangelizandosFacade tef;

    private List<TurmaEvangelizandos> listagem;

    /**
     * Creates a new instance of PresencaController
     */
    public PresencaConfraternistaController() {
    }

    public void marcadorPresenca(Relacao relacao) {
        System.out.println(relacao.getDscNome() + " - " + relacao.getIndCompareceu());
        rf.edit(relacao);
    }

    @PostConstruct
    public void init() {
        listagem = tef.findAll().stream()
                .sorted((TurmaEvangelizandos t1, TurmaEvangelizandos t2) -> 
                        t1.getIdRelacao().getDscNome().compareToIgnoreCase(
                                t2.getIdRelacao().getDscNome())).collect(Collectors.toList());
    }

    public List<TurmaEvangelizandos> getListagem() {
        return listagem;
    }

    public void setListagem(List<TurmaEvangelizandos> listagem) {
        this.listagem = listagem;
    }

}
