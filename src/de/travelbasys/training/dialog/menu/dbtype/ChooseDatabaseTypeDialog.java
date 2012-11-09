package de.travelbasys.training.dialog.menu.dbtype;

import de.travelbasys.training.dao.CustomerDAO;
import de.travelbasys.training.framework.Dialog;

/**
 * zeigt dem Benutzer ein Menü aller Funktionen der Anwendung.
 */
public class ChooseDatabaseTypeDialog implements Dialog {

	private ChooseDatabaseTypeModel model;
	private ChooseDatabaseTypeView view;
	
	public ChooseDatabaseTypeDialog() {
		model = new ChooseDatabaseTypeModel();
		view = new ChooseDatabaseTypeView(model);
		
		// Wir rufen den Konstruktor nur wegen seiner Seiteneffekte.
		// TODO: Eventuell wieder parameterlosen Konstruktur und
		// init(Model model, View, view) benutzen.
		// Dasselbe Problem haben fast alle unsere Dialogklassen!
		new ChooseDatabaseTypeControl(model, view);
	}

	@Override
	/**
	 * führt den Menüdialog aus.
	 * Der Benutzer wird so lange nach einer Anwendungsfunktion gefragt,
	 * bis er eine "0" eingibt, ...
	 * Wenn er keine "0" eingibt, wird die betrefffende Funktion sofort ausgeführt.
	 */
	public void run() {
		view.run();
	}
	public CustomerDAO getDAO() {
		return model.getDAO();
	}
}
