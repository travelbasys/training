package de.travelbasys.training.dialog.menu.dbtype;

import de.travelbasys.training.dao.access.AccessCustomerDAO;
import de.travelbasys.training.dao.mysql.MySQLCustomerDAO;
import de.travelbasys.training.dao.text.TxtCustomerDAO;
import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */
public class ChooseDatabaseTypeControl {

	private ChooseDatabaseTypeModel model;
	private ChooseDatabaseTypeView view;

	/**
	 * 
	 * @param model
	 * @param view
	 */
	public ChooseDatabaseTypeControl(Model model, View view) {
		this.model = (ChooseDatabaseTypeModel) model;
		this.view = (ChooseDatabaseTypeView) view;

		AbstractUiComponent uic;
		uic = this.view.getcustomerDecisionComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {

				int intValue = (Integer) value;
				ChooseDatabaseTypeControl.this.model.setDAO(null);

				switch (intValue) {
				case 0:
					return;
				case 1:
					ChooseDatabaseTypeControl.this.model
							.setDAO(new AccessCustomerDAO());
					break;
				case 2:
					ChooseDatabaseTypeControl.this.model
							.setDAO(new MySQLCustomerDAO());
					break;
				case 3:
					ChooseDatabaseTypeControl.this.model
							.setDAO(new TxtCustomerDAO());
					break;
				default:
					throw new Exception("ChooseErrComp");
				}
			}
		});

	}

}
