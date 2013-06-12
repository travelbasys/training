package de.travelbasys.training.dialog.menu;

import de.travelbasys.training.dialog.customer.create.CustomerCreateDialog;
import de.travelbasys.training.dialog.customer.delete.manager.CustomerDeleteDialog;
import de.travelbasys.training.dialog.customer.list.CustomerListDialog;
import de.travelbasys.training.dialog.customer.show.CustomerShowDialog;
import de.travelbasys.training.dialog.customer.update.manager.CustomerUpdateDialog;
import de.travelbasys.training.dialog.other.configuration.manager.ChangeConfigurationDialog;
import de.travelbasys.training.dialog.other.exporting.ExportDialog;
import de.travelbasys.training.dialog.other.importing.ImportDialog;
import de.travelbasys.training.dialog.other.lottery.LotteryNumbersDialog;
import de.travelbasys.training.dialog.other.parameters.manager.ChangeParamDialog;
import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */
public class MainMenuControl {

	private MainMenuModel model;
	private MainMenuView view;

	private Dialog lotteryDialog = null;

	/**
	 * 
	 * @param model
	 * @param view
	 */
	public MainMenuControl(Model model, View view) {
		this.model = (MainMenuModel) model;
		this.view = (MainMenuView) view;

		AbstractUiComponent uic;
		uic = this.view.getcustomerDecisionComponent();
		uic.setControl(new AbstractControl() {
			// Vorbedingung: der gegebenen Parameter "value" ist numerisch.
			//
			// Wandelt den gegebenen Eingabewert, welcher vom Benutzer
			// eingegeben wurde, in ein Dialogobjekt um (sofern
			// erkennbar ist, welches Dialog der Benutzer meinte)
			// und speichert das Objekt im Model.
			// Beim Wert 0 (=Programmende) wird das Finished Flag
			// im Model gesetzt.
			// Beim Wert 99 ...
			// Wenn der Wert nicht erkennbar ist, wird eine Exception
			// geworfen.
			// Nebeneffekt: Wenn Value==10, dann wird das Feld lotteryDialog
			// verändert.
			public void handleInput(Object value) throws Exception {

				int intValue;
				try {
					intValue = (Integer) value;
				} catch (Exception e) {
					throw new IllegalArgumentException(
							"Input value not numeric");
				}

				MainMenuControl.this.model.setDialog(null);

				// Es ist garantiert, dass der Eingabewert tatsächlich
				// numerisch ist!!!
				switch (intValue) {
				case 0:
					MainMenuControl.this.model.setFinished(true);
					break;
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
					MainMenuControl.this.model
							.setDialog(new CustomerListDialog());
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
				case 10:
					// Wir müssen das Dialogobjekt lokal speichern,
					// d.h. nicht nur im Model,
					// weil wir es u. U. später einmal canceln wollen.
					lotteryDialog = new LotteryNumbersDialog();
					MainMenuControl.this.model.setDialog(lotteryDialog);
					break;
				case 99:
					if (lotteryDialog != null) {
						((LotteryNumbersDialog) lotteryDialog).cancel();
						lotteryDialog = null;
					}
					break;
				default:
					throw new Exception("ChooseErrComp");
				}
			}
		});

	}

}
