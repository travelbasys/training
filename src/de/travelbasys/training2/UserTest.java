package de.travelbasys.training2;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Eine Klasse um die vorhanden Applikationen auf ihre Funktionalität zu testen
 * @author tba
 *
 */
public class UserTest {

	@Test
	public void testGetName() {
		User u = new User(0, "Bob", null, 15, null, 0, null);
		assertNotNull(u);
		assertEquals("Bob", u.getName());
	}

	@Test
	public void testGetAge() {
		User u = new User(0, "Bob", null, 15, null, 0, null);
		assertEquals(15, u.getAge());
	}

	@Test
	public void testGetAgeDefault() {
		User u = new User(0, "Bob", null, 0, null, 0, null);
		assertEquals(15, u.getAge());
	}

	@Test
	public void testGetNameDefault() {
		User u = new User(0);
		assertEquals("Bill", u.getName());
	}

	@Test
	public void testSetName() {
		User u = new User(0);
		u.setName("Joe");
		assertEquals("Joe", u.getName());
	}

	@Test
	public void testSetAge() {
		User u = new User(0);
		u.setAge(100);
		assertEquals(100, u.getAge());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetAgeNegative() {
		User u = new User(0);
		u.setAge(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetAgeZero() {
		User u = new User(0);
		u.setAge(0);
	}

	@Test
	public void testEquals() {
		User bill1 = new User(0, "Bill", null, 15, null, 0, null);
		User bill2 = new User(0, "Bill", null, 15, null, 0, null);
		assertTrue(bill1.equals(bill2));
		// assertEquals(bill1, bill2);
	}

	@Test()
	public void testParse() {
		User.parse("User [name=Bill, age=23]");
		User.parse("User[name=Bill, age=23]");
		User.parse("User [name=Bill,age=24]");
		User.parse("User   [name=Bill,   age=47]");
		User.parse("User [  name = Bill, age = 24 ]");
		User.parse("User [name=Bill, age=66]");
		User.parse("   User [name=Bill, age=24]");
		User.parse("User [name=Bill, age=150]");
		User.parse("user [Name=Bill, age=140-]");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParseEx1() {
		User.parse("user [name=Bill, age=2147483647]");
		
	}
	
	@Test(expected = NumberFormatException.class)
	public void testParseEx2() {
		User.parse("User [Name=Bill, age=21474836948]");
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testParseEx3() {
		User.parse("User [name=Bill, Age=12134]");
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testParseEx4() {
		User.parse("Xser [name=Bill, age=23]");
	}

}
