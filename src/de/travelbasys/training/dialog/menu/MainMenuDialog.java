package de.travelbasys.training.dialog.menu;

import de.travelbasys.training.framework.Dialog;

/**
 * zeigt dem Benutzer ein Menü aller Funktionen der Anwendung.
 */
public class MainMenuDialog implements Dialog {

	private MainMenuModel model;
	private MainMenuView view;
	
	public MainMenuDialog() {
		model = new MainMenuModel();
		view = new MainMenuView(model);
		
		// Wir rufen den Konstruktor nur wegen seiner Seiteneffekte.
		// TODO: Eventuell wieder parameterlosen Konstruktur und
		// init(Model model, View, view) benutzen.
		// Dasselbe Problem haben fast alle unsere Dialogklassen!
		new MainMenuControl(model, view);
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
	
	public Dialog getDialog(){
		return model.getDialog();
	}

	public boolean isCancelled() {
		return model.isCancelled();
	}
}
