package de.travelbasys.training.dialog.customer.showandchange;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dialog.customer.show1.CustomerShow1Dialog;
import de.travelbasys.training.dialog.customer.showandchange1.ShowAndChange1Dialog;
import de.travelbasys.training.framework.Dialog;

/**
 * zeigt ein {@see Customer} Objekt an und erlaubt dem Benutzer anschließend,
 * dessen Attribute zu ändern.
 */
public class ShowAndChangeDialog implements Dialog {

	private ShowAndChangeView view;
	private ShowAndChangeModel model;
	private ShowAndChangeControl control;

	private Customer customer;

	private int index;

	/**
	 * führt den Dialog aus.
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
	@Override
	public void run() {
		CustomerShow1Dialog d2 = new CustomerShow1Dialog();
		d2.setCustomer(customer);
		d2.init();
		
		do {
			d2.run();
			
			// Menü
			ShowAndChange1Dialog d3 = new ShowAndChange1Dialog();
			d3.init();
			d3.run();
			
			index = d3.getSelectedIndex();
			if (index == 0) {
				return;
			}
			model.setComponentIndex(index);
			view.run();
			
			// Customer mit den aktuellen Modelattributen aktualisieren.
			customer.setAdress( model.getAdress());
			customer.setAge( model.getAge());
			customer.setFirstName(model.getFirstName());
			customer.setLastName( model.getLastName());
			customer.setPostalcode( model.getPostalcode());
			customer.setEMail( model.getEMail());
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
		if( null == customer ){
			throw new IllegalStateException("Customer attribute is null");
		}
		model = new ShowAndChangeModel();
		control = new ShowAndChangeControl();
		view = new ShowAndChangeView(model, control);

		// Model mit den Customerattributen initialisieren.
		model.setId(customer.getId());
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
	 * Setzt den aktuellen Wert des {@see Customer} Attributs dieses
	 * Dialogs.
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
