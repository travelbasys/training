 package de.travelbasys.training.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Die Klasse CommandLine bezieht die Argumente aus der Run Configuration und schreibt
 * Schlüssel als auch den Wert (Optionen) in ein HashMap Object.
 * 
 * 
 * @author tba
 *
 */

public class CommandLine {
	
	private static Map<String, String> OPTIONS = new HashMap<String, String>();
	
	// Splittet die Argumente anhand des Gleichheitszeichens und legt sie in dem Optionsobjekt ab.
	public static void parse(String[] args) {
		
		for (int i = 0; i < args.length; i++) {
			String s = args[i];
			
			String[] temp = s.split("=");
			
			String key = temp[0].substring(1);
			String value = temp[1];
			
			OPTIONS.put(key,value);
		}
	}
	// Get-Methode für die Options
	public static Map<String, String> getOptions(){
		return OPTIONS;
	}
}
