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

		List<Country> listCountry = countryDAO.loadAll();
		request.setAttribute("country", listCountry);
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
		if (checkAttribute(request.getAttribute("login"))
				|| checkAttribute(request.getAttribute("password"))
				|| checkAttribute(request.getAttribute("firstName"))
				|| checkAttribute(request.getAttribute("lastName"))) {
			System.out.println("erreur champ obli");
			request.setAttribute("error", true);
			request.getRequestDispatcher(registerErrorPage).forward(request,
					response);
		} else {
			// Vérifie que les mots de passe correspondent
			if (!request.getAttribute("password").equals(request
					.getAttribute("passwordConfirm"))) {
				System.out.println("erreur mdp match");
				request.setAttribute("passNotMatch", true);
				request.getRequestDispatcher(registerErrorPage).forward(
						request, response);
			} else {
				
				Map<String,Object> criteria = new HashMap<String,Object>();
				criteria.put("login", request.getAttribute("login"));
				if(!userDAO.search(criteria).isEmpty())
				{
					System.out.println("existe deja");
					request.setAttribute("loginAlreadyUsed", true);
					request.getRequestDispatcher(registerErrorPage).forward(
							request, response);
				}
				else
				{
					System.out.println("OK");
					User user = new User();
					user.setLogin((String)request.getAttribute("login"));
					user.setPassword((String)request.getAttribute("password"));
					user.setLastName((String)request.getAttribute("lastName"));
					user.setFirstName((String)request.getAttribute("firstName"));
					user.setAddress((String)request.getAttribute("address"));
					user.setCity((String)request.getAttribute("city"));
					user.setCountry((Country)request.getAttribute("country"));
					user.setZipCode((String)request.getAttribute("zipCode"));
					
					userDAO.insert(user);
					
					Utilities.userConnect(request, response, user);
				}
			}
		}
	}

	private Boolean checkAttribute(Object attribute) {
		String test = (String) attribute;
		return test == null	|| test.trim().isEmpty();
	}

}
