package de.travelbasys.training.dialog.other.exporting;

import java.io.FileWriter;
import java.io.PrintWriter;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse ist f�r das Exportieren der aktuellen Datenbank verantwortlich.
 * 
 * @author tba
 **/
public class ExportDialog implements Dialog {

	private ExportModel model;
	private ExportView view;
	@SuppressWarnings("unused")
	private ExportControl control;

	public ExportDialog() {
		model = new ExportModel();
		view = new ExportView(model);
		control = new ExportControl(model, view);
	}

	@Override
	public void run() {

		// Here plays the music!
		view.run();
		if (model.getExportType() == null) {
			return;
		}
		try {
			FileWriter fw = new FileWriter(model.getExportName() + "."
					+ model.getExportType());
			PrintWriter pw = new PrintWriter(fw);
			pw.println(model.getHeader());
			for (Customer customer : CustomerDAO.findAll()) {
				AppContext.println(customer);
				pw.println(customer.toFormat(model.getExportType()));
			}
			AppContext.printMessage("ExportOK");
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
