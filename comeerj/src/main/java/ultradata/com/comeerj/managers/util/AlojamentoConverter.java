/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultradata.com.comeerj.managers.util;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import ultradata.com.comeerj.beans.util.AlojamentoFacade;
import ultradata.com.comeerj.beans.util.ComeerjFacade;
import ultradata.com.comeerj.modelo.Alojamento;
import ultradata.com.comeerj.modelo.Comeerj;

/**
 *
 * @author Victor
 */
@FacesConverter("AlojamentoConverter")
public class AlojamentoConverter implements Converter {

    @EJB
    AlojamentoFacade cf;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                //ComeerjController service = (ComeerjController) context.getExternalContext().getApplicationMap().get("comeerjController");
                return cf.find(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            return String.valueOf(((Alojamento) value).getIdalojamento());
        }
        else {
            return null;
        }
    }
    
}
