/*
 * Created on 7 oct. 2013 ( Time 10:50:00 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package org.emn.test.persistence;


import org.emn.bean.Country ;
import org.emn.mock.CountryMock;
import org.emn.persistence.PersistenceServiceProvider;
import org.emn.persistence.services.CountryPersistence;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for Country persistence service
 * 
 * @author Telosys Tools Generator
 *
 */
public class CountryPersistenceTest 
{
	@Test
	public void test1() {
		
		System.out.println("Test Country persistence : delete + load ..." );
		
		CountryPersistence service = PersistenceServiceProvider.getService(CountryPersistence.class);
		
		CountryMock mock = new CountryMock();
		
		// TODO : set primary key values here 
		process( service, mock, 0  );
		// process( service, mock, ... );
	}

	private void process(CountryPersistence service, CountryMock mock, int id ) {
		System.out.println("----- "  );
		System.out.println(" . load : " );
		Country entity = service.load( id );
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

			// No reference : insert is possible 
			// Try to insert the new instance
			System.out.println(" . insert : " + entity );
			service.insert(entity);
			System.out.println("   inserted : " + entity );

			System.out.println(" . delete : " );
			boolean deleted = service.delete( id );
			System.out.println("   deleted = " + deleted);
			Assert.assertTrue(deleted) ;
		}		
	}
}
