package br.com.sgc.tool;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames = {"Faces Servlet"})
public class FilterTool implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		EntityManager entityManager = ConnectionJPA.getEntityManager();
		EntityTransaction entityTransaction = null;
		
		try {
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			request.setAttribute("session", entityManager);
			
			chain.doFilter(request, response);
			
			entityTransaction.commit();
		} catch (Exception e) {
			if (entityTransaction != null) {
				entityTransaction.rollback();
			}
		}finally {
			entityManager.close();
		}
		
		

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
