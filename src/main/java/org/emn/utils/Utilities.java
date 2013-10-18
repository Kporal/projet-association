package org.emn.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.emn.bean.User;

public class Utilities {

	//public static Utilities;
	
	//private Utilities() {}
	
	public static void userConnect(HttpServletRequest request,
			HttpServletResponse response, User user) throws ServletException, IOException
	{
/*		HttpSession session = request.getSession();
		session.setAttribute("userName", user.getLastName());
		session.setAttribute("userFirstName", user.getFirstName());
		session.setAttribute("userId", user.getId());

		request.getRequestDispatcher("/jsp/userIndex.jsp").forward(
				request, response);
*/
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		response.sendRedirect("home");
	}
}
