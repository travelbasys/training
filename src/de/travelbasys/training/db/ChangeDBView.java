package de.travelbasys.training.db;

import java.util.ArrayList;

import de.travelbasys.training.dialog.Control;
import de.travelbasys.training.dialog.Model;
import de.travelbasys.training.dialog.customer.VTextField;

public class ChangeDBView extends ArrayList<VTextField> {

	private static final long serialVersionUID = 1L;

	public ChangeDBView(Model model, Control control) {
		super();

		add(new VTextField("ChangeDB", model, control));
	}

	public void run() {

		for (VTextField t : this) {
			t.run();
		}

	}

}
