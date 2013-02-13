/**
 * 
 */
package de.travelbasys.training.business;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.travelbasys.training.util.Datum;

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
	private String postalcode;
	private Date birthdate;

	private static final String DEFAULT_LASTNAME = "default";
	private static final String DEFAULT_FIRSTNAME = "default";
	private static final String DEFAULT_ADRESS = "default";
	private static final String DEFAULT_EMAIL = "default";
	private static final String DEFAULT_POSTALCODE = "default";
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
	private static final String U = "\\s*Customer[(\\d+)]\\s*\\[\\s*lastname\\s*=\\s*(.+?)\\s*,\\s*firstname\\s*=\\s*(.+?)\\s*,\\s*birthdate\\s*=\\s*(.+?)\\s*\\,\\s*adress\\s*=\\s*(.+?)\\s*\\,\\s*postalcode\\s*=\\s*(.+?)\\s*\\,\\s*email\\s*=\\s*(.+?)\\s*\\]";
	private static final String C = "(\\d+);(.+?);(.+?);(.+?);(.+?);(.+?);(.+?)";
	private static final Pattern CUSTOMERPATTERN = Pattern.compile(U,
			Pattern.CASE_INSENSITIVE);
	private static final Pattern CUSTOMERPATTERNCSV = Pattern.compile(C,
			Pattern.CASE_INSENSITIVE);

	private static final String WRONG_SYNTAX_ERROR = "Wrong syntax: ";
	private static final String POSTAL_CODE_ERROR = "Postal code not in range: ";

	/**
	 * Erzeugt ein neues Customer Objekt mit dem angegebenen Namen und dem
	 * angegebenen Alter.
	 * 
	 * @param customerid
	 * 
	 * @param name
	 *            Name des Customers.
	 * @param firstname
	 * @param email
	 * @param postalcode
	 * @param adress
	 * @throws Exception
	 */
	public Customer(int customerid, String lastname, String firstname,
			Date birthdate, String adress, String postalcode, String email)
			throws IllegalArgumentException {
		this.customerid = customerid;
		setLastName(lastname);
		setFirstName(firstname);
		setBirthdate(birthdate);
		setAdress(adress);
		setPostalcode(postalcode);
		setEMail(email);
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public void setPostalcode(String postalcode)
			throws IllegalArgumentException {

		if ((Integer.parseInt(postalcode) > 0 && postalcode.length() == 5)) {
			this.postalcode = postalcode;
		} else {
			throw new IllegalArgumentException(POSTAL_CODE_ERROR + postalcode);
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
				DEFAULT_BIRTHDATE, DEFAULT_ADRESS, DEFAULT_POSTALCODE,
				DEFAULT_EMAIL);
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

	@Override
	public String toString() {
		return "Customer[" + customerid + "] " + "[lastname=" + lastname
				+ ", firstname=" + firstname + ", birthdate=" + birthdate
				+ ", adress=" + adress + ", postalcode=" + postalcode
				+ ", email=" + email + "]";
	}

	public String toCSV() {
		return customerid + ";" + lastname + ";" + firstname + ";" + birthdate
				+ ";" + adress + ";" + postalcode + ";" + email;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result
				+ ((postalcode == null) ? 0 : postalcode.hashCode());
		result = prime * result
				+ ((birthdate == null) ? 0 : birthdate.hashCode());
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
			customer = new Customer(Integer.parseInt(m.group(1)), m.group(2),
					m.group(3), Datum.getFormattedDate(m.group(4)), m.group(5),
					m.group(6), m.group(7));
		} else {
			// Falsche Syntax: kein Customer.
			throw new IllegalArgumentException(Customer.WRONG_SYNTAX_ERROR + s);
		}

		return customer;
	}

	public static Customer parseCSV(String s) {
		// TODO: Matcher matcht nicht richtig. Das Pattern muss ein Dateobjekt
		// erfassen können?! Oder String später zu Date parsen??

		Customer customer = null;
		Matcher m = CUSTOMERPATTERNCSV.matcher(s);
		if (m.matches()) {
			customer = new Customer(Integer.parseInt(m.group(1)), m.group(2),
					m.group(3), Datum.getFormattedDate(m.group(4)), m.group(5),
					m.group(6), m.group(7));
		} else {
			// Falsche Syntax: kein Customer.
			throw new IllegalArgumentException(Customer.WRONG_SYNTAX_ERROR + s);
		}

		return customer;
	}

	public Customer clone() {
		return new Customer(customerid, lastname, firstname, birthdate, adress,
				postalcode, email);
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public static Customer parseMDB(String s) {
		// TODO Auto-generated method stub
		return null;
	}
}
