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
		if (session != null) {
			User user = (User) session.getAttribute("user");
			if (user != null) {
				System.out.println(">>>"+user);
				//request.setAttribute("listItem", user.getListOfItem());
				//getServletContext().getRequestDispatcher("/jsp/order.jsp").forward(request, response);
			}else{
				System.out.println(">>> Pas de session...");
				response.sendRedirect("signin");
			}
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
					// Y'a un bug là... Pas trop d'idée...
					OrderKey orderkey = new OrderKey(user.getId(), i.getId());
					Order order = new Order();
					order.setCompositePrimaryKey(orderkey);
					orderDAO.insert(order);
				}
			}
		}
	}
}
