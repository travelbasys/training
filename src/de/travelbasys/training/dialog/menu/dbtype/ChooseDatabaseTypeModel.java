package de.travelbasys.training.dialog.menu.dbtype;

import java.util.ArrayList;
import java.util.Locale;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.util.AppContext;

/**
 * erzeugt eine Instanz der Klasse MainMenuDialog und verwaltet Strings f�r
 * Ausgaben.
 */
public class ChooseDatabaseTypeModel extends ArrayList<String> implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String d;
	private Locale lang;

	/**
	 * Erzeugt eine Instanz der Klasse...
	 */
	public ChooseDatabaseTypeModel() {
		super();
		init();
	}

	public void init() {
		clear();
		add(AppContext.getMessage("Choose"));
		add(AppContext.getMessage("ExitApp"));
		add(AppContext.getMessage("DBType1"));
		add(AppContext.getMessage("DBType2"));
		add(AppContext.getMessage("DBType3"));
		setLang();
	}

	public void setLang() {
		lang = Locale.getDefault();
	}

	public Locale getLang() {
		return lang;
	}

	public void setDAO(String d) {
		this.d = d;
	}

	public boolean isLanguageChanged() {
		if (Locale.getDefault() == getLang()) {
			return false;
		}

		return true;
	}

	public String getDAO() {
		return d;
	}

}
