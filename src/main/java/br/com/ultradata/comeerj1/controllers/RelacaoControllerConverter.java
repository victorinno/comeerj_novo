/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultradata.comeerj1.controllers;

import br.com.ultradata.comeerj1.entidades.Relacao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Victor
 */
@FacesConverter(forClass = Relacao.class, value = "relacaoConverter")
public class RelacaoControllerConverter
        implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        RelacaoController controller = (RelacaoController) facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null, "relacaoController");
        return controller.getRelacao(getKey(value));
    }

    java.lang.Long getKey(String value) {
        java.lang.Long key;
        key = Long.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Long value) {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Relacao) {
            Relacao o = (Relacao) object;
            return getStringKey(o.getCodFichaInscricaoComeerjId());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Relacao.class.getName()});
            return null;
        }
    }

}
