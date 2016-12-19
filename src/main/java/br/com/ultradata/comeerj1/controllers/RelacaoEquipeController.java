package br.com.ultradata.comeerj1.controllers;

import br.com.ultradata.comeerj1.entidades.RelacaoEquipe;
import br.com.ultradata.comeerj1.controllers.util.JsfUtil;
import br.com.ultradata.comeerj1.controllers.util.JsfUtil.PersistAction;
import br.com.ultradata.comeerj1.beans.RelacaoEquipeFacade;

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

@Named("relacaoEquipeController")
@SessionScoped
public class RelacaoEquipeController implements Serializable {

    @EJB
    private br.com.ultradata.comeerj1.beans.RelacaoEquipeFacade ejbFacade;
    private List<RelacaoEquipe> items = null;
    private RelacaoEquipe selected;

    public RelacaoEquipeController() {
    }

    public RelacaoEquipe getSelected() {
        return selected;
    }

    public void setSelected(RelacaoEquipe selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private RelacaoEquipeFacade getFacade() {
        return ejbFacade;
    }

    public RelacaoEquipe prepareCreate() {
        selected = new RelacaoEquipe();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RelacaoEquipeCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RelacaoEquipeUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RelacaoEquipeDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<RelacaoEquipe> getItems() {
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

    public RelacaoEquipe getRelacaoEquipe(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<RelacaoEquipe> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<RelacaoEquipe> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = RelacaoEquipe.class)
    public static class RelacaoEquipeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RelacaoEquipeController controller = (RelacaoEquipeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "relacaoEquipeController");
            return controller.getRelacaoEquipe(getKey(value));
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
            if (object instanceof RelacaoEquipe) {
                RelacaoEquipe o = (RelacaoEquipe) object;
                return getStringKey(o.getIdRelacaoEquipe());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), RelacaoEquipe.class.getName()});
                return null;
            }
        }

    }

}
