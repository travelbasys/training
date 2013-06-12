package de.travelbasys.training.dialog.customer.create;

import java.util.Date;

import de.travelbasys.training.framework.Model;

/**
 * hat die Aufgabe, ein Model für den CustomerCreate Dialog zu verwalten.
 * 
 * Die aktuelle Implementierung enthält alle Daten um ein Customer Objekt zu
 * erstellen.
 */
public class CustomerCreateModel implements Model {

	private String Lastname;
	private String Firstname;
	private Date Birthdate;
	private String Adress;
	private String Postalcode;
	private String EMail;

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String Lastname) {
		this.Lastname = Lastname;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String Firstname) {
		this.Firstname = Firstname;
	}

	public Date getBirthdate() {
		return Birthdate;
	}

	public void setBirthdate(Date Birthdate) {
		this.Birthdate = Birthdate;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String Adress) {
		this.Adress = Adress;
	}

	public String getPostalcode() {
		return Postalcode;
	}

	public void setPostalcode(String Postalcode) {
		this.Postalcode = Postalcode;
	}

	public String getEMail() {
		return EMail;
	}

	public void setEMail(String EMail) {
		this.EMail = EMail;
	}
}