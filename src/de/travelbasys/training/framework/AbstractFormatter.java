package de.travelbasys.training.framework;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFormatter {
	@SuppressWarnings("rawtypes")
	private static Map<Class, Formatter> FORMATTERS;

	@SuppressWarnings("rawtypes")
	private static void createFormatters() {
		FORMATTERS = new HashMap<Class, Formatter>();
		FORMATTERS.put(Integer.class, new IntegerFormatter());
		FORMATTERS.put(String.class, Formatter.NULL);
	}

	public static Formatter createFormatter(Class<? extends Object> class1) {
		if (null == FORMATTERS)
			createFormatters();

		return FORMATTERS.get(class1);
	}
}
