package de.tba.schilling.framework;

import java.util.HashMap;
import java.util.Map;

public class Settings {

	private static Map< String, Object >	settings	= new HashMap< String, Object >();

	public static Object get( String key ) {
		return settings.get( key );
	}

	public static void set( String key, Object value ) {
		settings.put( key, value );
	}
}
