/**
 * 
 */
package de.travelbasys.training2;

import java.io.Serializable;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Die User Klasse repräsentiert einen Benutzer der Anwendung.
 * 
 * @author tba
 */
public class User implements Serializable {

	private static final long serialVersionUID = 904199503921232796L;

	private String lastname;
	private String firstname;
	private String adress;
	private String email;
	private int userid;
	private int age;
	private String postalcode;

	private static final String DEFAULT_LASTNAME = "default";
	private static final String DEFAULT_FIRSTNAME = "default";
	private static final String DEFAULT_ADRESS = "default";
	private static final String DEFAULT_EMAIL = "default";
	private static final int DEFAULT_AGE = 1;
	private static final String DEFAULT_POSTALCODE = "default";

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
	 */// user = new User(userid, lastname, firstname, age, adress, postalcode,
		// email);
	private static final String U = "\\s*User[(\\d+)]\\s*\\[\\s*lastname\\s*=\\s*(.+?)\\s*,\\s*firstname\\s*=\\s*(.+?)\\s*,\\s*age\\s*=\\s*(\\d+)\\s*\\,\\s*adress\\s*=\\s*(.+?)\\s*\\,\\s*postalcode\\s*=\\s*(.+?)\\s*\\,\\s*email\\s*=\\s*(.+?)\\s*\\]";
	private static final String C = "(\\d+);(.+?);(.+?);(\\d+);(.+?);(.+?);(.+?)";
	private static final Pattern USERPATTERN = Pattern.compile(U,
			Pattern.CASE_INSENSITIVE);
	private static final Pattern USERPATTERNCSV = Pattern.compile(C,
			Pattern.CASE_INSENSITIVE);

	/**
	 * Erzeugt ein neues User Objekt mit dem angegebenen Namen und dem
	 * angegebenen Alter.
	 * 
	 * @param userid
	 * 
	 * @param name
	 *            Name des Users.
	 * @param firstname
	 * @param age
	 *            Alter des Users.
	 * @param email
	 * @param postalcode
	 * @param adress
	 * @throws Exception
	 */
	public User(int userid, String lastname, String firstname, int age,
			String adress, String postalcode, String email)
			throws IllegalArgumentException {
		this.userid = userid;
		this.lastname = lastname;
		this.firstname = firstname;
		setAge(age);
		this.adress = adress;
		setPostalcode(postalcode);
		this.email = email;
	}

	private void setPostalcode(String postalcode) {
		
		if ((Integer.parseInt(postalcode) > 0 && postalcode.length() == 5 )) {
			this.postalcode = postalcode;
		} else {
			Output.err.println(bundle.getString("PostalNotInRangeErr") + age);
		}

	}

	/**
	 * Erzeugt ein neues User Objekt mit dem angegebenen Namen und einem default
	 * Alter (derzeit 15).
	 * 
	 * @param name
	 *            Name des Users.
	 * @throws IllegalArgumentException
	 */
	public User(int userid) throws IllegalArgumentException {
		this(userid, DEFAULT_LASTNAME, DEFAULT_FIRSTNAME, DEFAULT_AGE,
				DEFAULT_ADRESS, DEFAULT_POSTALCODE, DEFAULT_EMAIL);
	}

	/**
	 * Erzeugt ein neues User Objekt mit einem default Namen und dem default
	 * Alter.
	 * 
	 * @throws IllegalArgumentException
	 */

	/**
	 * 
	 * @return
	 */
	public String getLastName() {
		return lastname;
	}

	/**
	 * 
	 * @param name
	 */
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public int getUserID() {
		return userid;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public String getAdress() {
		return adress;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getEmail() {
		return email;
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
			Output.err.println(bundle.getString("NumberNotInRangeErr") + age);
		}

	}

	@Override
	public String toString() {
		return "User[" + userid + "] " + "[lastname=" + lastname
				+ ", firstname=" + firstname + ", age=" + age + ", adress="
				+ adress + ", postalcode=" + postalcode + ", email=" + email
				+ "]";
	}

	public String toCSV() {
		return lastname + ";" + age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
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
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	/**
	 * Liest einen String ein und zerlegt ihn in Name und Alter-Gruppe.
	 * Anschließend werden die Daten in ein User-Objekt geschrieben. Bei
	 * falscher Syntax wird eine Exception ausgeworfen. Die Syntax ist als
	 * globale Variable festgelegt.
	 * 
	 * @param s
	 *            der Wert des eingelesenen Strings
	 * @return der Wert des User-Objekts
	 */

	public static User parse(String s) {
		User user = null;

		Matcher m = USERPATTERN.matcher(s);
		if (m.matches()) {
			user = new User(Integer.parseInt(m.group(1)), m.group(2),
					m.group(3), Integer.parseInt(m.group(4)), m.group(5),
					m.group(6), m.group(7));
		} else {
			// Falsche Syntax: kein User.
			throw new IllegalArgumentException(bundle.getString("WrongUsrSyn")
					+ s);
		}

		return user;
	}

	public static User parseCSV(String s) {
		User user = null;
		Matcher m = USERPATTERNCSV.matcher(s);
		if (m.matches()) {
			user = new User(Integer.parseInt(m.group(1)), m.group(2),
					m.group(3), Integer.parseInt(m.group(4)), m.group(5),
					m.group(6), m.group(7));
		} else {
			// Falsche Syntax: kein User.
			throw new IllegalArgumentException(bundle.getString("WrongUsrSyn")
					+ s);
		}

		return user;
	}
}
