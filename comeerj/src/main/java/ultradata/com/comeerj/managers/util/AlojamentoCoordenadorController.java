package ultradata.com.comeerj.managers.util;

import ultradata.com.comeerj.modelo.AlojamentoCoordenador;
import ultradata.com.comeerj.managers.util.util.JsfUtil;
import ultradata.com.comeerj.managers.util.util.JsfUtil.PersistAction;
import ultradata.com.comeerj.beans.util.AlojamentoCoordenadorFacade;

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

@Named("alojamentoCoordenadorController")
@SessionScoped
public class AlojamentoCoordenadorController implements Serializable {

    @EJB
    private ultradata.com.comeerj.beans.util.AlojamentoCoordenadorFacade ejbFacade;
    private List<AlojamentoCoordenador> items = null;
    private AlojamentoCoordenador selected;

    public AlojamentoCoordenadorController() {
    }

    public AlojamentoCoordenador getSelected() {
        return selected;
    }

    public void setSelected(AlojamentoCoordenador selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private AlojamentoCoordenadorFacade getFacade() {
        return ejbFacade;
    }

    public AlojamentoCoordenador prepareCreate() {
        selected = new AlojamentoCoordenador();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/app").getString("AlojamentoCoordenadorCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/app").getString("AlojamentoCoordenadorUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/app").getString("AlojamentoCoordenadorDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<AlojamentoCoordenador> getItems() {
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

    public AlojamentoCoordenador getAlojamentoCoordenador(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<AlojamentoCoordenador> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<AlojamentoCoordenador> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = AlojamentoCoordenador.class)
    public static class AlojamentoCoordenadorControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AlojamentoCoordenadorController controller = (AlojamentoCoordenadorController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "alojamentoCoordenadorController");
            return controller.getAlojamentoCoordenador(getKey(value));
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
            if (object instanceof AlojamentoCoordenador) {
                AlojamentoCoordenador o = (AlojamentoCoordenador) object;
                return getStringKey(o.getIdalojamentoCoordenador());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), AlojamentoCoordenador.class.getName()});
                return null;
            }
        }

    }

}
