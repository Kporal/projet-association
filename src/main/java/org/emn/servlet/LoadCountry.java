package org.emn.servlet;

import java.io.IOException;



import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="Servlet LoadCountry", urlPatterns="/jsp/register.jsp")
public class LoadCountry extends HttpServlet  {
	
	//this is thread-safe
	@PersistenceUnit(unitName="projet-association")
	private EntityManagerFactory emf;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("Country.findAll");
		List<?> listCountry = query.getResultList();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(listCountry);
		em.close();
	}
}
