package experiment.javafx.travelbasys.dialog.other.ChangeConfiguration;

import java.util.Locale;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Configuration;

public class ChangeConfigurationControlGUI {

	private ChangeConfigurationViewGUI view;
	private ChangeConfigurationModelGUI model;

	@SuppressWarnings("unchecked")
	public void init(Model model, View view) {
		this.view = (ChangeConfigurationViewGUI) view;
		this.model = (ChangeConfigurationModelGUI) model;
		
		this.view.getDatabaseNameField().setText((String) Configuration.get("db"));
		
		
		this.view.getDatabaseTypeComboBox().setValue(getDBTypeString());
		
		this.view.getLanguageComboBox().setValue(getLanguageString());
	}

	private String getLanguageString() {
		String languagestr;
		if (Locale.getDefault().toString().equals("en")) {
			languagestr = AppContext.getMessage("English");
		} else if (Locale.getDefault().toString().equals("de")) {
			languagestr = AppContext.getMessage("German");
		} else {
			languagestr = "default";
		}
		return languagestr;
	}

	private String getDBTypeString() {
		int dbtype;
		String dbtypestr;
		try {
			dbtype = Integer.parseInt((String) Configuration.get("dbtype"));
		} catch (NumberFormatException e) {
			dbtype = 0;
		}

		switch (dbtype) {
		case 1:
			dbtypestr = AppContext.getMessage("DatabaseType1");
			break;
		case 2:
			dbtypestr = AppContext.getMessage("DatabaseType2");
			break;
		case 3:
			dbtypestr = AppContext.getMessage("DatabaseType3");
			break;
		default:
			dbtypestr = "default";
			break;
		}
		return dbtypestr;
	}
}
