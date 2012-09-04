package de.travelbasys.training2;

import java.util.Date;

public class HelloWorldBusiness {

	public String version = "2.0";

	public void init() {
		//TODO mache mich fertig!	
	}

	public String getMessage() {
		String s = ("Today is " + new Date()) + "\n" + "*** Message Function works***";
		 return s;
		//return "";
	}

}
