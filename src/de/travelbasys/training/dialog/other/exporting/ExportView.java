package de.travelbasys.training.dialog.other.exporting;

import java.util.ArrayList;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.Console;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für das
 * Exportieren der Datenbank abzufragen.
 * 
 * @autor tba
 */
public class ExportView extends ArrayList<UiComponent> implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ExportModel model;
	private UiComponent customerDecisionComponent;
	private UiComponent exportNameComponent;

	public ExportView(Model model) {
		this.model = (ExportModel) model;
		customerDecisionComponent = new UiComponent();
		customerDecisionComponent.setType(Integer.class);
		add(customerDecisionComponent);
		exportNameComponent = new UiComponent();
		exportNameComponent.setName("ExportName");
		exportNameComponent.setType(String.class);
		add(exportNameComponent);
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
		if (model.getEnd()) {
			return;
		}
		exportNameComponent.run();
	}
}
