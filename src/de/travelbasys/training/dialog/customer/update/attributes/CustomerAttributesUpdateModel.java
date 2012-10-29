package de.travelbasys.training.dialog.customer.update.attributes;

import de.travelbasys.training.framework.Model;

/**
 * hat die Aufgabe, ein Model für den ShowAndChange Dialog zu verwalten. Die
 * aktuelle Implementierung enthält alle Attribute eines Customer Objektes.
 */
public class CustomerAttributesUpdateModel implements Model {

	private String lastName;
	private String firstName;
	private int age;
	private String adress;
	private String postalcode;
	private String eMail;
	private boolean dirtyflag = false;

	private int componentIndex;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getEMail() {
		return eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public int getComponentIndex() {
		return componentIndex;
	}

	public void setComponentIndex(int componentIndex) {
		this.componentIndex = componentIndex;
	}

	public void setDirtyFlag() {
		dirtyflag = true;
	}

	public boolean getDirtyFlag() {
		return dirtyflag;
	}

}