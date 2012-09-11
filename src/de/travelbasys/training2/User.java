/**
 * 
 */
package de.travelbasys.training2;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Die User Klasse repräsentiert einen Benutzer der Anwendung.
 * 
 * @author tba
 */
public class User {

	private String name;
	private int age;

	private static final String DEFAULT_NAME = "Bill";
	private static final int DEFAULT_AGE = 15;
	private static String baseName = "resources.HelloWorld";
	private static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	/*
	 * User [name=xxx, age=nnn] oder: User[ name = xxx , age = nnn ]
	 * 
	 * User, dann Spaces, dann "[", dann Spaces, dann "name", dann Spaces, dann
	 * "=", dann Spaces, dann Gruppe aus mindestens einem Zeichen non-greedy,
	 * dann Spaces, dann Kommata, dann Spaces, dann age, dann Spaces, dann "=",
	 * dann Spaces, dann Gruppe aus mindestens einer Ziffer, dann Spaces, dann
	 * "]". Fertig.
	 */
	private static final String U = "\\s*User\\s*\\[\\s*name\\s*=\\s*(.+?)\\s*,\\s*age\\s*=\\s*(\\d+)\\s*\\]";
	private static final Pattern USERPATTERN = Pattern.compile(U, Pattern.CASE_INSENSITIVE);

	/**
	 * Erzeugt ein neues User Objekt mit dem angegebenen Namen und dem
	 * angegebenen Alter.
	 * 
	 * @param name
	 *            Name des Users.
	 * @param age
	 *            Alter des Users.
	 * @throws Exception
	 */
	public User(String name, int age) throws IllegalArgumentException {
		this.name = name;
		setAge(age);
	}

	/**
	 * Erzeugt ein neues User Objekt mit dem angegebenen Namen und einem default
	 * Alter (derzeit 15).
	 * 
	 * @param name
	 *            Name des Users.
	 * @throws IllegalArgumentException
	 */
	public User(String name) throws IllegalArgumentException {
		this(name, DEFAULT_AGE);
	}

	/**
	 * Erzeugt ein neues User Objekt mit einem default Namen (derzeit "Bill")
	 * und dem default Alter.
	 * 
	 * @throws IllegalArgumentException
	 */
	public User() throws IllegalArgumentException {
		this(DEFAULT_NAME);
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 
	 * @param age
	 * @throws IllegalArgumentException
	 */
	public void setAge(int age) throws IllegalArgumentException {
			if (age > 0 && age <= 150) {
				this.age = age;
			} else {
				throw new IllegalArgumentException("Alter ungültig (1-150 erlaubt): " + age);
			}
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
public String toCSV() {
		return name + ";" + age;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	/**
	 * Liest einen String ein und zerlegt ihn in Name und Alter-Gruppe.
	 * Anschließend werden die Daten in ein User-Objekt geschrieben.
	 * Bei falscher Syntax wird eine Exception ausgeworfen.
	 * Die Syntax ist als globale Variable festgelegt.
	 * @param s der Wert des eingelesenen Strings
	 * @return der Wert des User-Objekts
	 */

	
	public static User parse(String s) {
		User user = null;

		Matcher m = USERPATTERN.matcher(s);
		if (m.matches()) {
			user = new User(m.group(1), Integer.parseInt(m.group(2)));
		} else {
			// Falsche Syntax: kein User.
			throw new IllegalArgumentException(bundle.getString("WrongUsrSyn")
					+ s);
		}

		return user;
	}
}
