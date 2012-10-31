package de.travelbasys.training.dialog.other.importing;

import java.io.IOException;

import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

/**
 * Diese Klasse ist für das Importieren der aktuellen Datenbank verantwortlich.
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
		if (model.getImportType() == null) {
			return;
		}
		try {
			if (model.getImportType() == "CSV") {

				CustomerDAO.importCSV(model.getImportName() + "."
						+ model.getImportType());
				AppContext.println("ImportOK");

			}
			// Die Importmethode für Access-Datenbanken ist geplant allerdings
			// noch
			// nicht implementiert
			// da die Formatierung noch nicht geklärt ist (Header). Daher
			// tue nichts.
			if (model.getImportType() == "ACCESS") {
				/*
				 * CustomerDAO.importMDB(model.getImportName() + "." +
				 * model.getImportType()); AppContext.println("ImportOK");
				 */}
		} catch (IOException e) {
			Console.printerr(AppContext.getMessage("FileNotFoundException"));
		}

	}
}
