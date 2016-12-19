package br.com.ultradata.comeerj1.controllers;

import br.com.ultradata.comeerj1.beans.RelacaoFacade;
import br.com.ultradata.comeerj1.beans.TurmaEvangelizandosFacade;
import br.com.ultradata.comeerj1.beans.TurmaFacade;
import br.com.ultradata.comeerj1.controllers.util.JsfUtil;
import br.com.ultradata.comeerj1.controllers.util.JsfUtil.PersistAction;
import br.com.ultradata.comeerj1.entidades.Relacao;
import br.com.ultradata.comeerj1.entidades.Turma;
import br.com.ultradata.comeerj1.entidades.TurmaEvangelizandos;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

@Named("turmaEvangelizandosController")
@SessionScoped
public class TurmaEvangelizandosController
        implements Serializable {

    @EJB
    private br.com.ultradata.comeerj1.beans.TurmaEvangelizandosFacade ejbFacade;

    @EJB
    private RelacaoFacade relacaoFacade;

    @EJB
    private TurmaFacade turmaFacade;

    private List<TurmaEvangelizandos> items = null;

    private TurmaEvangelizandos selected;

    private List<String> faixas;

    private String faixaSelecionada;

    private List<Turma> turmas;

    private Turma turmaSelected;

    private DualListModel<Relacao> dualList;

    public TurmaEvangelizandosController() {
    }

    @PostConstruct
    public void init() {
        turmaSelected = turmaSelected == null ? getTurmas().get(0) : turmaSelected;
        faixaSelecionada = faixaSelecionada == null ? getFaixas().get(1) : faixaSelecionada;
        compararRelacao = (Relacao r1, Relacao r2) -> r1.getDscNome().compareToIgnoreCase(r2.getDscNome());
        final Stream<Relacao> pessoasStream = relacaoFacade.findAll()
                .stream()
                .sorted(compararRelacao);

        final List<Relacao> pessoasNaTurma = turmaSelected.getTurmaEvangelizandosList()
                .stream()
                .map(te -> te.getIdRelacao())
                .sorted(compararRelacao)
                .collect(Collectors.toList());

        final List<Relacao> pessoas = pessoasStream
                .filter(rel -> !pessoasNaTurma.contains(rel))
                .filter(re -> re.getFaixa().equalsIgnoreCase(faixaSelecionada))
                .collect(Collectors.toList());

        dualList = new DualListModel<>(pessoas, pessoasNaTurma);
    }

    public void onTransfer(final TransferEvent event) {
        if (event.isAdd()) {
            List<Relacao> pessoas = (List<Relacao>) event.getItems();
            turmaSelected.getTurmaEvangelizandosList().addAll(coletarRelacao(pessoas));
        } else {
            List<Relacao> pessoas = (List<Relacao>) event.getItems();
            final List<TurmaEvangelizandos> coletarRelacao = coletarRelacao(pessoas);
            turmaSelected.getTurmaEvangelizandosList().removeAll(coletarRelacao);
            coletarRelacao.stream().forEach((te) -> {
                ejbFacade.remove(te);
            });
        }
        turmaSelected = turmaFacade.edit(turmaSelected);
        
        items = getFacade().findAll();
        RequestContext.getCurrentInstance().update("datalist");
    }

    private List<TurmaEvangelizandos> coletarRelacao(List<Relacao> pessoas) {
        return pessoas.stream().map(rel -> {
            final TurmaEvangelizandos te = new TurmaEvangelizandos();
            te.setIdRelacao(rel);
            te.setIdTurma(turmaSelected);
            te.setIdTurmaEvangelizandos(turmaSelected.getTurmaEvangelizandosList()
                    .stream()
                    .filter(tee -> {
                        return tee.getIdRelacao().equals(te.getIdRelacao()); 
                    })
                    .findFirst()
                    .orElse(new TurmaEvangelizandos())
                    .getIdTurmaEvangelizandos());
            return te;
        }).collect(Collectors.toList());
    }

    private Comparator<Relacao> compararRelacao;

    public TurmaEvangelizandos getSelected() {
        return selected;
    }

    public void setSelected(TurmaEvangelizandos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TurmaEvangelizandosFacade getFacade() {
        return ejbFacade;
    }

    public TurmaEvangelizandos prepareCreate() {
        selected = new TurmaEvangelizandos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TurmaEvangelizandosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TurmaEvangelizandosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TurmaEvangelizandosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TurmaEvangelizandos> getItems() {
        return getFacade().findAll();
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

    public TurmaEvangelizandos getTurmaEvangelizandos(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TurmaEvangelizandos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TurmaEvangelizandos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TurmaEvangelizandos.class)
    public static class TurmaEvangelizandosControllerConverter
            implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TurmaEvangelizandosController controller = (TurmaEvangelizandosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "turmaEvangelizandosController");
            return controller.getTurmaEvangelizandos(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TurmaEvangelizandos) {
                TurmaEvangelizandos o = (TurmaEvangelizandos) object;
                return getStringKey(o.getIdTurmaEvangelizandos());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TurmaEvangelizandos.class.getName()});
                return null;
            }
        }

    }

    public List<String> getFaixas() {
        if (faixas == null) {
            faixas = relacaoFacade.resgatarFaixas();
        }
        return faixas;
    }

    public void setFaixas(List<String> faixas) {
        this.faixas = faixas;
    }

    public List<Turma> getTurmas() {
        return turmaFacade.findAll()
                .stream()
                .sorted((Turma t1, Turma t2) -> t1.getNome().compareToIgnoreCase(t2.getNome()))
                .collect(Collectors.toList());
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public String getFaixaSelecionada() {
        return faixaSelecionada;
    }

    public void setFaixaSelecionada(String faixaSelecionada) {
        this.faixaSelecionada = faixaSelecionada;
    }

    public Turma getTurmaSelected() {
        return turmaSelected;
    }

    public void setTurmaSelected(Turma turmaSelected) {
        this.turmaSelected = turmaSelected;
    }

    public DualListModel<Relacao> getDualList() {
        return dualList;
    }

    public void setDualList(DualListModel<Relacao> dualList) {
        this.dualList = dualList;
    }

}
