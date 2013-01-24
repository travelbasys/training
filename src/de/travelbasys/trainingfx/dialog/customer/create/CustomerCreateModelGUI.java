package de.travelbasys.trainingfx.dialog.customer.create;

import java.util.Date;

import de.travelbasys.training.framework.Model;

//Soll nur gültige/validierte Daten enthalten.

public class CustomerCreateModelGUI implements Model {

	private String lastname = "";
	private String firstname = "";
	private int age = 0;
	private String adress = "";
	private String postalcode = "";
	private String email = "";
	private Date birthdate = new Date();

	public CustomerCreateModelGUI() {
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setBirthdate(Date birthdate){
		this.birthdate = birthdate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
	public boolean isInvalid() {
		return lastname.isEmpty() || firstname.isEmpty() || age == 0
				|| adress.isEmpty() || postalcode.isEmpty() || email.isEmpty();
	}

	public boolean isValid() {
		return !isInvalid();
	}

	public Date getBirthdate() {
		return birthdate;
	}
}
