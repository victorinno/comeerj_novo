package br.com.ultradata.comeerj1.controllers;

import br.com.ultradata.comeerj1.beans.AlojamentoFacade;
import br.com.ultradata.comeerj1.beans.RelacaoAlojamentoFacade;
import br.com.ultradata.comeerj1.beans.RelacaoFacade;
import br.com.ultradata.comeerj1.controllers.util.JsfUtil;
import br.com.ultradata.comeerj1.controllers.util.JsfUtil.PersistAction;
import br.com.ultradata.comeerj1.entidades.Alojamento;
import br.com.ultradata.comeerj1.entidades.Relacao;
import br.com.ultradata.comeerj1.entidades.RelacaoAlojamento;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

@Named("relacaoAlojamentoController")
@SessionScoped
public class RelacaoAlojamentoController
        implements Serializable {

    @EJB
    private br.com.ultradata.comeerj1.beans.RelacaoAlojamentoFacade ejbFacade;

    @EJB
    private AlojamentoFacade alojamentoFacade;

    @EJB
    private RelacaoFacade relacaoFacade;

    private List<RelacaoAlojamento> items = null;

    private RelacaoAlojamento selected;

    private Alojamento alojamentoSelected;

    private DualListModel<Relacao> dualList;

    private List<RelacaoAlojamento> todosAljRel;

    private List<Alojamento> todasRelacoesAlojamentos;

    public RelacaoAlojamentoController() {
    }

    @PostConstruct
    public void init() {
        List<Relacao> todos = relacaoFacade.findAll();
        todos = todos.stream().sorted((Relacao r1, Relacao r2) -> {
            return r1.getDscNome().compareToIgnoreCase(r2.getDscNome());
        }).collect(Collectors.toList());
        todasRelacoesAlojamentos = alojamentoFacade.findAll()
                .stream()
                .sorted((Alojamento r1, Alojamento r2)
                        -> r1.getNomeAlojamento().compareToIgnoreCase(r2.getNomeAlojamento()))
                .collect(Collectors.toList());

        alojamentoSelected = alojamentoSelected == null ? todasRelacoesAlojamentos.get(0) : alojamentoSelected;
        List<Relacao> pessoasNoAlojamento = alojamentoSelected.getRelacaoAlojamentoList().stream().map(al -> al.getIdRelacao()).collect(Collectors.toList());

        todos.removeAll(pessoasNoAlojamento);

        dualList = new DualListModel<>(todos, pessoasNoAlojamento);
    }

    public RelacaoAlojamento getSelected() {
        return selected;
    }

    public void setSelected(RelacaoAlojamento selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private RelacaoAlojamentoFacade getFacade() {
        return ejbFacade;
    }

    public RelacaoAlojamento prepareCreate() {
        selected = new RelacaoAlojamento();
        initializeEmbeddableKey();
        return selected;
    }

    public void onTransfer(final TransferEvent event) {
        todosAljRel = ejbFacade.findAll();
        if (event.isAdd()) {
            final Collection<Relacao> relcoes = (Collection<Relacao>) event.getItems();
            final List<RelacaoAlojamento> collect = relcoes.stream()
                    .map(rel -> {
                        RelacaoAlojamento ra = new RelacaoAlojamento();
                        ra.setIdAlojamento(alojamentoSelected);
                        ra.setIdRelacao(rel);
                        ra.setIndice(1);
                        return ra;
                    }).collect(Collectors.toList());
            alojamentoSelected.getRelacaoAlojamentoList().addAll(collect);
        } else {
            List<Relacao> relacoes = (List<Relacao>) event.getItems();
            alojamentoSelected.getRelacaoAlojamentoList().removeAll(relacoes);
            relacoes.stream().forEach((relacoe) -> {
                final List<RelacaoAlojamento> collect = alojamentoSelected.getRelacaoAlojamentoList()
                        .stream().filter(ra -> ra.getIdRelacao().equals(relacoe)).collect(Collectors.toList());
                collect.stream().forEach(col -> ejbFacade.remove(col));
                alojamentoSelected.getRelacaoAlojamentoList().removeAll(collect);
            });
        }
        alojamentoSelected = alojamentoFacade.edit(alojamentoSelected);
        items = getFacade().findAll();
    }

    public void create() {

        JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("RelacaoAlojamentoCreated"));
        items = null;
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RelacaoAlojamentoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RelacaoAlojamentoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<RelacaoAlojamento> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public RelacaoAlojamento getRelacaoAlojamento(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<RelacaoAlojamento> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<RelacaoAlojamento> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public RelacaoAlojamentoFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(RelacaoAlojamentoFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public AlojamentoFacade getAlojamentoFacade() {
        return alojamentoFacade;
    }

    public void setAlojamentoFacade(AlojamentoFacade alojamentoFacade) {
        this.alojamentoFacade = alojamentoFacade;
    }

    public RelacaoFacade getRelacaoFacade() {
        return relacaoFacade;
    }

    public void setRelacaoFacade(RelacaoFacade relacaoFacade) {
        this.relacaoFacade = relacaoFacade;
    }

    public Alojamento getAlojamentoSelected() {
        return alojamentoSelected;
    }

    public void setAlojamentoSelected(Alojamento alojamentoSelected) {
        this.alojamentoSelected = alojamentoSelected;
    }

    public DualListModel<Relacao> getDualList() {
        return dualList;
    }

    public void setDualList(DualListModel<Relacao> dualList) {
        this.dualList = dualList;
    }

    public List<Alojamento> getTodasRelacoesAlojamentos() {
        return todasRelacoesAlojamentos;
    }

    public void setTodasRelacoesAlojamentos(List<Alojamento> todasRelacoesAlojamentos) {
        this.todasRelacoesAlojamentos = todasRelacoesAlojamentos;
    }

    public List<RelacaoAlojamento> getTodosAljRel() {
        return todosAljRel;
    }

    public void setTodosAljRel(List<RelacaoAlojamento> todosAljRel) {
        this.todosAljRel = todosAljRel;
    }

}
