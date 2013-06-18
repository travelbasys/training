package de.travelbasys.training.dialog.other.importing;

import java.io.IOException;

import javafx.scene.control.Dialogs;
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
				if (model.getFiles().length == 0) {
					AppContext.printErrString("NoFilesFound");
					return;
				}
				Dao.getDAO().importCSV(model.getImportName());
				int importedCustomers = Dao.getDAO()
						.getImportedCustomersNumber();
				if (importedCustomers >= 1) {
					System.out.println(importedCustomers + " "
							+ AppContext.getMessage("CustomerImport"));
					AppContext.printMessage("ImportOK");
				} else {
					AppContext.printErrString("NoNewData");
				}
			}
		} catch (CustomerDaoException c) {
			Console.printerr(c.getMessage());
		} catch (IOException e) {
			Console.printerr(AppContext.getMessage("FileNotFoundException"));
		}

		try {
			if (model.getImportType() == ".mdb") {
				if (model.getFiles().length == 0) {
					AppContext.printErrString("NoFilesFound");
					return;
				}
				Dao.getDAO().importMDB(model.getImportName());
				view.run2();
				Dao.getDAO()
						.batchUpdateSelectedMDBTable(model.getImportTable());
				int importedCustomers = Dao.getDAO()
						.getImportedCustomersNumber();
				if (importedCustomers >= 1) {
					System.out.println(importedCustomers + " "
							+ AppContext.getMessage("CustomerImport"));
					AppContext.printMessage("ImportOK");
				} else {
					AppContext.printErrString("NoNewData");
				}
			}
		} catch (CustomerDaoException e) {
			Dialogs.showErrorDialog(null, AppContext.getMessage("TableIsEmpty"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
