package org.emn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.emn.bean.Item;
import org.emn.bean.User;
import org.emn.persistence.services.ItemPersistence;
import org.emn.persistence.services.OrderPersistence;
import org.emn.persistence.services.jpa.ItemPersistenceJPA;
import org.emn.persistence.services.jpa.OrderPersistenceJPA;

/**
 * Servlet implementation class Order
 */
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String jsp = "/jsp/order.jsp";
	private static final String attrType = "type";
	private static final String attrMsg = "msg";
	private OrderPersistence orderDAO;
	private ItemPersistence itemDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Order() {
		super();
		orderDAO = new OrderPersistenceJPA();
		itemDAO = new ItemPersistenceJPA();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			String action = request.getParameter("action");

			if (action != null) {
				if (action.equalsIgnoreCase("annuler")) {
					actionAnnuler(request, session);
					getServletContext().getRequestDispatcher("/jsp/userIndex.jsp").forward(request, response);
				} else if (action.equalsIgnoreCase("valider")) {
					actionValider(request, session, user);
					getServletContext().getRequestDispatcher(jsp).forward(request, response);
				}
			} else {
				getServletContext().getRequestDispatcher(jsp).forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute(attrType, "danger");
			request.setAttribute(attrMsg,"Une erreur est survenue lors de la récupération des articles du panier !");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO
	}

	/**
	 * Méthode permettant de vider le panier d'un client
	 * @param request
	 * @param response 
	 * @param session
	 */
	private void actionAnnuler(HttpServletRequest request, HttpSession session) {
		User userold = (User) session.getAttribute("user");
		if (userold != null && userold.getListOfItem() != null) {
			for(Item i : userold.getListOfItem()) {
				i.stockAdd();
			}
			userold.getListOfItem().clear();
			session.setAttribute("user", userold);
		}

		request.setAttribute(attrType, "success");
		request.setAttribute(attrMsg, "Votre panier a été vidé !");
	}

	/**
	 * Méthode permettant de valider la commande d'un client
	 * @param request
	 * @param session
	 * @param user
	 */
	private void actionValider(HttpServletRequest request, HttpSession session,
			User user) {
		if ((user != null) && (user.getListOfItem() != null)) {
			for (Item i : user.getListOfItem()) {
				// pour chaque item, on enregistre son nouveau stock dans la base
				itemDAO.save(i);
				// Enregistrement de la commande
				org.emn.bean.Order order = new org.emn.bean.Order();
				order.setArticleId(i.getId());
				order.setUserId(user.getId());
				orderDAO.insert(order);
			}
		}
		
		User userold = (User) session.getAttribute("user");
		userold.getListOfItem().clear();
		session.setAttribute("user", userold);
		request.setAttribute(attrType, "success");
		request.setAttribute(attrMsg, "Votre commande a été validée !");
	}
}
