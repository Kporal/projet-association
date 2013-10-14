package org.emn.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.emn.bean.User;
import org.emn.persistence.services.UserPersistence;
import org.emn.persistence.services.jpa.UserPersistenceJPA;

/**
 * Servlet implementation class SignIn
 */
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String signinErrorPage = "/jsp/signin.jsp";
    private UserPersistence userDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        userDAO = new UserPersistenceJPA();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/jsp/signin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,Object> criteria = new HashMap<String,Object>();
		String login = request.getParameter("login");
		criteria.put("login", login);
		String pass = request.getParameter("pass");
		
		if(login == null)
		{
			request.setAttribute("error", true);
			request.getRequestDispatcher(signinErrorPage).forward(request, response);
		}
		else
		{
			List<User> result = userDAO.search(criteria);
			System.out.println(login +" "+pass);
			if(result.size() != 1)
			{
				System.out.println("erreur1 : nb user = "+result.size());
				request.setAttribute("error", true);
				request.getRequestDispatcher(signinErrorPage).forward(request, response);
			}
			else
			{
				User user = result.get(0);
				if(user.getPassword() != pass)
				{
					System.out.println("att : "+ user.getPassword() + "  reçu : "+pass);
					request.setAttribute("error", true);
					request.getRequestDispatcher(signinErrorPage).forward(request, response);				
				}
				else
				{
					System.out.println("OK");
					HttpSession session = request.getSession();
					session.setAttribute("userName", user.getLastName());
					session.setAttribute("userFirstName", user.getFirstName());
					session.setAttribute("userId", user.getId());
					
					request.getRequestDispatcher("/jsp/userIndex.jsp").forward(request, response);
				}
			}
		}
	}
}
