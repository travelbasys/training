package de.travelbasys.training.dialog.customer.show;

public interface Control {

	void init(Model model, View view);

	void handleInput(Object value) throws Exception;

}
