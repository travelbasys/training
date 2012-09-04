package de.travelbasys.training2;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class HelloWorldBusiness {

	public String version = "2.0";

	public void init() {
		// TODO mache mich fertig!
	}

	public String getMessage() {
		
		ResourceBundle bundle = null;
		String baseName = "resources.HelloWorld";
		try {
			bundle = ResourceBundle.getBundle(baseName);
		} catch (MissingResourceException e) {
			System.err.println(e);
		}
		return bundle.getString("ThankYou");
	}

}
