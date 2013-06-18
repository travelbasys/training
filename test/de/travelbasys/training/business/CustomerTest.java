package de.travelbasys.training.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Eine Klasse um die vorhanden Applikationen auf ihre Funktionalitšt zu testen
 * 
 * 
 * @author tba
 * 
 */
public class CustomerTest {

	@Test
	public void testGetName() {
		Customer u = new Customer(0, "Bob", null, null, null, null, null);
		assertNotNull(u);
		assertEquals("Bob", u.getLastName());
	}

	@Test
	public void testGetAge() {
		Customer u = new Customer(0, "Bob", null, null, null, null, null);
		assertEquals(15, u.getBirthdate());
	}

	@Test
	public void testGetAgeDefault() {
		Customer u = new Customer(0, "Bob", null, null, null, null, null);
		assertEquals(15, u.getBirthdate());
	}

	@Test
	public void testGetNameDefault() {
		Customer u = new Customer(0);
		assertEquals("Bill", u.getLastName());
	}

	@Test
	public void testSetFirstName() {
		Customer u = new Customer(0);
		u.setFirstName("Joe");
		assertEquals("Joe", u.getLastName());
	}

	@Test
	public void testEquals() {
		Customer bill1 = new Customer(0, "Bill", null, null, null, null, null);
		Customer bill2 = new Customer(0, "Bill", null, null, null, null, null);
		assertTrue(bill1.equals(bill2));
		// assertEquals(bill1, bill2);
	}

	@Test()
	public void testParse() {
		Customer.parse("User [name=Bill, age=23]");
		Customer.parse("User[name=Bill, age=23]");
		Customer.parse("User [name=Bill,age=24]");
		Customer.parse("User   [name=Bill,   age=47]");
		Customer.parse("User [  name = Bill, age = 24 ]");
		Customer.parse("User [name=Bill, age=66]");
		Customer.parse("   User [name=Bill, age=24]");
		Customer.parse("User [name=Bill, age=150]");
		Customer.parse("user [Name=Bill, age=140-]");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParseEx1() {
		Customer.parse("user [name=Bill, age=2147483647]");

	}

	@Test(expected = NumberFormatException.class)
	public void testParseEx2() {
		Customer.parse("User [Name=Bill, age=21474836948]");

	}

	@Test(expected = IllegalArgumentException.class)
	public void testParseEx3() {
		Customer.parse("User [name=Bill, Age=12134]");

	}

	@Test(expected = IllegalArgumentException.class)
	public void testParseEx4() {
		Customer.parse("Xser [name=Bill, age=23]");
	}

}
