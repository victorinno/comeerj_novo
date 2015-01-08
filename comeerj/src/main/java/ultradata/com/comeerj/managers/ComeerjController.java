package ultradata.com.comeerj.managers;

import ultradata.com.comeerj.modelo.Comeerj;
import ultradata.com.comeerj.managers.util.JsfUtil;
import ultradata.com.comeerj.managers.util.JsfUtil.PersistAction;
import ultradata.com.comeerj.beans.ComeerjFacade;

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

@Named("comeerjController")
@SessionScoped
public class ComeerjController implements Serializable {

    @EJB
    private ultradata.com.comeerj.beans.ComeerjFacade ejbFacade;
    private List<Comeerj> items = null;
    private Comeerj selected;

    public ComeerjController() {
    }

    public Comeerj getSelected() {
        return selected;
    }

    public void setSelected(Comeerj selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ComeerjFacade getFacade() {
        return ejbFacade;
    }

    public Comeerj prepareCreate() {
        selected = new Comeerj();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/home").getString("ComeerjCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/home").getString("ComeerjUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/home").getString("ComeerjDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Comeerj> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/home").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/home").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Comeerj getComeerj(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Comeerj> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Comeerj> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Comeerj.class)
    public static class ComeerjControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ComeerjController controller = (ComeerjController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "comeerjController");
            return controller.getComeerj(getKey(value));
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
            if (object instanceof Comeerj) {
                Comeerj o = (Comeerj) object;
                return getStringKey(o.getCodFichaInscricaoComeerjId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Comeerj.class.getName()});
                return null;
            }
        }

    }

}
