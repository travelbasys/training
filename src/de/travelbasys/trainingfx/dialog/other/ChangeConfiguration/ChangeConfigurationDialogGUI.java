package de.travelbasys.trainingfx.dialog.other.ChangeConfiguration;

import de.travelbasys.training.framework.Dialog;

/**
 * Diese Klasse repräsentiert den Dialog der für die änderungen der
 * Konfiguration verantwortlich ist, diese beinhaltet momentan die Sprachen
 * Deutsch und Englisch, im Bereich Datenbank kann der Datenbankname und der
 * Datenbanktyp geändert werden, derzeit txt-Datei, MySQL-Datenbank und
 * mdb-Datei (MS-Access-Datenbank) und die änderung des Oberflächen Style's,
 * derzeit Caspian.css(Javafx Standard),Windows 7 glass Theme und das
 * rbsjava.css (selbst entworfenes Stylesheet, welches nah an der rbsweb
 * oberfläche ist).
 * 
 * @author tba
 * 
 */
public class ChangeConfigurationDialogGUI implements Dialog {

	private ChangeConfigurationModelGUI model;
	private ChangeConfigurationViewGUI view;
	private ChangeConfigurationControlGUI control;

	/**
	 * Der Konstruktor des ChangeConfiguration Dialogs
	 */
	public ChangeConfigurationDialogGUI() {
		model = new ChangeConfigurationModelGUI();
		view = new ChangeConfigurationViewGUI(model);
		control = new ChangeConfigurationControlGUI();
	}

	/**
	 * führt den ChangeConfiguratin Dialog aus.
	 */
	@Override
	public void run() {
		view.init();
		control.init(model, view);
		view.run();
	}

}
