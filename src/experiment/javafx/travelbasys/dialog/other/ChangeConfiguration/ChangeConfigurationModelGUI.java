package experiment.javafx.travelbasys.dialog.other.ChangeConfiguration;

import de.travelbasys.training.framework.Model;

public class ChangeConfigurationModelGUI implements Model {

	private String db = "";
	private String dbtypestr = "";
	private String lang = "";
	private int dbtype = 0;
	private String stylesheet = "";

	public void setStylesheet(String stylesheet) {
		this.stylesheet = stylesheet;
	}

	public void setDatabaseTypeStr(String dbtypestr) {
		this.dbtypestr = dbtypestr;
	}

	public void setLanguage(String lang) {
		this.lang = lang;
	}

	public void setDatabaseName(String db) {
		this.db = db;
	}

	public boolean saveIsInvalid() {
		return db.isEmpty() || dbtypestr.isEmpty() || lang.isEmpty() || stylesheet.isEmpty();
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
		return dbtypestr;
	}

	public String getStylesheet() {
		return stylesheet;
	}
}
