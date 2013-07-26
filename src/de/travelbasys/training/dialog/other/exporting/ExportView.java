package de.travelbasys.training.dialog.other.exporting;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 * ist verantwortlich f�r den Dialog mit dem Benutzer, um alle Daten f�r das
 * Exportieren der Datenbank abzufragen.
 * 
 * @author tba
 */
public class ExportView implements View {

	/**
	 * 
	 */
	private ExportModel model;
	private UiComponent customerDecisionComponent;
	private UiComponent exportNameComponent;

	public ExportView(Model model) {
		this.model = (ExportModel) model;
		customerDecisionComponent = new UiComponent();
		customerDecisionComponent.setType(Integer.class);
		exportNameComponent = new UiComponent();
		exportNameComponent.setName("ExportName");
		exportNameComponent.setType(String.class);
	}

	public AbstractUiComponent getcustomerDecisionComponent() {
		return customerDecisionComponent;
	}

	public AbstractUiComponent getExportNameComponent() {
		return exportNameComponent;
	}

	public void run() {

		for (String s : model) {
			Console.println(s);
		}
		customerDecisionComponent.run2();
		// TODO: Ende der Funktion auslagern -> Controller/Dialog(?).
		if (model.getExportType() == null) {
			return;
		}
		exportNameComponent.run();
	}
}
