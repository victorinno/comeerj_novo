package ultradata.com.comeerj.managers.util;

import ultradata.com.comeerj.modelo.Alojamento;
import ultradata.com.comeerj.managers.util.util.JsfUtil;
import ultradata.com.comeerj.managers.util.util.JsfUtil.PersistAction;
import ultradata.com.comeerj.beans.util.AlojamentoFacade;

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

@Named("alojamentoController")
@SessionScoped
public class AlojamentoController implements Serializable {

    @EJB
    private ultradata.com.comeerj.beans.util.AlojamentoFacade ejbFacade;
    private List<Alojamento> items = null;
    private Alojamento selected;

    public AlojamentoController() {
    }

    public Alojamento getSelected() {
        return selected;
    }

    public void setSelected(Alojamento selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private AlojamentoFacade getFacade() {
        return ejbFacade;
    }

    public Alojamento prepareCreate() {
        selected = new Alojamento();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/app").getString("AlojamentoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/app").getString("AlojamentoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/app").getString("AlojamentoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Alojamento> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/app").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/app").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Alojamento getAlojamento(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Alojamento> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Alojamento> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Alojamento.class)
    public static class AlojamentoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AlojamentoController controller = (AlojamentoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "alojamentoController");
            return controller.getAlojamento(getKey(value));
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
            if (object instanceof Alojamento) {
                Alojamento o = (Alojamento) object;
                return getStringKey(o.getIdalojamento());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Alojamento.class.getName()});
                return null;
            }
        }

    }

}
