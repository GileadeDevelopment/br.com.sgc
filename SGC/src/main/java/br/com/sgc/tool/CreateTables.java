package br.com.sgc.tool;

import javax.persistence.Persistence;

public class CreateTables {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("SGCPU");
	}

}
