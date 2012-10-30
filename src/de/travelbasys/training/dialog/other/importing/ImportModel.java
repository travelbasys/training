package de.travelbasys.training.dialog.other.importing;

import java.util.ArrayList;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.util.AppContext;

/**
 * erzeugt eine Instanz der Klasse ImportDialog und verwaltet Strings für
 * Ausgaben.
 */
public class ImportModel extends ArrayList<String> implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ImportType = "";
	private String ImportName = "";
	private String Header = "";
	private boolean end = false;

	/**
	 * Erzeugt eine Instanz der Klasse...
	 */
	public ImportModel() {
		super();
		add(AppContext.getMessage("Choose"));
		add(AppContext.getMessage("Back"));
		add(AppContext.getMessage("Import1"));
		add(AppContext.getMessage("Import2"));
	}

	public String getImportType() {
		return ImportType;
	}

	public void setImportType(String type) {
		ImportType = type;
	}

	public String getImportName() {
		return ImportName;
	}

	public void setImportName(String name) {
		ImportName = name;
	}

	public String getHeader() {
		return Header;
	}

	public void setHeader(String header) {
		Header = header;
	}

	public void setEnd() {
		end = true;
	}

	public boolean getEnd() {
		return end;
	}

}
