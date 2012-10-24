package de.travelbasys.training.dialog.customer.showandchange;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;

/**
 * hat die Aufgabe, ein Model für den ShowAndChange Dialog zu verwalten.
 * Die aktuelle Implementierung enthält alle Attribute eines Customer Objektes.
 */
public class ShowAndChangeModel implements Model {

	
	private Customer customer;
	private String customerLastname = "";
	private String customerFirstname = "";
	private int customerAge = 0;
	private String customerAdress = "";
	private String customerPostalcode = "";
	private String customerEMail = "";
	private int index;
	private int customerid;
	private boolean EndFlag = false;

	public String getCustomerLastname() {
		return customerLastname;
	}

	public void setCustomerLastname(String customerLastname) {
		this.customerLastname = customerLastname;
	}

	public String getCustomerFirstname() {
		return customerFirstname;
	}

	public void setCustomerFirstname(String customerFirstname) {
		this.customerFirstname = customerFirstname;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public String getCustomerAdress() {
		return customerAdress;
	}

	public void setCustomerAdress(String customerAdress) {
		this.customerAdress = customerAdress;
	}

	public String getCustomerPostalcode() {
		return customerPostalcode;
	}

	public void setCustomerPostalcode(String customerPostalcode) {
		this.customerPostalcode = customerPostalcode;
	}

	public String getCustomerEMail() {
		return customerEMail;
	}

	public void setCustomerEMail(String customerEMail) {
		this.customerEMail = customerEMail;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer() {
		customer = new Customer(getCustomerid(), getCustomerLastname(),
				getCustomerFirstname(), getCustomerAge(), getCustomerAdress(),
				getCustomerPostalcode(), getCustomerEMail());
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public boolean getEndFlag() {
		return EndFlag;
	}

	public void setEndFlag(boolean endFlag) {
		EndFlag = endFlag;
	}

}