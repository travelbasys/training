package de.travelbasys.trainingfx.dialog.customer.update;

import javafx.collections.ObservableList;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.Model;

public class CustomerUpdateModelGUI implements Model {

	private ObservableList<Customer> data;
	private int customerid;
	private String lastname = "";
	private String firstname = "";
	private int age = 0;
	private String adress = "";
	private String postalcode = "";
	private String email = "";

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

	public boolean sendIsInvalid() {
		return lastname.isEmpty() || firstname.isEmpty() || age == 0
				|| adress.isEmpty() || postalcode.isEmpty() || email.isEmpty();
	}

	public boolean sendIsValid() {
		return !sendIsInvalid();
	}

	public boolean hasNotChanged() {
		return (lastname.equals(data.get(0).getLastName())
				&& firstname.equals(data.get(0).getFirstName())
				&& age == data.get(0).getAge()
				&& adress.equals(data.get(0).getAdress())
				&& postalcode.equals(data.get(0).getPostalcode()) && email
					.equals(data.get(0).getEmail()));
	}

	public boolean hasChanged() {
		return !hasNotChanged();
	}
}
