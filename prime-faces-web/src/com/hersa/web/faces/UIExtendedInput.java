package com.hersa.web.faces;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIInput;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;

@FacesComponent("extendedInput")
public class UIExtendedInput extends UIInput implements NamingContainer {

    public UIExtendedInput() {
    	
    }
    
    @Override
    public void decode(FacesContext context) {
    	super.decode(context);
    }
    /**
     * Returns the component family of {@link UINamingContainer}.
     * (that's just required by composite component)
     */
    @Override
    public String getFamily() {
        return UINamingContainer.COMPONENT_FAMILY;
    }

    /**
     * Set the selected and available values of the day, month and year fields based on the model.
     */
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
    	setDisplayInputText(true);
    	setDisplaySelectOne(false);

    	AttributeMap attr = (AttributeMap) getAttributes().get("fieldObject");
    	String allowedValues = attr.getAllowedValues();
    	Map<String, String > selectOptions = new HashMap<String,String>();
    	if (allowedValues != null && !allowedValues.isEmpty()) {
    		setDisplayInputText(false);
    		setDisplaySelectOne(true);
    		String[] keyValString = allowedValues.split(";");
			for (String valString : keyValString) {
				String[] opt = valString.split("=");
				selectOptions.put(opt[0], opt[1]);
			}
		}
    	setChoices(selectOptions);
       
       /* choice.setValue(opt);*/
        super.encodeBegin(context);
    }
  
     
    @Override
    public void validate(FacesContext arg0) {
    	super.validate(arg0);
    }
    
    @Override
    public void encodeEnd(FacesContext context) throws IOException {
    	super.encodeEnd(context);
    }

    /**
     * Converts the submitted value to concrete {@link Date} instance.
     */
    @Override
    protected Object getConvertedValue(FacesContext context, Object submittedValue) {
    	return submittedValue;
    }

    // Helpers ------------------------------------------------------------------------------------

    /**
     * Return specified attribute value or otherwise the specified default if it's null.
     */
    @SuppressWarnings("unchecked")
    private <T> T getAttributeValue(String key, T defaultValue) {
        T value = (T) getAttributes().get(key);
        return (value != null) ? value : defaultValue;
    }

    private static Integer[] createIntegerArray(int begin, int end) {
        int direction = (begin < end) ? 1 : (begin > end) ? -1 : 0;
        int size = Math.abs(end - begin) + 1;
        Integer[] array = new Integer[size];

        for (int i = 0; i < size; i++) {
            array[i] = begin + (i * direction);
        }

        return array;
    }

    // Getters/setters ----------------------------------------------------------------------------

	public void setChoices(Map<String, String> choices) {
		getStateHelper().put("choices", choices);
	}
	@SuppressWarnings("unchecked")
	public Map<String, String> getChoices(){
		return (Map<String, String>) getStateHelper().get("choices");
	}
	public boolean isDisplaySelectOne() {
		return (Boolean) getStateHelper().get("displaySelectOne");
	}
	public void setDisplaySelectOne(boolean displaySelectOne) {
		getStateHelper().put("displaySelectOne", displaySelectOne);
	}
	public boolean isDisplayInputText() {
		return (Boolean) getStateHelper().get("displayInputText");
	}
	public void setDisplayInputText(boolean displayInputText) {
		getStateHelper().put("displayInputText", displayInputText);
	}
}