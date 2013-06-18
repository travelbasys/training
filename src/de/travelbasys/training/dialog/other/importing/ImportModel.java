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
	private String importType = "";
	private String importName = "";
	private String importTable = "";
	private String header = "";

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
		return importType;
	}

	public void setImportType(String type) {
		importType = type;
	}

	public String getImportName() {
		return importName;
	}

	public void setImportName(String name) {
		importName = name;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public void setImportTable(String table) {
		importTable = table;
	}

	public String getImportTable() {
		return importTable;
	}

}
