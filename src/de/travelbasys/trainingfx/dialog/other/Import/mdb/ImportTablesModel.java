package de.travelbasys.trainingfx.dialog.other.Import.mdb;

import de.travelbasys.training.framework.Model;

public class ImportTablesModel implements Model {

	private ImportTablesDialog dialog;

	public void setCurrentDialog(ImportTablesDialog dialog) {
		this.dialog = dialog;
	}

	public ImportTablesDialog getCurrentDialog() {
		return dialog;
	}

}
