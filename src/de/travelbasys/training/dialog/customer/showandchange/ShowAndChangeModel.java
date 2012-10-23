package de.travelbasys.training.dialog.customer.showandchange;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;

/**
 * Model Objekt für den customerShow Dialog.
 */
public class ShowAndChangeModel implements Model {

	/**
	 * 
	 */
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

	//Die Subtraktion von 1 ist notwendig, da die ArrayList der UIComponents von 0-5 (Zulässiger Eingabebereich 1-6) reicht.
	//Bei der Eingabe von 0 soll allerdings beendet werden, somit muss erst geprüft werden, ob tatsächlich eine 0 eingegeben wurde.
	//Wurde eine gültige Eingabe getätigt wird der Wert um 1 verringert um keine IndexOutOfBoundsException zu werfen.
	public void setIndex(int index) {
		this.index = index -1;
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