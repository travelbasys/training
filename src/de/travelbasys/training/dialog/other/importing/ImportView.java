package de.travelbasys.training.dialog.other.importing;

import java.io.File;
import java.io.FilenameFilter;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für das
 * Importieren der Datenbank abzufragen.
 * 
 * @author tba
 */
public class ImportView implements View {

	/**
	 * 
	 */
	private ImportModel model;
	private UiComponent customerDecisionComponent;
	private UiComponent importNameComponent;
	private UiComponent importTableComponent;
	private File dir = null;
	private File[] files = null;

	/**
	 * Diese Methode ist für den Dialog mit dem Benutzer verantwortlich um alle
	 * nötigen informationen für einen Import abzufragen.
	 * 
	 * @param model
	 */
	public ImportView(Model model) {
		this.model = (ImportModel) model;
		customerDecisionComponent = new UiComponent();
		customerDecisionComponent.setType(Integer.class);
		importNameComponent = new UiComponent();
		importNameComponent.setName("ImportName");
		importNameComponent.setType(String.class);

		importTableComponent = new UiComponent();
		importTableComponent.setName("ImportTable");
		importTableComponent.setType(String.class);
	}

	public AbstractUiComponent getcustomerDecisionComponent() {
		return customerDecisionComponent;
	}

	public AbstractUiComponent getimportNameComponent() {
		return importNameComponent;
	}

	public AbstractUiComponent getimportTableComponent() {
		return importTableComponent;
	}

	public void run() {

		for (String s : model) {
			Console.println(s);
		}
		customerDecisionComponent.run2();
		if (model.getImportType() != null) {
			if (model.getImportType() == ".mdb") {
				dir = new File("./");
				files = dir.listFiles(new FilenameFilter() {
					public boolean accept(File d, String name) {
						return name.endsWith(".mdb");
					}
				});
			}
			if (model.getImportType() == ".csv") {
				dir = new File("./");
				files = dir.listFiles(new FilenameFilter() {
					public boolean accept(File d, String name) {
						return name.endsWith(".csv");
					}
				});
			}
			model.setFiles(files);
			if (model.getFiles().length == 0) {
				return;
			}
			for (File f : files) {
				System.out.println(f.getName());
			}
			importNameComponent.run();
		}
	}

	public void run2() {
		importTableComponent.run();
	}

}
