/*
 * Created on 7 oct. 2013 ( Time 10:50:03 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package org.emn.persistence.services;

import java.util.List;
import java.util.Map;

import org.emn.bean.User ;

/**
 * Basic persistence operations for entity "User"
 * 
 * This Bean has a basic Primary Key : int
 *
 * @author Telosys Tools Generator
 *
 */
public interface UserPersistence {

	/**
	 * Deletes the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param user
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(User user) ;

	/**
	 * Deletes the entity by its Primary Key <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param id
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(int id) ;

	/**
	 * Inserts the given entity and commit <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param user
	 */
	public void insert(User user) ;

	/**
	 * Loads the entity for the given Primary Key <br>
	 * @param id
	 * @return the entity loaded (or null if not found)
	 */
	public User load(int id) ;

	/**
	 * Loads ALL the entities (use with caution)
	 * @return
	 */
	public List<User> loadAll() ;

	/**
	 * Loads a list of entities using the given "named query" without parameter 
	 * @param queryName
	 * @return
	 */
	public List<User> loadByNamedQuery(String queryName) ;

	/**
	 * Loads a list of entities using the given "named query" with parameters 
	 * @param queryName
	 * @param queryParameters
	 * @return
	 */
	public List<User> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) ;

	/**
	 * Saves (create or update) the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param user
	 * @return
	 */
	public User save(User user) ;

	/**
	 * Search the entities matching the given search criteria
	 * @param criteria
	 * @return
	 */
	public List<User> search( Map<String, Object> criteria ) ;
}
