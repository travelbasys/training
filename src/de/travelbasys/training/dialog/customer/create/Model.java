package de.travelbasys.training.dialog.customer.create;

import java.util.Map;

public interface Model extends Map<String,String> {

	public abstract String getPrompt(String fieldName);

}