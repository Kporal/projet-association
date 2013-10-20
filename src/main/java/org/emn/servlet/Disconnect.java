package org.emn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Disconnect
 */
public class Disconnect extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String location = "signin";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Disconnect() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect(location);
	}

}