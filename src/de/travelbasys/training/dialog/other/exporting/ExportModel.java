package de.travelbasys.training.dialog.other.exporting;

import java.util.ArrayList;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.util.AppContext;

/**
 * erzeugt eine Instanz der Klasse ExportDialog und verwaltet Strings für
 * Ausgaben.
 */
public class ExportModel extends ArrayList<String> implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ExportType = "";
	private String ExportName = "";
	private String Header = "";
	private boolean end = false;

	/**
	 * Erzeugt eine Instanz der Klasse...
	 */
	public ExportModel() {
		super();
		add(AppContext.getMessage("Choose"));
		add(AppContext.getMessage("Back"));
		add(AppContext.getMessage("Export1"));
		add(AppContext.getMessage("Export2"));
	}

	public String getExportType() {
		return ExportType;
	}

	public void setExportType(String type) {
		ExportType = type;
	}

	public String getExportName() {
		return ExportName;
	}

	public void setExportName(String name) {
		ExportName = name;
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
