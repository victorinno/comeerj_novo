package br.com.ultradata.comeerj1.controllers;

import br.com.ultradata.comeerj1.entidades.TurmaEvangelizadores;
import br.com.ultradata.comeerj1.controllers.util.JsfUtil;
import br.com.ultradata.comeerj1.controllers.util.JsfUtil.PersistAction;
import br.com.ultradata.comeerj1.beans.TurmaEvangelizadoresFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("turmaEvangelizadoresController")
@SessionScoped
public class TurmaEvangelizadoresController implements Serializable {

    @EJB
    private br.com.ultradata.comeerj1.beans.TurmaEvangelizadoresFacade ejbFacade;
    private List<TurmaEvangelizadores> items = null;
    private TurmaEvangelizadores selected;

    public TurmaEvangelizadoresController() {
    }

    public TurmaEvangelizadores getSelected() {
        return selected;
    }

    public void setSelected(TurmaEvangelizadores selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TurmaEvangelizadoresFacade getFacade() {
        return ejbFacade;
    }

    public TurmaEvangelizadores prepareCreate() {
        selected = new TurmaEvangelizadores();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TurmaEvangelizadoresCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TurmaEvangelizadoresUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TurmaEvangelizadoresDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TurmaEvangelizadores> getItems() {
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

    public TurmaEvangelizadores getTurmaEvangelizadores(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<TurmaEvangelizadores> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TurmaEvangelizadores> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TurmaEvangelizadores.class)
    public static class TurmaEvangelizadoresControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TurmaEvangelizadoresController controller = (TurmaEvangelizadoresController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "turmaEvangelizadoresController");
            return controller.getTurmaEvangelizadores(getKey(value));
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
            if (object instanceof TurmaEvangelizadores) {
                TurmaEvangelizadores o = (TurmaEvangelizadores) object;
                return getStringKey(o.getIdTurmaEvangelizadores());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TurmaEvangelizadores.class.getName()});
                return null;
            }
        }

    }

}
