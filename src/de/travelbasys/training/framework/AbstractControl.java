package de.travelbasys.training.framework;

public abstract class AbstractControl implements Control {

	@Override
	public void init(Model model, View view) {
	}

	/**
	 * hat die Aufgabe, den Input einer UiComponent zu prüfen.
	 */
	@Override
	public void handleInput(Object value) throws Exception {
	}

}
