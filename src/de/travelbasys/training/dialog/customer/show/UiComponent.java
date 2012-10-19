package de.travelbasys.training.dialog.customer.show;

import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

public class UiComponent {

	private String name;
	private Object value;
	private EventHandler eventHandler;
	private Controller controller;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public void run() {
		String key = getName() + "Prompt";
		AppContext.printMessage(key);

		value = Console.nextLine();
		
		getEventHandler().updateModel(value);
		getController().handleInput(value);
	}

	private Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	private EventHandler getEventHandler() {
		return eventHandler;
	}

	public void setEventHandler(EventHandler eventHandler) {
		this.eventHandler = eventHandler;
	}

}
