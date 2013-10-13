/*
 * Created on 7 oct. 2013 ( Time 10:50:05 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package org.emn.test.persistence;


import junit.framework.TestCase;

import org.emn.bean.User ;
import org.emn.mock.OrderMock;
import org.emn.mock.UserMock;
import org.emn.persistence.PersistenceServiceProvider;
import org.emn.persistence.services.OrderPersistence;
import org.emn.persistence.services.UserPersistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test case for User persistence service
 * 
 * @author Telosys Tools Generator
 *
 */
public class UserPersistenceTest extends TestCase {
	
	private UserPersistence service;
	private UserMock mock;
	private User userTest;
	
	/**
	 * <p>Code ex�cut� avant les tests.</p>
	 * @throws Exception toute exception.
	 */
	@Before
	public void setUp() throws Exception {
		service = PersistenceServiceProvider.getService(UserPersistence.class);
		mock = new UserMock();
	}

	/**
	 * <p>Code ex�cut� apr�s les tests.</p>
	 * @throws Exception toute exception.
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test1() {
		
		System.out.println("Test User persistence : delete + load ..." );
		
		// TODO : set primary key values here 
		process( service, mock, 0  );
		// process( service, mock, ... );
	}

	private void process(UserPersistence service, UserMock mock, int id ) {
		System.out.println("----- "  );
		System.out.println(" . load : " );
		User entity = service.load( id );
		if ( entity != null ) {
			// Found 
			System.out.println("   FOUND : " + entity );
			
			// Save (update) with the same values to avoid database integrity errors  
			System.out.println(" . save : " + entity );
			service.save(entity);
			System.out.println("   saved : " + entity );
		}
		else {
			// Not found 
			System.out.println("   NOT FOUND" );
			// Create a new instance 
			entity = mock.createInstance( id ) ;
			Assert.assertNotNull(entity);

			// This entity references the following entities : 
			// . Country
			/* Insert only if references are OK
			// Try to insert the new instance
			System.out.println(" . insert : " + entity );
			service.insert(entity);
			System.out.println("   inserted : " + entity );
			*/

			System.out.println(" . delete : " );
			boolean deleted = service.delete( id );
			System.out.println("   deleted = " + deleted);
		}		
	}
}
