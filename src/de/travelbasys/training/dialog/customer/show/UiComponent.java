package de.travelbasys.training.dialog.customer.show;

import de.travelbasys.training.util.AppContext;

public class UiComponent {

	private Control control;
	private Formatter formatter;
	private String name;
	private Object value;

	private Control getControl() {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}

	public Formatter getFormatter() {
		return formatter;
	}

	public void setFormatter(Formatter formatter) {
		this.formatter = formatter;
	}

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

		// Store a formatter depending on the type of the given value.
		formatter = AbstractFormatter.createFormatter(value.getClass());
	}

	public void run() {
		// Make prompt key from component name.
		String key = getName() + "Prompt";

		while (true) {
			// Show prompt message to the user.
			AppContext.printMessage(key);

			// Read user response.
			String line = AppContext.nextLine();

			try {
				// Convert user response to value of proper type.
				value = getFormatter().parse(line);

				// Let controller check the input value and update model.
				getControl().handleInput(value);

				// Exit loop
				break;
			} catch (Exception e) {
				AppContext
						.println(AppContext.getMessage(e.getMessage()) + line);
			}
		}
	}
}
