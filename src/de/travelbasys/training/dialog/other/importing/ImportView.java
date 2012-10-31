package de.travelbasys.training.dialog.other.importing;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für das
 * Importieren der Datenbank abzufragen.
 * 
 * @autor tba
 */
public class ImportView implements View {

	/**
	 * 
	 */
	private ImportModel model;
	private UiComponent customerDecisionComponent;
	private UiComponent importNameComponent;

	public ImportView(Model model) {
		this.model = (ImportModel) model;
		customerDecisionComponent = new UiComponent();
		customerDecisionComponent.setType(Integer.class);
		importNameComponent = new UiComponent();
		importNameComponent.setName("ImportName");
		importNameComponent.setType(String.class);
	}

	public AbstractUiComponent getcustomerDecisionComponent() {
		return customerDecisionComponent;
	}

	public AbstractUiComponent getimportNameComponent() {
		return importNameComponent;
	}

	public void run() {

		for (String s : model) {
			Console.println(s);
		}
		customerDecisionComponent.run2();
		if (model.getImportType() == null) {
			return;
		}
		importNameComponent.run();
	}
}
