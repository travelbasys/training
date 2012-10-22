package de.travelbasys.training.db;

import java.util.ArrayList;

import de.travelbasys.training.framework.AbstractUiComponent;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.UiComponent;
import de.travelbasys.training.framework.View;

/**
 * Diese Klasse ist verantwortlich für den Dialog mit dem Benutzer um die für
 * das ändern der Datenbank erforderlichen abzufragen
 * 
 * @author tba
 * 
 */
public class ChangeDBView extends ArrayList<UiComponent> implements View {

	private static final long serialVersionUID = 1L;
	private ChangeDBModel model;
	private UiComponent changeDBComponent;
	private static final String CHANGEDB = "ChangeDB";

	public AbstractUiComponent getchangeDBComponent() {
		return changeDBComponent;
	}

	public ChangeDBView(ChangeDBModel model, ChangeDBControl control) {
		super();
		this.model = model;
	}

	public void init(Model model) {
		this.model = (ChangeDBModel) model;

		changeDBComponent = new UiComponent();
		changeDBComponent.setName(CHANGEDB);
		changeDBComponent.setValue(this.model.getDBkey());
		add(changeDBComponent);
	}

	public void run() {
		for (UiComponent uiComponent : this) {
			uiComponent.run();
		}
	}
}
