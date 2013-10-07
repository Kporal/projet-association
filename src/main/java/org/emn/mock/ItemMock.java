
/*
 * Created on 7 oct. 2013 ( Time 10:49:48 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package org.emn.mock;

import java.util.LinkedList;
import java.util.List;

import org.emn.bean.Item ;
import org.emn.mock.tool.MockValues;

public class ItemMock {

	private MockValues mockValues = new MockValues();
	
	/**
	 * Creates an instance with random Primary Key
	 * @return
	 */
	public Item createInstance() {
		// Primary Key values

		return createInstance( mockValues.nextInteger() );
	}
	
	/**
	 * Creates an instance with a specific Primary Key
	 * @param id1
	 * @return
	 */
	public Item createInstance( int id ) {
		Item entity = new Item();
		// Init Primary Key fields
		entity.setId( id) ;
		// Init Data fields
		entity.setCode( mockValues.nextString(5) ) ; // java.lang.String 
		entity.setName( mockValues.nextString(50) ) ; // java.lang.String 
		entity.setPrice( mockValues.nextDouble() ) ; // java.lang.Double 
		entity.setStock( mockValues.nextInteger() ) ; // java.lang.Integer 
		// Init Link fields (if any)
		// setListOfUser( TODO ) ; // List<User> 
		return entity ;
	}
	
	/**
	 * Creates a list of instances
	 * @param count number of instances to be created
	 * @return
	 */
	public List<Item> createList(int count) {
		List<Item> list = new LinkedList<Item>();		
		for ( int i = 1 ; i <= count ; i++ ) {
			list.add( createInstance() );
		}
		return list;
	}
}