 package br.com.sgc.tool;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class FacesTool {
	
	public static void addMessages(Severity severity, String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity,message,message));
	}
	
	public static void addMessage_Error(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,message,message));
	}
	
	public static void addMessage_Info(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,message,message));
	}
	
	public static void addMessage_Warn(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,message,message));
	}
	
	public static void addMessage_Fatal(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,message,message));
	}
	
	public static Object getRequestAttribute(String nome) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		return request.getAttribute(nome);
	}
}
/*
 * Author: Gileade de Jesus
 * Status: Unfinished
 */