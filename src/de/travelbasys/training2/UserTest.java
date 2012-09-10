package de.travelbasys.training2;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testGetName() {
		User u = new User("Bob", 15);
		assertNotNull(u);
		assertEquals("Bob", u.getName());
	}

	@Test
	public void testGetAge() {
		User u = new User("Bob", 15);
		assertEquals(15, u.getAge());
	}

	@Test
	public void testGetAgeDefault() {
		User u = new User("Bob");
		assertEquals(15, u.getAge());
	}

	@Test
	public void testGetNameDefault() {
		User u = new User();
		assertEquals("Bill", u.getName());
	}

	@Test
	public void testSetName() {
		User u = new User();
		u.setName("Joe");
		assertEquals("Joe", u.getName());
	}

	@Test
	public void testSetAge() {
		User u = new User();
		u.setAge(100);
		assertEquals(100, u.getAge());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetAgeNegative() {
		User u = new User();
		u.setAge(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetAgeZero() {
		User u = new User();
		u.setAge(0);
	}
	
	@Test
	public void testEquals() {
		User bill1 = new User("Bill", 15);
		User bill2 = new User("Bill", 15);
		assertTrue(bill1.equals(bill2));
		// assertEquals(bill1, bill2);
	}
	
	@Test()
	public void testParse() {
	User.parse("User [name=Bill, age=234]");	
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParseEx() {
	User.parse("User [mame=Bill, age=234]");	
	}

}
