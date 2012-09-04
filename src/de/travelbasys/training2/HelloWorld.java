package de.travelbasys.training2;

public class HelloWorld {
	
	public static void main( String[] args ){
		
		HelloWorldBusiness b = new HelloWorldBusiness();
		b.init();
		
		HelloWorldUI ui1 = new HelloWorldUI();
		ui1.init( b );
		ui1.run();
			/*	
		HelloWorldUI ui2 = new HelloWorldUI();
		ui2.init( b );
		ui2.run();
		
		HelloWorldUI ui3 = new HelloWorldUI();
		ui3.init( b );
		ui3.run();
	
		System.err.println( b.version );
		b.version = "XXX";
		System.err.println( b.version );
		
		System.err.println( HelloWorldUI.getCounter() );
		try {
			HelloWorldUI.setCounter( 99 );
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.err.println( HelloWorldUI.getCounter() );
		try {
			HelloWorldUI.setCounter( 100 );
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.err.println( HelloWorldUI.getCounter() );
	*/
	}
	
}
