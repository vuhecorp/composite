package com.hersa.web.faces.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.hersa.web.faces.AttributeMap;
import com.hersa.web.faces.UIExtendedInput;

@FacesValidator("com.hersa.web.faces.validator.ExtendedInputValidator")
public class ExtendedInputValidator implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {

		//check if tag specified default validation. 
		UIExtendedInput comp = (UIExtendedInput) UIComponent.getCurrentCompositeComponent(arg0);
		boolean doDefaultValidation = (Boolean) comp.getAttributes().get("defaultValidator");
		
		
		if (doDefaultValidation) {

			//get the submitted value from the UIInput component.
			String value = (String) ((UIInput) arg1).getSubmittedValue();
			
			//get attribute map for validation values.
			AttributeMap attributeMap = (AttributeMap) comp.getAttributes().get("fieldObject");
			String fieldName = attributeMap.getDisplayName();
			
			//validate for required.
			boolean required = attributeMap.isRequired();
			if(required && value == null || value.isEmpty()) {
				arg0.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, value, fieldName + " is required."));
			}
			
			//validate for length.
			int maxLen = attributeMap.getMaxLength();
			int minLen = attributeMap.getMinLengt();
			
			boolean validateMinLen = minLen > 0;
			boolean validateMaxLen = maxLen > 0;
			boolean validateLength = validateMinLen || validateMaxLen;
		
			if (validateLength) {
				if(validateMinLen) {
					if (value.length() < minLen) {
						arg0.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, value, " length is less than " + minLen + " characters."));
					}
				}
				
				if (validateMaxLen) {
					if(value.length() > maxLen) {
						arg0.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, value, " length is greater than " + maxLen + " characters."));
					}
				}
			}
		}
	}
}
