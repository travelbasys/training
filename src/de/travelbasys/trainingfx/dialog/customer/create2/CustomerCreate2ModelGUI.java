package de.travelbasys.trainingfx.dialog.customer.create2;

import javafx.collections.ObservableList;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;

/**
 * Das Model des Create Dialogs welches Daten f�r die verarbeitung innerhalb des
 * Create Dialogs enth�lt.
 * 
 */
public class CustomerCreate2ModelGUI implements Model {

	private ObservableList<Customer> data;
	private int customerid;
	private String lastname = "";
	private String firstname = "";
	private int age = 0;
	private String adress = "";
	private String postalcode = "";
	private String email = "";
	private String birthdate = "";

	public void setData(ObservableList<Customer> data) {
		this.data = data;
	}

	public ObservableList<Customer> getData() {
		return data;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
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

	public int getAge() {
		return age;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
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

	public boolean searchIsInvalid() {
		return customerid == 0;
	}

	public boolean searchIsValid() {
		return !searchIsInvalid();
	}

	/**
	 * Eine Methode die f�r die pr�fung ob ein Attribut des Customers leer oder
	 * 0 ist ben�tigt wird.
	 * 
	 * @return ob die Pr�fung wahr oder falsch ist.
	 */
	public boolean sendIsInvalid() {
		return lastname.isEmpty() || firstname.isEmpty() || birthdate.isEmpty()
				|| age == 0 || adress.isEmpty() || postalcode.isEmpty()
				|| email.isEmpty();
	}

	public boolean sendIsValid() {
		return !sendIsInvalid();
	}

}
