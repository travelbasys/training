package experiment.javafx.travelbasys.dialog.customer.create;

import de.travelbasys.training.framework.Model;

//Soll nur g�ltige/validierte Daten enthalten.

public class CustomerCreateModelGUI implements Model {

	private int customerid;
	private String lastname;
	private String firstname;
	private int age;
	private String adress;
	private String postalcode;
	private String email;

	public CustomerCreateModelGUI() {
	}

	public int getCustomerID() {
		return customerid;
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

}
