package de.travelbasys.training.dialog.other;

import java.io.FileWriter;
import java.io.PrintWriter;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse ist für das Exportieren der aktuellen Datenbank verantwortlich.
 * 
 * @author tba
 **/
public class ExportDialog implements Dialog {

	private ExportModel model;
	private ExportView view;
	private ExportControl control;

	public void run() {
		model = new ExportModel();
		control = new ExportControl(model);
		view = new ExportView(model, control);

		// Here plays the music!
		view.run();
		if (model.getEndFlag()) {
			view.decision();
			try {
				FileWriter fw = new FileWriter(model.getExportName() + "."
						+ model.getExportType());
				PrintWriter pw = new PrintWriter(fw);
				pw.println(model.getHeader());
				for (Customer user : CustomerDAO.getUsers()) {
					AppContext.println(user);
					pw.println(user.toFormat(model.getExportType()));
				}
				AppContext.printMessage("ExportOK");
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

// Do something with the input!

