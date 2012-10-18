package de.travelbasys.training.dialog.customer.Update;

import java.util.List;

import de.travelbasys.training.business.Customer;

/**
 * erzeugt eine Instanz der Klasse CustomerUpdateDialog und verwaltet Strings
 * für Ausgaben
 */

public class CustomerUpdateModel {
	private String lastname;
	private int customerid;
	private String firstname;
	private String adress;
	private String postalcode;
	private String email;
	private int age;
	private String customeridtemp;
	private List<Customer> user;
	private String choice_str;
	private int choice_int;
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCustomeridtemp() {
		return customeridtemp;
	}

	public void setCustomeridtemp(String customeridtemp) {
		this.customeridtemp = customeridtemp;
	}

	public List<Customer> getUser() {
		return user;
	}

	public void setUser(List<Customer> user) {
		this.user = user;
	}

	public String getChoice_str() {
		return choice_str;
	}

	public void setChoice_str(String choice_str) {
		this.choice_str = choice_str;
	}

	public int getChoice_int() {
		return choice_int;
	}

	public void setChoice_int(int choice_int) {
		this.choice_int = choice_int;
	}

}