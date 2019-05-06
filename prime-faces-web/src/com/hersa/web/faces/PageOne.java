package com.hersa.web.faces;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PageOne extends SessionClass implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2092126203759709433L;
	private Date date1;
	private Object occp;
	private String message;
	
	private Map<String, AttributeMap> fieldMap;
	
	public PageOne() {
		setTestString("hello");
		fieldMap = new HashMap<String, AttributeMap>();
		fieldMap.put("vacancy", new AttributeMap());
		occp = new String("VCNT");
		date1 = new Date();
		message = "hello";
	}
	
	public String submit() {
		System.err.println(date1.toString());
	//	System.err.println(occp.toString());
		return "";
	}
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Map<String, AttributeMap> getFieldMap() {
		return fieldMap;
	}

	public void setFieldMap(Map<String, AttributeMap> fieldMap) {
		this.fieldMap = fieldMap;
	}

	public Object getOccp() {
		return occp;
	}

	public void setOccp(Object occp) {
		this.occp = occp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
