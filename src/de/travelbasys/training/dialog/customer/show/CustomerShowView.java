package de.travelbasys.training.dialog.customer.show;

import java.util.ArrayList;
import java.util.List;

import de.travelbasys.training.dialog.VTextField;

/**
 * Diese Klasse ist verantwortlich für den Dialog mit dem Benutzer um die für
 * das anzeigen eines Customers aus der Datenbank erforderlichen Daten zu
 * erfragen.
 * 
 * @author tba
 * 
 */
public class CustomerShowView extends ArrayList<VTextField> {
	private CustomerShowModel model;
	private CustomerShowControl control;

	private static final String CUSTOMERID = "CustomerId";

	private UiComponent customerIdComponent;

	private static final long serialVersionUID = 1L;

	private List<UiComponent> uiComponents = new ArrayList<UiComponent>();

	public CustomerShowView(CustomerShowModel model, CustomerShowControl control) {
		super();
		this.model = model;
		this.control = control;
	}

	public void init() {
		customerIdComponent = new UiComponent();
		customerIdComponent.setName(CUSTOMERID);
		customerIdComponent.setValue(0);
		EventHandler eventHandler = new EventHandler() {
			@Override
			public void updateModel(Object value) {
				int intValue = Integer.parseInt((String) value);
				model.setCustomerId(intValue);
			}
		};
		customerIdComponent.setEventHandler(eventHandler);
		Controller controller = new CustomerShowControl(model) {
			@Override
			public void handleInput(Object value) {
				checkCustomerId();
			}
		};
		customerIdComponent.setController(controller);
		add(customerIdComponent);
	}

	private void add(UiComponent uiComponent) {
		uiComponents.add(uiComponent);
	}

	public void run() {
		// Vorabaktion

		// Standardaktion
		for (UiComponent uiComponent : uiComponents) {
			uiComponent.run();
		}

		// Nachtrag
	}

}