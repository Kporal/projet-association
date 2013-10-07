/*
 * Created on 7 oct. 2013 ( Time 10:50:04 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package org.emn.persistence.services.fake;

import java.util.List;
import java.util.Map;

import org.emn.bean.User ;
import org.emn.persistence.commons.fake.GenericFakeService;
import org.emn.persistence.services.UserPersistence;

/**
 * Fake persistence service implementation ( entity "User" )
 *
 * @author Telosys Tools Generator
 */
public class UserPersistenceFAKE extends GenericFakeService<User> implements UserPersistence {

	public UserPersistenceFAKE () {
		super(User.class);
	}
	
	protected User buildEntity(int index) {
		User entity = new User();
		// Init fields with mock values
		entity.setId( nextInteger() ) ;
		entity.setLogin( nextString() ) ;
		entity.setPassword( nextString() ) ;
		entity.setLastName( nextString() ) ;
		entity.setFirstName( nextString() ) ;
		entity.setAddress( nextString() ) ;
		entity.setZipCode( nextString() ) ;
		entity.setCity( nextString() ) ;
		return entity ;
	}
	
	
	public boolean delete(User entity) {
		log("delete ( User : " + entity + ")" ) ;
		return true;
	}

	public boolean delete( int id ) {
		log("delete ( PK )") ;
		return true;
	}

	public void insert(User entity) {
		log("insert ( User : " + entity + ")" ) ;
	}

	public User load( int id ) {
		log("load ( PK )") ;
		return buildEntity(1) ; 
	}

	public List<User> loadAll() {
		log("loadAll()") ;
		return buildList(40) ;
	}

	public List<User> loadByNamedQuery(String queryName) {
		log("loadByNamedQuery ( '" + queryName + "' )") ;
		return buildList(20) ;
	}

	public List<User> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) {
		log("loadByNamedQuery ( '" + queryName + "', parameters )") ;
		return buildList(10) ;
	}

	public User save(User entity) {
		log("insert ( User : " + entity + ")" ) ;
		return entity;
	}

	public List<User> search(Map<String, Object> criteria) {
		log("search (criteria)" ) ;
		return buildList(15) ;
	}

}
