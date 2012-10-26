package de.travelbasys.training.dialog.customer.update.attributes;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dialog.customer.common.show1.CustomerShow1Dialog;
import de.travelbasys.training.dialog.customer.update.menu.CustomerUpdateMenuDialog;
import de.travelbasys.training.framework.Dialog;

/**
 * zeigt ein {@see Customer} Objekt an und erlaubt dem Benutzer anschließend,
 * dessen Attribute zu ändern.
 * 
 * <p>
 * Die aktuelle Implementierung benutzt folgende Schritte:
 * </p>
 * 
 * <ol>
 * <li>{@see CustomerShow1Dialog} zeigt das {@see Customer} Objekt.
 * <li>{@see ShowAndChange1Dialog} zeigt ein Menü mit dem alle einzelnen
 * Attribute geändert werden können.
 * <li>...?
 * </ol>
 */
public class CustomerAttributesUpdateDialog implements Dialog {

	private CustomerAttributesUpdateView view;
	private CustomerAttributesUpdateModel model;
	@SuppressWarnings("unused")
	private CustomerAttributesUpdateControl control;

	private Customer customer;

	private int index;

	/**
	 * erzeugt eine Instanz des Dialoges und speichert das gegebene
	 * {@see Customer} Objekt.
	 * 
	 * @param customer
	 */
	public CustomerAttributesUpdateDialog(Customer customer) {
		this.customer = customer;

		model = new CustomerAttributesUpdateModel();
		// Model mit den Customerattributen initialisieren.
		model.setAdress(customer.getAdress());
		model.setAge(customer.getAge());
		model.setFirstName(customer.getFirstName());
		model.setLastName(customer.getLastName());
		model.setPostalcode(customer.getPostalcode());
		model.setEMail(customer.getEmail());
		
		view = new CustomerAttributesUpdateView(model);
		control = new CustomerAttributesUpdateControl(model,view);
	}

	/**
	 * führt den Dialog aus.
	 */
	@Override
	public void run() {
		CustomerShow1Dialog d1 = new CustomerShow1Dialog(customer);
		do {
			d1.run();

			// Menü
			CustomerUpdateMenuDialog md = new CustomerUpdateMenuDialog();
			md.run();

			index = md.getSelectedIndex();
			if (index == 0) {
				return;
			}

			// Ausgewähltes Attribut ändern.
			// Der Wert von Index ist 0 für "Beenden" und 1 bis 6 für
			// das zu ändernde Attribut.
			// Die UiComponents im View, welche die Attribute repräsentieren,
			// sind aber von 0 an nummeriert.
			// Also müssen wir den Index anpassen.
			model.setComponentIndex(index - 1);
			view.run();

			// Customer mit den aktuellen Modelattributen aktualisieren.
			customer.setAdress(model.getAdress());
			customer.setAge(model.getAge());
			customer.setFirstName(model.getFirstName());
			customer.setLastName(model.getLastName());
			customer.setPostalcode(model.getPostalcode());
			customer.setEMail(model.getEMail());
		} while (true);
	}
}
