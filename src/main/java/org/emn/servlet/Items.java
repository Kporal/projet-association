package org.emn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.emn.bean.Item;
import org.emn.bean.Order;
import org.emn.persistence.services.jpa.ItemPersistenceJPA;
import org.emn.persistence.services.jpa.OrderPersistenceJPA;

/**
 * Servlet implementation class Items
 */
public class Items extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Items() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ItemPersistenceJPA ip = new ItemPersistenceJPA();
		List<Item> items = ip.loadAll();
		request.setAttribute("items", items);
		getServletContext().getRequestDispatcher("/jsp/items.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			ItemPersistenceJPA ip = new ItemPersistenceJPA();
			Item item = ip.load(Integer.valueOf(request.getParameter("id")));
			// si le stock d'articles est suffisant
			if(item.getStock() >= 1) {
				// si l'article est déjà ajouté dans le panier
				//if(item.getListOfUser().contains(o))
				if(item.getStock() >= 1) {
					OrderPersistenceJPA op = new OrderPersistenceJPA();
					// insertion de la commande
					Order order = new Order();
					order.setArticleId(item.getId());
					order.setUserId(1);
					op.insert(order);
					// maj du stock
					item.stockRemove();
					//ip.save(item);
					// passage des params à la vue
					request.setAttribute("type", "success");
					request.setAttribute("msg", "Félicitation, le produit "
							+ item.getName()
							+ " a bien été ajouté au panier !");
				} else {
					request.setAttribute("type", "warning");
					request.setAttribute("msg", "Le produit "
							+ item.getName()
							+ " à déjà été ajouté dans le panier !");
				}
			} else {
				request.setAttribute("type", "danger");
				request.setAttribute("msg", "Erreur, le produit "
						+ item.getName()
						+ " n'a pas été ajouté au panier, le stock est insuffisant !");
			}
			List<Item> items = ip.loadAll();
			request.setAttribute("items", items);
		} catch (Exception e) {
			request.setAttribute("type", "danger");
			request.setAttribute("msg", "Une erreur est survenue !");
		}

		getServletContext().getRequestDispatcher("/jsp/items.jsp").forward(request, response);
	}
}