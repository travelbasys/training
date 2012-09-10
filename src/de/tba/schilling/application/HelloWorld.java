package de.tba.schilling.application;

import de.tba.schilling.controllers.HelloWorldController;
import de.tba.schilling.framework.Controller;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Controller ctrl = new HelloWorldController();
		ctrl.init();
		ctrl.start();
	}

}
