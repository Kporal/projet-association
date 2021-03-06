/*
 * Created on 7 oct. 2013 ( Time 10:49:51 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package org.emn.test.persistence;


import junit.framework.TestCase;

import org.emn.bean.Country;
import org.emn.bean.Item ;
import org.emn.mock.CountryMock;
import org.emn.mock.ItemMock;
import org.emn.persistence.PersistenceServiceProvider;
import org.emn.persistence.services.CountryPersistence;
import org.emn.persistence.services.ItemPersistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test case for Item persistence service
 * 
 * @author Telosys Tools Generator
 *
 */
public class ItemPersistenceTest extends TestCase{

	private ItemPersistence service;
	private ItemMock mock;
	private Item itemTest;

	/**
	 * <p>
	 * Code ex�cut� avant les tests.
	 * </p>
	 * 
	 * @throws Exception
	 *             toute exception.
	 */
	@Before
	public void setUp() throws Exception {
		service = PersistenceServiceProvider.getService(ItemPersistence.class);
		mock = new ItemMock();
	}

	/**
	 * <p>
	 * Code ex�cut� apr�s les tests.
	 * </p>
	 * 
	 * @throws Exception
	 *             toute exception.
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
	}
}
