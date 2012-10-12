package de.travelbasys.training.dialog.customer.Delete;

import java.util.ArrayList;

import de.travelbasys.training.dialog.Control;
import de.travelbasys.training.dialog.Model;
import de.travelbasys.training.dialog.VTextField;
/**
 * Diese Klasse ist verantwortlich für den Dialog mit dem Benutzer um die für
 * das löschen eines Customers aus der Datenbank
 * @author tba
 *
 */
public class CustomerDeleteView extends ArrayList<VTextField>{

	
	private static final long serialVersionUID = 1L;
	public CustomerDeleteView(Model model, Control control) {
		
	add( new VTextField( "AttentionPromt", model, control ));
	
	add(new VTextField("IDPrompt", model, control));
	add(new VTextField("UserFound", model, control));
	add(new VTextField("DelUserQ", model, control));
	add(new VTextField("Yes", model, control));
	add(new VTextField("No", model, control));
	add(new VTextField("ChooseErr", model, control));
	add(new VTextField("IDNotFoundErr", model, control));
	add(new VTextField("DelUserAbort", model, control));
	add(new VTextField("NumberErr", model, control));
	
	
	}
	public void run() {
		for (VTextField t : this) {
			t.run();	
		
		
	}

}}