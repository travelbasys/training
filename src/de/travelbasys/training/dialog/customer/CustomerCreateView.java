package de.travelbasys.training.dialog.customer;

import java.util.ArrayList;

public class CustomerCreateView extends ArrayList<VTextField> {

	private static final long serialVersionUID = 1L;

	public CustomerCreateView(CustomerCreateModel model, CustomerCreateControl control) {
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
