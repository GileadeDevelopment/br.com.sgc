package br.com.sgc.service;

import java.io.Serializable;

public class BusinessException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public BusinessException(String message) {
		super(message);
	}
	
}
