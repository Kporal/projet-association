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
	private static final String registerErrorPage = "register";
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
		System.out.println("countries got");
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
		if (checkAttribute(request.getParameter("login"))
				|| checkAttribute(request.getParameter("password"))
				|| checkAttribute(request.getParameter("firstName"))
				|| checkAttribute(request.getParameter("lastName"))) {
			System.out.println("erreur champ obli");
			request.setAttribute("error", true);
		//	request.getRequestDispatcher(registerErrorPage).forward(request,
			//		response);
			response.sendRedirect(registerErrorPage);
		} else {
			// Vérifie que les mots de passe correspondent
			if (!request.getParameter("password").equals(request
					.getParameter("passwordConfirm"))) {
				System.out.println("erreur mdp match");
				request.setAttribute("passNotMatch", true);
//				request.getRequestDispatcher(registerErrorPage).forward(
	//					request, response);

				response.sendRedirect(registerErrorPage);
			} else {
				
				Map<String,Object> criteria = new HashMap<String,Object>();
				criteria.put("login", request.getParameter("login"));
				if(!userDAO.search(criteria).isEmpty())
				{
					System.out.println("existe deja");
					request.setAttribute("loginAlreadyUsed", true);
					//request.getRequestDispatcher(registerErrorPage).forward(
						//	request, response);
					response.sendRedirect(registerErrorPage);
				}
				else
				{
					System.out.println("OK");
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
					
					userDAO.save(user);
					
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
