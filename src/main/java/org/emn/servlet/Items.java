package org.emn.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.emn.bean.Item;
import org.emn.bean.Order;
import org.emn.persistence.services.jpa.ItemPersistenceJPA;

/**
 * Servlet implementation class Items
 */
public class Items extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String jsp = "/jsp/signin.jsp";
	private static final String attrType = "type";
	private static final String attrMsg = "msg";
	private ItemPersistenceJPA itemPersistance;
	
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
			// si j'ajoute un article dans le panier
			if(request.getParameter("id") != null) {
				Map<String, String> res = addItemIntoCart(Integer.valueOf(request.getParameter("id")));
				request.setAttribute(attrType, res.get(attrType));
				request.setAttribute(attrMsg, res.get(attrMsg));
			}
			
			// chargement de tous les articles
			List<Item> items = itemPersistance.loadAll();
			request.setAttribute("items", items);
		} catch (Exception e) {
			request.setAttribute(attrType, "danger");
			request.setAttribute(attrMsg, "Une erreur est survenue lors de la récupération des articles !");
		}
		
		getServletContext().getRequestDispatcher(jsp).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(jsp).forward(request, response);
	}
	
	/**
	 * Permet d'ajouter un article dans le panier
	 * @param id
	 * @return List("type", attrMsg)
	 */
	private Map<String, String> addItemIntoCart(int id) {
		Map<String, String> res = new HashMap<String, String>();
		// récupération de l'article
		Item item = itemPersistance.load(id);
		// si le stock d'articles est suffisant
		if(item.stockRemove()) {
			// si l'article est déjà ajouté dans le panier
			//if(item.getListOfUser().contains(o))
			if(item.getListOfUser().contains(item.getId())) {
				// insertion de la commande
				Order order = new Order();
				order.setArticleId(item.getId());
				order.setUserId(1);
				/*HttpSession session = request.getSession();
				session.setAttribute("userName", user.getLastName());
				session.setAttribute("userFirstName", user.getFirstName());
				session.setAttribute("userId", user.getId());*/
				res.put(attrType, "success");
				res.put(attrMsg, "Félicitation, le produit "
						+ item.getName()
						+ " a bien été ajouté au panier !");
			} else { // produit déjà ajouté
				res.put(attrType, "warning");
				res.put(attrMsg, "Le produit "
						+ item.getName()
						+ " à déjà été ajouté dans le panier !");
			}
		} else { // stock insufisant
			res.put(attrType, "danger");
			res.put(attrMsg, "Erreur, le produit "
					+ item.getName()
					+ " n'a pas été ajouté au panier, le stock est insuffisant !");
		}
		return res;
	}
}