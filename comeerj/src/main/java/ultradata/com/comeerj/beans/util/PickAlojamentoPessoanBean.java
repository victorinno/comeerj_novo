/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultradata.com.comeerj.beans.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;
import ultradata.com.comeerj.modelo.Alojamento;
import ultradata.com.comeerj.modelo.AlojamentoMembros;
import ultradata.com.comeerj.modelo.Comeerj;

/**
 *
 * @author Victor
 */
@ManagedBean
@ViewScoped
public class PickAlojamentoPessoanBean implements Serializable{
    
    @EJB
    AlojamentoFacade af;
    @EJB
    ComeerjFacade cf;
    
    Alojamento alojamentoSelecionado;
    List<Alojamento> alojamentos;
    DualListModel<Comeerj> comeerjDualList;
    
    int indexSelecionado;
    
    @PostConstruct
    public void init(){
        
        alojamentos = af.findAll();
        
        List<Comeerj> geral = cf.findAll();
        List<Comeerj> vazia = new ArrayList<>();
        
        for (AlojamentoMembros pessoas : alojamentos.get(0).getAlojamentoMembrosList()) {
            vazia.add(pessoas.getMembro());
        }
        
        comeerjDualList = new DualListModel<>(geral, vazia);
        
        
    }
    
    /**
     * Creates a new instance of PickAlojamentoPessoanBean
     */
    public PickAlojamentoPessoanBean() {
    }
    
    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for(Object item : event.getItems()) {
            builder.append(((Comeerj) item).getNomCompleto()).append("<br />");
        }
         
        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Items Transferred");
        msg.setDetail(builder.toString());
         
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } 
    
    public void onChange(){
        System.out.println(alojamentoSelecionado.toString());
    }
 
    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }
     
    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }
     
    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    } 

    public DualListModel<Comeerj> getComeerjDualList() {
        return comeerjDualList;
    }

    public void setComeerjDualList(DualListModel<Comeerj> comeerjDualList) {
        this.comeerjDualList = comeerjDualList;
    }

    public Alojamento getAlojamentoSelecionado() {
        return alojamentoSelecionado;
    }

    public void setAlojamentoSelecionado(Alojamento alojamentoSelecionado) {
        this.alojamentoSelecionado = alojamentoSelecionado;
    }

    public List<Alojamento> getAlojamentos() {
        return alojamentos;
    }

    public void setAlojamentos(List<Alojamento> alojamentos) {
        this.alojamentos = alojamentos;
    }
    
    
}
