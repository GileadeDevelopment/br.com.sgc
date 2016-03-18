package br.com.sgc.tool;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionJPA {
	private static EntityManagerFactory entityManagerFactory;

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("SGCPU");
	}

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

}
