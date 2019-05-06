package com.hersa.web.faces;

public class AttributeMap {
	
	private String name;
	private String displayName;
	private String defaultValue;
	private String type;
	private String allowedValues;
	private String format;
	
	private int maxLength;
	private int minLengt;
	private boolean required;
	
	public AttributeMap() {
		this.defaultValue = "2019-04-04";
		this.name = "vacancy";
		this.type = "date";
		this.required = true;
		this.allowedValues = "";
		//OCC=OCCUPIED;VCNT=VACANT <-- paste this into allowedValues.
		this.minLengt = 2;
		this.maxLength = 5;
		this.displayName = "Transaction Date";
		this.format = "yyyy/MM/dd";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAllowedValues() {
		return allowedValues;
	}

	public void setAllowedValues(String allowedValues) {
		this.allowedValues = allowedValues;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public int getMinLengt() {
		return minLengt;
	}

	public void setMinLengt(int minLengt) {
		this.minLengt = minLengt;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
}
