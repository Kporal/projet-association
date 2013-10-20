package org.emn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SessionFilter
 */
public class SessionFilter implements Filter {

	
    /**
     * Default constructor. 
     */
    public SessionFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		// Si la session n'existe pas, on renvoie sur la page de connexion
		if(httpRequest.getSession(false) == null || httpRequest.getSession(false).getAttribute("user")== null)
		{
			((HttpServletResponse)response).sendRedirect("signin");
		}
		else
		{
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
