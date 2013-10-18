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
		String action = request.getParameter("action");

		if (action != null){
			if (action.equalsIgnoreCase("annuler")){
				// Cas action == annuler
				System.out.println(">> annuler");
				User userold = (User) session.getAttribute("user");
				userold.getListOfItem().clear();
				session.setAttribute("user", userold);
			}else if (action.equalsIgnoreCase("valider")){
				// Cas action == valider
				System.out.println(">> valider");
				if ((user != null) && (user.getListOfItem() != null)) {
					for (Item i : user.getListOfItem()){
						Order order = new Order();
						order.setArticleId(i.getId());
						order.setUserId(user.getId());
						orderDAO.insert(order);
					}
				}
			}
		} else{
			// Cas action == null
			System.out.println(">> autre");
			if ((user != null) && (user.getListOfItem() != null))  {
				System.out.println(">>>>"+user.getListOfItem());
				request.setAttribute("listItem", user.getListOfItem());
			}
		}
		
		getServletContext().getRequestDispatcher("/jsp/order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO
	}
}
