package de.travelbasys.training.dialog.customer.showandchange;

import de.travelbasys.training.framework.Model;

/**
 * hat die Aufgabe, ein Model für den ShowAndChange Dialog zu verwalten. Die
 * aktuelle Implementierung enthält alle Attribute eines Customer Objektes.
 */
public class ShowAndChangeModel implements Model {

	private int customerid;
	private String customerLastname;
	private String customerFirstname;
	private int customerAge;
	private String customerAdress;
	private String customerPostalcode;
	private String customerEMail;

	private int index;

	public String getLastName() {
		return customerLastname;
	}

	public void setLastName(String customerLastname) {
		this.customerLastname = customerLastname;
	}

	public String getFirstName() {
		return customerFirstname;
	}

	public void setFirstName(String customerFirstname) {
		this.customerFirstname = customerFirstname;
	}

	public int getAge() {
		return customerAge;
	}

	public void setAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public String getAdress() {
		return customerAdress;
	}

	public void setAdress(String customerAdress) {
		this.customerAdress = customerAdress;
	}

	public String getPostalcode() {
		return customerPostalcode;
	}

	public void setPostalcode(String customerPostalcode) {
		this.customerPostalcode = customerPostalcode;
	}

	public String getEMail() {
		return customerEMail;
	}

	public void setEMail(String customerEMail) {
		this.customerEMail = customerEMail;
	}

	public int getIndex() {
		return index;
	}

	public void setComponentIndex(int index) {
		this.index = index;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setId(int customerid) {
		this.customerid = customerid;
	}

}