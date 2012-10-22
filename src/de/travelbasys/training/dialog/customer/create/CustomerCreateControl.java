package de.travelbasys.training.dialog.customer.create;

import de.travelbasys.training.dialog.Control;
import de.travelbasys.training.dialog.Model;
import de.travelbasys.training.dialog.customer.Create.CustomerCreateModel;
import de.travelbasys.training.dialog.customer.Create.CustomerCreateView;
import de.travelbasys.training.framework.AbstractControl;
import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

/**
 */
public class CustomerCreateControl extends AbstractControl {

	private CustomerCreateModel model;
	private CustomerCreateView view;

	public void init(Model model, View view) {
		this.model = (CustomerCreateModel) model;
		this.view = (CustomerCreateView) view;

		AbstractUiComponent uic;
		
		
		uic = this.view.getCustomerLastnameComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				model.setCustomerLastname(value);
			}
		});

		uic = this.view.getCustomerFirstnameComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				model.setCustomerFirstname(value);
			}
		});
		
		uic = this.view.getCustomerAgeComponent();
		uic.setControl(new AbstractControl() {
			public void handleInput(Object value) throws Exception {
				if (value <= 0 || value > 150) {
					throw new IllegalArgumentException("AgeNotInRangeErr");
				
				model.setCustomerAge(value);
			}
		});
		
		// ...

	}
	
	
	
	
	
	
	
	@Override
	public void check(String fieldName, String value) throws Exception {

		if (fieldName == "PostalCode") {
			if ((Integer.parseInt(value) > 0 && value.length() == 5)) {
			} else {
				throw new Exception(
						AppContext.getMessage("PostalNotInRangeErr") + value);
			}
		}
	}
}
