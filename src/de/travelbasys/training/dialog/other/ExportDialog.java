package de.travelbasys.training.dialog.other;

import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.util.Console;

/**
* Diese Klasse ist für das Exportieren der aktuellen Datenbank verantwortlich.
*@author tba
**/
public class ExportDialog implements Dialog {

	private ExportModel model;
	private ExportView view;
	private ExportControl control;
	private Dialog d;

	public void run() {
		model = new ExportModel();
		control = new ExportControl(model);
		view = new ExportView(model, control);

		// Here plays the music!
		view.run();
		try {
			d = model.getDialog();
			d.run();
		} catch (NullPointerException e) {
Console.println(model.getAbort());
		}

		// Do something with the input!

	}

}