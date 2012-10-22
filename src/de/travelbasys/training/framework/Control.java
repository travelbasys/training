package de.travelbasys.training.framework;

public interface Control {

	void init(Model model, View view);

	void handleInput(Object value) throws Exception;

}
