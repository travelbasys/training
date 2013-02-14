package de.travelbasys.trainingfx.dialog.other.Import;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Dialogs;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Config;

public class ImportDialogGUI implements Dialog {

	private String PATH = "/de/travelbasys/trainingfx/dialog/other/Import/";
	private String FILE = "ImportFrame.fxml";

	public ImportDialogGUI() {
	}

	@Override
	public void run() {

		JFileChooser fileChooser = new JFileChooser();
		FileFilter fileFilter1 = new FileNameExtensionFilter(
				AppContext.getMessage("CSVFiles"), "csv");
		FileFilter fileFilter2 = new FileNameExtensionFilter(
				AppContext.getMessage("MDBFiles"), "mdb");
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(fileFilter1);
		fileChooser.addChoosableFileFilter(fileFilter2);

		int result = fileChooser.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			File inputFile = fileChooser.getSelectedFile();
			String ext = null;
			if (inputFile != null) {
				try {
					String s = inputFile.getName();
					int i = s.lastIndexOf('.');

					if (i > 0 && i < s.length() - 1)
						ext = s.substring(i + 1).toLowerCase();

					if (ext == null) {
						ext = "";
					}

					if (ext.equals("csv")) {
						Dao.getDAO().importCSV(inputFile.getAbsolutePath());
						int importedCustomers = Dao.getDAO()
								.getImportedCustomersNumber();
						if (importedCustomers >= 1) {
							Dialogs.showInformationDialog(
									null,
									importedCustomers
											+ " "
											+ AppContext
													.getMessage("CustomerImport"),
									AppContext.getMessage("ImportOK"),
									AppContext.getMessage("TravelbasysManager"));
						} else {
							Dialogs.showInformationDialog(null,
									"Keine neuen Daten gefunden.");
						}
					} else if (ext.equals("mdb")) {
						Dao.getDAO().importMDB(inputFile.getAbsolutePath());

						AnchorPane importTablesPane = FXMLLoader.load(
								getClass().getResource(PATH + FILE),
								Config.BUNDLE);
						Stage stage = new Stage();
						Scene scene = new Scene(importTablesPane);
						stage.setScene(scene);
						stage.show();

					}
				} catch (IOException e) {
					Dialogs.showErrorDialog(
							null,
							AppContext.getMessage("CriticalError")
									+ e.getStackTrace());
				} catch (CustomerDaoException e) {
					Dialogs.showErrorDialog(
							null,
							AppContext.getMessage("NotBatched"),
							AppContext.getMessage("Error")
									+ AppContext.getMessage("TransactionFail"),
							AppContext.getMessage("TravelbasysManager"));
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
