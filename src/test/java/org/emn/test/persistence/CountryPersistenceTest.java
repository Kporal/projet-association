/*
 * Created on 7 oct. 2013 ( Time 10:50:00 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package org.emn.test.persistence;

import junit.framework.TestCase;

import org.emn.bean.Country;
import org.emn.mock.CountryMock;
import org.emn.persistence.PersistenceConfig;
import org.emn.persistence.PersistenceServiceProvider;
import org.emn.persistence.services.CountryPersistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test case for Country persistence service
 * 
 * @author Telosys Tools Generator
 * 
 */
public class CountryPersistenceTest extends TestCase {

	private CountryPersistence service;
	private CountryMock mock;
	private Country countryTest;

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
		service = PersistenceServiceProvider.getService(CountryPersistence.class);
		mock = new CountryMock();
		countryTest = mock.createInstance(999999);
		service.insert(countryTest);
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
		service.delete(countryTest);
		service.delete(9999991);
	}

	@Test
	public void testInsertCountry() {
		System.out.println(" -> Test insert : ");

		// Insertion d'un nouveau pays en base
		Country country = mock.createInstance(9999991);
		service.insert(country);
		
		// Chargement du pays en base avec le m�me ID
		Country countryLoad = service.load(9999991);
		Assert.assertEquals(country.toString(), countryLoad.toString());
		System.out.println(" ----- ");
	}

	@Test
	public void testLoadCountry() {
		System.out.println(" -> Test load : ");

		Country countryLoad = service.load(999999);
		Assert.assertEquals(countryTest.toString(), countryLoad.toString());
		System.out.println(" ----- ");
	}

	@Test
	public void testDeleteCountry() {
		System.out.println(" -> Test delete : ");

		boolean deleted = service.delete(countryTest);
		Assert.assertTrue(deleted);
		System.out.println(" ----- ");
	}
}
