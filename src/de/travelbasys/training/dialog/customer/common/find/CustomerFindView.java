package de.travelbasys.training.dialog.customer.common.find;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

/**
 * stellt einen View innerhalb des Find-Dialoges dar.
 */
public class CustomerFindView implements View {
	private static final String CUSTOMERID = "CustomerId";
	private static final String START = "AttentionIntPrompt";
	private UiComponent customerIdComponent;
	private CustomerFindModel model;

	public AbstractUiComponent getCustomerIdComponent() {
		return customerIdComponent;
	}

	/**
	 * Erzeugt und initalisiert eine Komponente mit dem Model. Die Komponente
	 * wird einer Liste von Komponenten hinzugefügt.
	 * 
	 * @param model
	 *            Das Model des Packages.
	 */
	public CustomerFindView(Model model) {
		this.model = (CustomerFindModel) model;

		customerIdComponent = new UiComponent();
		customerIdComponent.setName(CUSTOMERID);
		customerIdComponent.setValue(this.model.getCustomerId());
	}

	/**
	 * Gibt einen Warnhinweis aus und ruft jede Komponente aus einer Liste von
	 * Komponenten auf.
	 * 
	 */
	@Override
	public void run() {
		// Vorher
		AppContext.printMessage(START);

		// Standardaktion
		customerIdComponent.run();
		// Nachher
	}

}