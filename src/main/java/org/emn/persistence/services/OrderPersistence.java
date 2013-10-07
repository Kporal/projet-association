/*
 * Created on 7 oct. 2013 ( Time 10:49:53 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package org.emn.persistence.services;

import java.util.List;
import java.util.Map;

import org.emn.bean.Order ;

/**
 * Basic persistence operations for entity "Order"
 * 
 * This Bean has a composite Primary Key : OrderKey
 *
 * @author Telosys Tools Generator
 *
 */
public interface OrderPersistence {

	/**
	 * Deletes the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param order
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(Order order) ;

	/**
	 * Deletes the entity by its Primary Key <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param userId
	 * @param articleId
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(int userId, int articleId) ;

	/**
	 * Inserts the given entity and commit <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param order
	 */
	public void insert(Order order) ;

	/**
	 * Loads the entity for the given Primary Key <br>
	 * @param userId
	 * @param articleId
	 * @return the entity loaded (or null if not found)
	 */
	public Order load(int userId, int articleId) ;

	/**
	 * Loads ALL the entities (use with caution)
	 * @return
	 */
	public List<Order> loadAll() ;

	/**
	 * Loads a list of entities using the given "named query" without parameter 
	 * @param queryName
	 * @return
	 */
	public List<Order> loadByNamedQuery(String queryName) ;

	/**
	 * Loads a list of entities using the given "named query" with parameters 
	 * @param queryName
	 * @param queryParameters
	 * @return
	 */
	public List<Order> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) ;

	/**
	 * Saves (create or update) the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param order
	 * @return
	 */
	public Order save(Order order) ;

	/**
	 * Search the entities matching the given search criteria
	 * @param criteria
	 * @return
	 */
	public List<Order> search( Map<String, Object> criteria ) ;
}
