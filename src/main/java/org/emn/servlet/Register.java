package org.emn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.emn.bean.Country;
import org.emn.persistence.services.CountryPersistence;
import org.emn.persistence.services.UserPersistence;
import org.emn.persistence.services.jpa.CountryPersistenceJPA;
import org.emn.persistence.services.jpa.UserPersistenceJPA;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String registerErrorPage = "/jsp/register.jsp";
    private UserPersistence userDAO;
    private CountryPersistence countryDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        userDAO = new UserPersistenceJPA();
        countryDAO = new CountryPersistenceJPA();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Country> listCountry = countryDAO.loadAll();
		request.setAttribute("country", listCountry);
		getServletContext().getRequestDispatcher("/jsp/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Vérifie que les informations obligatoires sont renseignées
		if(checkAttribute(request, "login") || checkAttribute(request, "password") 
				|| checkAttribute(request, "firstName") || checkAttribute(request, "lastName"))
		{
			request.setAttribute("error", true);
			request.getRequestDispatcher(registerErrorPage).forward(request, response);
		}
		else
		{
			// Vérifie que les mots de passe correspondent
			if(request.getAttribute("password") != request.getAttribute("passwordConfirm"))
			{
				request.setAttribute("passNotMatch", true);
				request.getRequestDispatcher(registerErrorPage).forward(request, response);				
			}
			else
			{
				
			}
		}
	}
	
	private Boolean checkAttribute(HttpServletRequest request, String attribute)
	{
		return request.getAttribute(attribute) == null || request.getAttribute(attribute) =="";
	}

}
