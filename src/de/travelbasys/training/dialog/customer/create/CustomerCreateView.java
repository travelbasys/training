package de.travelbasys.training.dialog.customer.create;

import java.util.ArrayList;

import de.travelbasys.training.dialog.customer.VTextField;

public class CustomerCreateView extends ArrayList<VTextField> {

	private static final long serialVersionUID = 1L;

	public CustomerCreateView(Model model, Control control) {
		super();
		
		add( new VTextField( "LastName", model, control ));
		add( new VTextField( "FirstName", model, control ));
		add( new VTextField( "Age", model, control ));
		add( new VTextField( "Adress", model, control ));
		add( new VTextField( "PostalCode", model, control ));
		add( new VTextField( "EMail", model, control ));
	}

	public void run() {
		
		for (VTextField t : this) {
			t.run();
		}

	}

}
