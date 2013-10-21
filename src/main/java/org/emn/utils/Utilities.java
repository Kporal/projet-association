package org.emn.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.emn.bean.User;

public class Utilities {
	
	/***
	 * Connecte un utilisateur au site.
	 * @param request
	 * @param response
	 * @param user Utilisateur se connectant
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void userConnect(HttpServletRequest request,
			HttpServletResponse response, User user) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		//user.getListOfItem().clear();
		session.setAttribute("user", user);
		
		response.sendRedirect("home");
	}
	
	/***
	 * Vérifie un attribut.
	 * @param attribute
	 * @return true si l'attribut n'est pas renseigné
	 */
	public static Boolean checkAttribute(Object attribute) {
		String test = (String) attribute;
		return test == null	|| test.trim().isEmpty();
	}
}
