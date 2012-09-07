package de.travelbasys.training2;

import java.util.ResourceBundle;

/**
 * Diese Klasse existiert.
 * 
 * @author tba
 * 
 */

public class HelloWorldBusiness {

	String baseName = "resources.HelloWorld";
	ResourceBundle bundle = ResourceBundle.getBundle(baseName);


	public void init() {
		// TODO mache mich fertig!
	}

	/**
	 * Verwendet das eingestellte Sprachpaket und gibt einen String aus, der in
	 * den Properties festgelegt wurde.
	 * 
	 * @return der String der Funktion
	 */

	public String getMessage() {
		return bundle.getString("ThankYou");
	}

}
