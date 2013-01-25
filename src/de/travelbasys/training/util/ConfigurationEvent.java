package de.travelbasys.training.util;

import java.util.EventObject;
import java.util.ResourceBundle;

public class ConfigurationEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	public static final ConfigurationEvent LOCALE = new ConfigurationEvent(
			"locale");
	public static final ConfigurationEvent STYLESHEET = new ConfigurationEvent(
			"stylesheet");

	private String type;

	public ConfigurationEvent(String type) {
		super(type);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public ResourceBundle getResources() {
		return Config.BUNDLE;
	}

}
