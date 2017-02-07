package ultradata.com.comeerj.managers.util;

import ultradata.com.comeerj.modelo.DadosEquipe;
import ultradata.com.comeerj.managers.util.util.JsfUtil;
import ultradata.com.comeerj.managers.util.util.JsfUtil.PersistAction;
import ultradata.com.comeerj.beans.util.DadosEquipeFacade;

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

@Named("dadosEquipeController")
@SessionScoped
public class DadosEquipeController implements Serializable {

    @EJB
    private ultradata.com.comeerj.beans.util.DadosEquipeFacade ejbFacade;
    private List<DadosEquipe> items = null;
    private DadosEquipe selected;

    public DadosEquipeController() {
    }

    public DadosEquipe getSelected() {
        return selected;
    }

    public void setSelected(DadosEquipe selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DadosEquipeFacade getFacade() {
        return ejbFacade;
    }

    public DadosEquipe prepareCreate() {
        selected = new DadosEquipe();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/app").getString("DadosEquipeCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/app").getString("DadosEquipeUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/app").getString("DadosEquipeDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<DadosEquipe> getItems() {
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

    public DadosEquipe getDadosEquipe(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<DadosEquipe> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<DadosEquipe> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = DadosEquipe.class)
    public static class DadosEquipeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DadosEquipeController controller = (DadosEquipeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "dadosEquipeController");
            return controller.getDadosEquipe(getKey(value));
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
            if (object instanceof DadosEquipe) {
                DadosEquipe o = (DadosEquipe) object;
                return getStringKey(o.getIddadosEquipe());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DadosEquipe.class.getName()});
                return null;
            }
        }

    }

}
