 package br.com.sgc.tool;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

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
}
