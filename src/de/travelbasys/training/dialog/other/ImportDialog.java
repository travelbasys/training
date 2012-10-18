package de.travelbasys.training.dialog.other;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.util.AppContext;

/**
 * Diese Klasse ist für das Importieren der aktuellen Datenbank verantwortlich.
 * 
 * @author tba
 **/
public class ImportDialog implements Dialog {

	private ImportModel model;
	private ImportView view;
	private ImportControl control;

	public void run() {
		model = new ImportModel();
		control = new ImportControl(model);
		view = new ImportView(model, control);

		// Here plays the music!
		view.run();
		if (model.getEndFlag()) {
			return;
		}
			view.decision();
			try {
				FileReader fr = new FileReader(model.getImportName() + "."
						+ model.getImportType());
				BufferedReader br = new BufferedReader(fr);
				CustomerDAO.terminate();
				String s;
				Customer user = null;
				CustomerDAO.getUsers().clear();
				br.readLine();
				while ((s = br.readLine()) != null) {
					AppContext.println(s);
					user = Customer.parseCSV(s);
					CustomerDAO.getUsers().add(user);
				}
				AppContext.println("ImportOK");
				fr.close();
			} catch (FileNotFoundException e) {
				AppContext.printErrString("FileNotFoundException");
				run();
			} catch (IOException e) {
e.printStackTrace();			}

		}
	}

