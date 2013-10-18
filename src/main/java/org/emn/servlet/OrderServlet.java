package org.emn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.emn.bean.Item;
import org.emn.bean.Order;
import org.emn.bean.OrderKey;
import org.emn.bean.User;
import org.emn.persistence.services.OrderPersistence;
import org.emn.persistence.services.jpa.OrderPersistenceJPA;

/**
 * Servlet implementation class Order
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderPersistence orderDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		orderDAO = new OrderPersistenceJPA();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			System.out.println(">>>"+user);
			if (user.getListOfItem() != null){
				System.out.println(">>>>"+user.getListOfItem());
				request.setAttribute("listItem", user.getListOfItem());
				getServletContext().getRequestDispatcher("/jsp/order.jsp").forward(request, response);
			}else{
				System.out.println(">>> Pas d'article dans user");
			}
		}else{
			System.out.println(">>> Pas de session...");
			response.sendRedirect("signin");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// BOUTON Annuler commande (vider la liste OU SUPPRIMER SESSION ?)
		HttpSession session = request.getSession();
		if (session != null) {
			User userold = (User) session.getAttribute("user");
			userold.getListOfItem().clear();
			session.setAttribute("user", userold);

			// Bouton valider commande (méthode à valider)
			User user = (User) session.getAttribute("user");
			if (user != null) {
				for (Item i : user.getListOfItem()){
					Order order = new Order();
					order.setArticleId(i.getId());
					order.setUserId(user.getId());
					orderDAO.insert(order);
				}
			}
		}
	}
}
