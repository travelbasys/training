package de.travelbasys.training.framework;

import de.travelbasys.training.util.AppContext;

public class UiComponent extends AbstractUiComponent {

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
