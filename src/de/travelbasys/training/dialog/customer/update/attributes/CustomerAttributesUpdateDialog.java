package de.travelbasys.training.dialog.customer.update.attributes;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dialog.customer.show1.CustomerShow1Dialog;
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
	private CustomerAttributesUpdateControl control;

	private Customer customer;

	private int index;

	/**
	 * führt den Dialog aus.
	 */
	@Override
	public void run() {
		CustomerShow1Dialog d1 = new CustomerShow1Dialog();
		d1.setCustomer(customer);
		d1.init();

		do {
			d1.run();

			// Menü
			CustomerUpdateMenuDialog md = new CustomerUpdateMenuDialog();
			md.init();
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

	/**
	 * Erzeugt interne Model, View und Control Instanzen und initialisiert
	 * diese.
	 * 
	 * <p>
	 * Das Model erhält bei der Initialisierung die Attribute eines {@see
	 * Customer} Objekts. Voraussetzung ist, dass die Methode {@see
	 * #setCustomer(Customer)} bereits ausgeführt wurde.
	 * </p>
	 */
	public void init() {
		if (null == customer) {
			throw new IllegalStateException("Customer attribute is null");
		}
		model = new CustomerAttributesUpdateModel();
		control = new CustomerAttributesUpdateControl();
		view = new CustomerAttributesUpdateView();

		// Model mit den Customerattributen initialisieren.
		model.setAdress(customer.getAdress());
		model.setAge(customer.getAge());
		model.setFirstName(customer.getFirstName());
		model.setLastName(customer.getLastName());
		model.setPostalcode(customer.getPostalcode());
		model.setEMail(customer.getEmail());

		view.init(model);
		control.init(model, view);
	}

	/**
	 * Setzt den aktuellen Wert des {@see Customer} Attributs dieses Dialogs.
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
