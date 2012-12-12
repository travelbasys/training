package de.travelbasys.trainingfx.dialog.other.ChangeConfiguration;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.util.AppContext;

public class ChangeConfigurationModelGUI implements Model {

	private String db = "";
	private String dbtypestr = "";
	private String lang = "";
	private int dbtype = 0;
	private String stylesheet = "";

	public void setStylesheet(String stylesheet) {
		this.stylesheet = stylesheet;
	}

	public void setLanguage(String lang) {
		this.lang = lang;
	}

	public void setDatabaseName(String db) {
		this.db = db;
	}

	public boolean saveIsInvalid() {
		return db.isEmpty() || dbtype == 0 || lang.isEmpty()
				|| stylesheet.isEmpty();
	}

	public String getDatabaseName() {
		return db;
	}

	public int getDatabaseType() {
		return dbtype;
	}

	public String getLang() {
		return lang;
	}

	public void setDatabaseType(int dbtype) {
		this.dbtype = dbtype;
	}

	public String getDatabaseTypeStr() {
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

	public String getStylesheet() {
		return stylesheet;
	}
}
