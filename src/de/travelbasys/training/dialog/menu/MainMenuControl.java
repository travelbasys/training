package de.travelbasys.training.dialog.menu;

import de.travelbasys.training.dialog.customer.create.CustomerCreateDialog;
import de.travelbasys.training.dialog.customer.delete.manager.CustomerDeleteDialog;
import de.travelbasys.training.dialog.customer.list.CustomerList;
import de.travelbasys.training.dialog.customer.show.manager.CustomerShowDialog;
import de.travelbasys.training.dialog.customer.update.manager.CustomerUpdateDialog;
import de.travelbasys.training.dialog.other.configuration.manager.ChangeConfigurationDialog;
import de.travelbasys.training.dialog.other.exporting.ExportDialog;
import de.travelbasys.training.dialog.other.importing.ImportDialog;
import de.travelbasys.training.dialog.other.parameters.manager.ChangeParamDialog;
import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.rbsjava.main.Application;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */
public class MainMenuControl extends Application {

	private MainMenuModel model;
	private MainMenuView view;

	public MainMenuControl(Model model, View view) {
		this.model = (MainMenuModel) model;
		this.view = (MainMenuView) view;
		AbstractUiComponent uic;
		uic = this.view.getcustomerDecisionComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				int intValue = (Integer) value;
				switch (intValue) {
				case 0:
					stop();
					terminate();
				case 1:
					MainMenuControl.this.model
							.setDialog(new CustomerCreateDialog());
					break;
				case 2:
					MainMenuControl.this.model
							.setDialog(new CustomerShowDialog());
					break;
				case 3:
					MainMenuControl.this.model
							.setDialog(new CustomerUpdateDialog());
					break;
				case 4:
					MainMenuControl.this.model
							.setDialog(new CustomerDeleteDialog());
					break;
				case 5:
					MainMenuControl.this.model.setDialog(new CustomerList());
					break;
				case 6:
					MainMenuControl.this.model.setDialog(new ExportDialog());
					break;
				case 7:
					MainMenuControl.this.model.setDialog(new ImportDialog());
					break;
				case 8:
					MainMenuControl.this.model
							.setDialog(new ChangeConfigurationDialog());
					break;
				case 9:
					MainMenuControl.this.model
							.setDialog(new ChangeParamDialog());
					break;
				default:
					throw new Exception("ChooseErrComp");
				}
			}
		});

	}

}
