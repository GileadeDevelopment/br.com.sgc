package br.com.sgc.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.faces.util.MessageFactory;

@FacesValidator("RequiredConditional")
public class RequiredConditional implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		Boolean checkBox = (Boolean)component.getAttributes().get("checkBoxpago");
		System.out.println(checkBox);
		
		if(checkBox!=null&&checkBox&& value == null){
			Object label = MessageFactory.getLabel(context, component);
			String error  = "Preeencha o campo "+label+".";
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, error, error);
			throw new ValidatorException(facesMessage);
		}

	}

}
