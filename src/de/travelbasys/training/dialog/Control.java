package de.travelbasys.training.dialog;

public interface Control {

	public abstract void check(String fieldName, String value) throws Exception;
}