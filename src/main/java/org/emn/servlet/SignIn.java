package org.emn.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.emn.bean.User;
import org.emn.persistence.services.UserPersistence;
import org.emn.persistence.services.jpa.UserPersistenceJPA;
import org.emn.utils.Utilities;

/**
 * Servlet implementation class SignIn
 */
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String signinPage = "/jsp/signin.jsp";
	private UserPersistence userDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignIn() {
		super();
		userDAO = new UserPersistenceJPA();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(signinPage).forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> criteria = new HashMap<String, Object>();
		String login = request.getParameter("login");
		criteria.put("login", login);
		String pass = request.getParameter("pass");

		if (login == null) {
			request.setAttribute("error", true);
			request.getRequestDispatcher(signinPage).forward(request,
					response);
		} else {
			List<User> result = userDAO.search(criteria);
			if (result.size() != 1) {
				request.setAttribute("error", true);
				request.getRequestDispatcher(signinPage).forward(request,response);
			} else {
				User user = result.get(0);
				if (!user.getPassword().equals(pass)) {
					request.setAttribute("error", true);
					request.getRequestDispatcher(signinPage).forward(request, response);
				} else {
					Utilities.userConnect(request, response, user);
				}
			}
		}
	}
}