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
	private boolean LastnameFlag = false;
	private boolean FirstnameFlag = false;
	private boolean AgeFlag = false;
	private boolean AdressFlag = false;
	private boolean PostalcodeFlag = false;
	private boolean EMailFlag = false;

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

	public boolean getEndFlag() {
		return EndFlag;
	}

	public void setEndFlag(boolean endFlag) {
		EndFlag = endFlag;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer() {
		customer = new Customer(getCustomerid(), getCustomerLastname(),
				getCustomerFirstname(), getCustomerAge(), getCustomerAdress(),
				getCustomerPostalcode(), getCustomerEMail());
	}

	public boolean getLastnameFlag() {
		return LastnameFlag;
	}

	public void setLastnameFlag(boolean lastnameFlag) {
		LastnameFlag = lastnameFlag;
	}

	public boolean getFirstnameFlag() {
		return FirstnameFlag;
	}

	public void setFirstnameFlag(boolean firstnameFlag) {
		FirstnameFlag = firstnameFlag;
	}

	public boolean getAdressFlag() {
		return AdressFlag;
	}

	public void setAdressFlag(boolean adressFlag) {
		AdressFlag = adressFlag;
	}

	public boolean getAgeFlag() {
		return AgeFlag;
	}

	public void setAgeFlag(boolean ageFlag) {
		AgeFlag = ageFlag;
	}

	public boolean getPostalcodeFlag() {
		return PostalcodeFlag;
	}

	public void setPostalcodeFlag(boolean postalcodeFlag) {
		PostalcodeFlag = postalcodeFlag;
	}

	public boolean getEMailFlag() {
		return EMailFlag;
	}

	public void setEMailFlag(boolean eMailFlag) {
		EMailFlag = eMailFlag;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

}