package org.emn.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.emn.bean.Country;
import org.emn.bean.User;
import org.emn.persistence.services.CountryPersistence;
import org.emn.persistence.services.UserPersistence;
import org.emn.persistence.services.jpa.CountryPersistenceJPA;
import org.emn.persistence.services.jpa.UserPersistenceJPA;
import org.emn.utils.Utilities;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String registerErrorPage = "/jsp/register.jsp";
	private static final String errorDescription = "errorText";
	
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		setCountries(request);
		getServletContext().getRequestDispatcher("/jsp/register.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// Vérifie que les informations obligatoires sont renseignées
		System.out.println("start register");
		
		if (Utilities.checkAttribute(request.getParameter("login"))
				|| Utilities.checkAttribute(request.getParameter("password"))
				|| Utilities.checkAttribute(request.getParameter("firstName"))
				|| Utilities.checkAttribute(request.getParameter("lastName"))) {
			System.out.println("erreur champ obli");
			request.setAttribute(errorDescription, "Champs obligatoire manquant");
		} else {
			// Vérifie que les mots de passe correspondent
			if (!request.getParameter("password").equals(request
					.getParameter("passwordConfirm"))) {
				System.out.println("erreur mdp match");
				request.setAttribute(errorDescription, "Les mots de passe ne sont pas identiques");
			} else {
				
				Map<String,Object> criteria = new HashMap<String,Object>();
				criteria.put("login", request.getParameter("login"));
				
				// Vérification de la disponibilité du login
				if(!userDAO.search(criteria).isEmpty())
				{
					System.out.println("existe déjà");
					request.setAttribute(errorDescription, "Identifiant déjà pris");
				}
				// Création du nouvel utilisateur
				else
				{
					System.out.println("OK");
					// Préparation de l'enregistrement
					User user = new User();
					user.setLogin((String)request.getParameter("login"));
					user.setPassword((String)request.getParameter("password"));
					user.setLastName((String)request.getParameter("lastName"));
					user.setFirstName((String)request.getParameter("firstName"));
					user.setAddress((String)request.getParameter("address"));
					user.setCity((String)request.getParameter("city"));
										
					try{
						int countryId = Integer.parseInt(request.getParameter("country"));
						user.setCountry(countryDAO.load(countryId));
					}
					finally { }
					
					user.setZipCode((String)request.getParameter("zipCode"));
					
					// Enregistrement
					userDAO.save(user);
					
					// Connexion
					Utilities.userConnect(request, response, user);
					return;
				}
			}
		}
		if(request.getAttribute(errorDescription) != null)
		{
			setCountries(request);
			getServletContext().getRequestDispatcher(registerErrorPage).forward(
					request, response);
		}
	}
	
	private void setCountries(HttpServletRequest request)
	{
		// Remplissage de la liste des pays
		List<Country> listCountry = countryDAO.loadAll();
		request.setAttribute("country", listCountry);
	}
}
