package de.travelbasys.training.dialog.other.importing;

import java.io.File;
import java.io.IOException;

import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.dao.Dao;
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
			if (model.getImportType() == ".csv") {

				Dao.getDAO().importCSV(
						model.getImportName() + "." + model.getImportType());
				AppContext.println("ImportOK");

			}
			// Die Importmethode für Access-Datenbanken ist geplant allerdings
			// noch
			// nicht implementiert
			// da die Formatierung noch nicht geklärt ist (Header). Daher
			// tue nichts.
			// if (model.getImportType() == ".mdb") {
			// TODO: Fix import (SQLException / ConnectionError)
			File inputFile = new File(model.getImportName()
					+ model.getImportType());
			try {
				Dao.getDAO().importMDB(inputFile.getAbsolutePath());
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		} catch (CustomerDaoException c) {
			Console.printerr(c.getMessage());
		} catch (IOException e) {
			Console.printerr(AppContext.getMessage("FileNotFoundException"));
		}

	}
}
