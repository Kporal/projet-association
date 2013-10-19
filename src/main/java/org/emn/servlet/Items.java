package org.emn.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.emn.bean.Item;
import org.emn.bean.User;
import org.emn.persistence.services.ItemPersistence;
import org.emn.persistence.services.jpa.ItemPersistenceJPA;

/**
 * Servlet implementation class Items
 */
public class Items extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String jsp = "/jsp/items.jsp";
	private static final String attrType = "type";
	private static final String attrMsg = "msg";
	private ItemPersistence itemPersistance;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Items() {
		super();
		itemPersistance = new ItemPersistenceJPA();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Item> items = (List<Item>) request.getSession().getAttribute("items");
			if(items == null) {
				// chargement de tous les articles
				items = itemPersistance.loadAll();
				request.getSession().setAttribute("items", items);
			}
			User user = (User) request.getSession().getAttribute("user");
			// si j'ajoute un article dans le panier
			if (request.getParameter("id") != null) {
				// récupération de l'article
				Item item = null;
				for(Item i : items) {
					if(i.getId() == Integer.valueOf(request.getParameter("id")))
						item = i;
				}
				//Item item = itemPersistance.load(Integer.valueOf(request.getParameter("id")));
				Map<String, String> res = addItemIntoCart(item, user);
				request.setAttribute(attrType, res.get(attrType));
				request.setAttribute(attrMsg, res.get(attrMsg));
			}
			request.setAttribute("items", items);
		} catch (Exception e) {
			request.setAttribute(attrType, "danger");
			request.setAttribute(attrMsg,
					"Une erreur est survenue lors de la récupération des articles !");
		}

		getServletContext().getRequestDispatcher(jsp).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(jsp)
				.forward(request, response);
	}

	/**
	 * Permet d'ajouter un article dans le panier
	 * 
	 * @param id
	 * @return List("type", attrMsg)
	 */
	private Map<String, String> addItemIntoCart(Item item, User user) {
		Map<String, String> res = new HashMap<String, String>();
		// si l'article est déjà ajouté dans le panier de l'utilisateur
		if (user != null
				&& (user.getListOfItem() == null || !existItem(
						user.getListOfItem(), item))) {
			// si le stock d'articles est suffisant
			if (item.stockRemove()) {
				// insertion de la commande
				user.getListOfItem().add(item);
				item.getListOfUser().add(user);

				res.put(attrType, "success");
				res.put(attrMsg, "Félicitation, le produit \"" + item.getName()
						+ "\" a bien été ajouté au panier !");
			} else { // stock insufisant
				res.put(attrType, "danger");
				res.put(attrMsg,
						"Erreur, le produit \""
								+ item.getName()
								+ "\" n'a pas été ajouté au panier, le stock est insuffisant !");
			}
		} else { // produit déjà ajouté
			res.put(attrType, "warning");
			res.put(attrMsg, "Le produit \"" + item.getName()
					+ "\" à déjà été ajouté dans le panier !");
		}
		return res;
	}

	/**
	 * Test si l'id de l'article est déjà ajouté dans le panier
	 * 
	 * @param listOfItem
	 * @param item
	 * @return boolean
	 */
	private boolean existItem(List<Item> listOfItem, Item item) {
		for (Item i : listOfItem) {
			if (i.getId() == item.getId())
				return true;
		}
		return false;
	}
}