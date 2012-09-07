package de.travelbasys.training2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloWorldMain {
	
	private static final String DEFAULT_LANGUAGE = "en";
	private static final String LANG_KEY = "lang";
	private static final String CONFIG_FILENAME = "HelloWorld.ini";
	private static final String ERR_FILENOTFOUND = "HelloWorld.ini existiert nicht.";
	private static final int EXIT_ERR_STATUS = 1;
	
	private static String baseName = "resources.HelloWorld";
	private static ResourceBundle bundle = ResourceBundle.getBundle(baseName);
	
	
	public static void main(String[] args) {
		Properties config = new Properties();

		try {
			config.load(new FileInputStream(CONFIG_FILENAME));
		} catch (FileNotFoundException e1) {
			// TODO Dokumentation Exit-Status.
			System.err.println(ERR_FILENOTFOUND);
			System.exit(EXIT_ERR_STATUS);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String lang = config.getProperty(LANG_KEY, DEFAULT_LANGUAGE);

		// Change language to en.
		try {
			Locale.setDefault(new Locale(args[0]));
		} catch (Exception e) {
			Locale.setDefault(new Locale(lang));
		}
		HelloWorldBusiness b = new HelloWorldBusiness();
		b.init();
		HelloWorldUI ui = new HelloWorldUI();
		ui.init(b);
		UserList ul = new UserList();
		ul.init();
		
		PrintStream out = System.out;
		PrintStream err = System.err;
		
		out.println(bundle.getString("Choose"));
		out.println("1: " + bundle.getString("App1"));
		out.println("2: " + bundle.getString("App2"));
		
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		
		if(choice==1){
			ui.run();
		}
		else if(choice==2){
			UserList.list(args);
		}
		else{
			err.println(bundle.getString("ChooseErr"));		
		}

		
		//UserList.list(args);
		//ui.run();
		//Rest
		
	}

}
