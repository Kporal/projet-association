/*
 * Created on 7 oct. 2013 ( Time 10:50:04 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */

package org.emn.persistence.services.jpa;

import org.emn.bean.User ;
import org.emn.persistence.commons.jpa.GenericJpaService;
import org.emn.persistence.services.UserPersistence;

/**
 * JPA implementation for basic persistence operations ( entity "User" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class UserPersistenceJPA extends GenericJpaService<User, Integer> implements UserPersistence {

	/**
	 * Constructor
	 */
	public UserPersistenceJPA() {
		super(User.class);
	}

	public User load( int id ) {
		return super.load( id );
	}

	public boolean delete( int id ) {
		return super.delete( id );
	}

	public boolean delete(User entity) {
		if ( entity != null ) {
			return super.delete( entity.getId() );
		}
		return false ;
	}

}
