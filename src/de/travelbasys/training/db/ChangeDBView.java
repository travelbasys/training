package de.travelbasys.training.db;

import java.util.ArrayList;

import de.travelbasys.training.dialog.Control;
import de.travelbasys.training.dialog.Model;
import de.travelbasys.training.dialog.VTextField;
/**
 * Diese Klasse ist verantwortlich f�r den Dialog mit dem Benutzer um die f�r
 * das �ndern der Datenbank erforderlichen abzufragen
 * @author tba
 *
 */
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
