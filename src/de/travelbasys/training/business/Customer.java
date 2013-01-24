/**
 * 
 */
package de.travelbasys.training.business;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Repräsentiert einen Kunden, der mit der Anwendung verwaltet wird.
 * 
 * @author tba
 */
public class Customer implements Serializable, Cloneable {

	private static final long serialVersionUID = 904199503921232796L;

	private String lastname;
	private String firstname;
	private String adress;
	private String email;
	private int customerid;
	private int age;
	private String postalcode;
	private Date birthdate;

	private static final String DEFAULT_LASTNAME = "default";
	private static final String DEFAULT_FIRSTNAME = "default";
	private static final String DEFAULT_ADRESS = "default";
	private static final String DEFAULT_EMAIL = "default";
	private static final int DEFAULT_AGE = 1;
	private static final String DEFAULT_POSTALCODE = "default";
	private static final SimpleDateFormat DEFAULT_BIRTHDATE_FORMAT = new SimpleDateFormat(
			"YYYY-MM-DD");
	private static final Date DEFAULT_BIRTHDATE = new Date(1970 - 01 - 01);

	/*
	 * Customer [name=xxx, age=nnn] oder: Customer[ name = xxx , age = nnn ]
	 * 
	 * Customer, dann Spaces, dann "[", dann Spaces, dann "name", dann Spaces,
	 * dann "=", dann Spaces, dann Gruppe aus mindestens einem Zeichen
	 * non-greedy, dann Spaces, dann Kommata, dann Spaces, dann age, dann
	 * Spaces, dann "=", dann Spaces, dann Gruppe aus mindestens einer Ziffer,
	 * dann Spaces, dann "]". Fertig.
	 */
	private static final String U = "\\s*Customer[(\\d+)]\\s*\\[\\s*lastname\\s*=\\s*(.+?)\\s*,\\s*firstname\\s*=\\s*(.+?)\\s*,\\s*birthdate\\s*=\\s*(.+?)\\s*\\,\\s*\\s*age\\s*=\\s*(\\d+)\\s*\\,\\s*adress\\s*=\\s*(.+?)\\s*\\,\\s*postalcode\\s*=\\s*(.+?)\\s*\\,\\s*email\\s*=\\s*(.+?)\\s*\\]";
	private static final String C = "(\\d+);(.+?);(.+?);(.+?);(\\d+);(.+?);(.+?);(.+?)";
	private static final Pattern CUSTOMERPATTERN = Pattern.compile(U,
			Pattern.CASE_INSENSITIVE);
	private static final Pattern CUSTOMERPATTERNCSV = Pattern.compile(C,
			Pattern.CASE_INSENSITIVE);

	private static final String WRONG_SYNTAX_ERROR = "Wrong syntax: ";
	private static final String INVALID_DATE_ERROR = "Invalid Date: ";
	private static final String POSTAL_CODE_ERROR = "Postal code not in range: ";
	private static final String AGE_ERROR = "Wrong age: ";

	/**
	 * Erzeugt ein neues Customer Objekt mit dem angegebenen Namen und dem
	 * angegebenen Alter.
	 * 
	 * @param customerid
	 * 
	 * @param name
	 *            Name des Customers.
	 * @param firstname
	 * @param age
	 *            Alter des Customers.
	 * @param email
	 * @param postalcode
	 * @param adress
	 * @throws Exception
	 */
	public Customer(int customerid, String lastname, String firstname,
			Date birthdate, int age, String adress, String postalcode,
			String email) throws IllegalArgumentException {
		this.customerid = customerid;
		setLastName(lastname);
		setFirstName(firstname);
		setAge(age);
		setAdress(adress);
		setPostalcode(postalcode);
		setEMail(email);
		setBirthdate(birthdate);
	}

	private void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public void setPostalcode(String postalcode)
			throws IllegalArgumentException {

		if ((Integer.parseInt(postalcode) > 0 && postalcode.length() == 5)) {
			this.postalcode = postalcode;
		} else {
			throw new IllegalArgumentException(POSTAL_CODE_ERROR);
		}

	}

	/**
	 * Erzeugt ein neues Customer Objekt mit dem angegebenen Namen und einem
	 * default Alter (derzeit 15).
	 * 
	 * @param name
	 *            Name des Customers.
	 * @throws IllegalArgumentException
	 */
	public Customer(int customerid) throws IllegalArgumentException {
		this(customerid, DEFAULT_LASTNAME, DEFAULT_FIRSTNAME,
				DEFAULT_BIRTHDATE, DEFAULT_AGE, DEFAULT_ADRESS,
				DEFAULT_POSTALCODE, DEFAULT_EMAIL);
	}

	/**
	 * Erzeugt ein neues Customer Objekt mit einem default Namen und dem default
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

	public void setEMail(String email) {
		this.email = email;
	}

	public int getId() {
		return customerid;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public String getAdress() {
		return adress;
	}

	public String getFirstName() {
		return firstname;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	/**
	 * Setzt das Alter des Kunden. Wenn der Wert negativ oder größer als 150
	 * ist, wird eine Exception geworfen.
	 * 
	 * @param age
	 *            das Alter.
	 * @throws IllegalArgumentException
	 *             wenn Alter negativ oder größer als 150.
	 */
	public void setAge(int age) throws IllegalArgumentException {
		if (age > 0 && age <= 150) {
			this.age = age;
		} else {
			throw new IllegalArgumentException(AGE_ERROR + age);
		}

	}

	@Override
	public String toString() {
		return "Customer[" + customerid + "] " + "[lastname=" + lastname
				+ ", firstname=" + firstname + ", age=" + age + ", adress="
				+ adress + ", postalcode=" + postalcode + ", email=" + email
				+ "]";
	}

	public String toFormat(String Format) {
		if (Format == "CSV") {
			return customerid + ";" + lastname + ";" + firstname + ";" + age
					+ ";" + adress + ";" + postalcode + ";" + email;

		}
		if (Format == "ACCESS") {
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + age;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result
				+ ((postalcode == null) ? 0 : postalcode.hashCode());
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
		Customer other = (Customer) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (birthdate == null) {
			if (other.birthdate != null) {
				return false;
			}
		} else if (!birthdate.equals(other.birthdate)) {
			return false;
		}
		if (age != other.age)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (postalcode == null) {
			if (other.postalcode != null)
				return false;
		} else if (!postalcode.equals(other.postalcode))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	/**
	 * Liest einen String ein und zerlegt ihn in Name und Alter-Gruppe.
	 * Anschließend werden die Daten in ein Customer-Objekt geschrieben. Bei
	 * falscher Syntax wird eine Exception ausgeworfen. Die Syntax ist als
	 * globale Variable festgelegt.
	 * 
	 * @param s
	 *            der Wert des eingelesenen Strings
	 * @return der Wert des Customer-Objekts
	 */

	public static Customer parse(String s) {
		Customer customer = null;

		Matcher m = CUSTOMERPATTERN.matcher(s);
		if (m.matches()) {
			try {
				customer = new Customer(Integer.parseInt(m.group(1)),
						m.group(2), m.group(3),
						DEFAULT_BIRTHDATE_FORMAT.parse(m.group(4)),
						Integer.parseInt(m.group(5)), m.group(6), m.group(7),
						m.group(8));
			} catch (ParseException e) {
				System.out.println(INVALID_DATE_ERROR);
			}
		} else {
			// Falsche Syntax: kein Customer.
			throw new IllegalArgumentException(Customer.WRONG_SYNTAX_ERROR + s);
		}

		return customer;
	}

	public static Customer parseCSV(String s) {
		Customer customer = null;
		Matcher m = CUSTOMERPATTERNCSV.matcher(s);
		if (m.matches()) {
			try {
				customer = new Customer(Integer.parseInt(m.group(1)),
						m.group(2), m.group(3),
						DEFAULT_BIRTHDATE_FORMAT.parse(m.group(4)),
						Integer.parseInt(m.group(5)), m.group(6), m.group(7),
						m.group(8));
			} catch (ParseException e) {
				System.out.println(INVALID_DATE_ERROR);
			}
		} else {
			// Falsche Syntax: kein Customer.
			throw new IllegalArgumentException(Customer.WRONG_SYNTAX_ERROR + s);
		}

		return customer;
	}

	public Customer clone() {
		return new Customer(customerid, lastname, firstname, birthdate, age,
				adress, postalcode, email);
	}

	public Date getBirthdate() {
		return birthdate;
	}
}
