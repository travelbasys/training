package de.travelbasys.training.dialog.other.importing;

import java.io.IOException;

import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse ist f�r das Importieren der aktuellen Datenbank verantwortlich.
 * 
 * @author tba
 **/
public class ImportDialog implements Dialog {

	private ImportModel model;
	private ImportView view;
	@SuppressWarnings("unused")
	private ImportControl control;

	public ImportDialog() {
		model = new ImportModel();
		view = new ImportView(model);
		control = new ImportControl(model, view);
	}

	@Override
	public void run() {

		// Here plays the music!
		view.run();
		if (model.getEnd()) {
			return;
		}

		try {
			CustomerDAO.importCSV(model.getImportName() + "."
					+ model.getImportType());
			AppContext.println("ImportOK");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}