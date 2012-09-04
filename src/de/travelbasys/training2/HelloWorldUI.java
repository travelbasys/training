package de.travelbasys.training2;

import java.io.PrintStream;

public class HelloWorldUI {
	
	private static int counter = 0;

	private String message;

	public void run() {
		PrintStream out = System.out;
		out.println(message);
	}

	public void init(HelloWorldBusiness b) {
		message = b.getMessage();
		counter++ ;
	}
	
	public static int getCounter(){
		return HelloWorldUI.counter;
	}

	public static void setCounter( int i) throws Exception{
		if( i % 2 == 0 ){
			counter = i;
		}
		else {
			throw new Exception( "*** Nur gerade Werte erlaubt *** ");
		}
	}

}
