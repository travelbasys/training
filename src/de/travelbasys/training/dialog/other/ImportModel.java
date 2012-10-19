package de.travelbasys.training.dialog.other;

import java.util.ArrayList;

import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.util.AppContext;

/**
 * erzeugt eine Instanz der Klasse ImportDialog
 * und verwaltet Strings für Ausgaben.
 */
public class ImportModel extends ArrayList<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String choice;
	private boolean check = true;
	private Dialog d;
	private static final String ABORT = "Abgebrochen.";
	private String ImportType = "";
	private String ImportName = "";
	private String Header = "";
	private boolean EndFlag = false;

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

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice_str) {
		this.choice = choice_str;
	}

	public boolean getCheck() {
		return check;
	}

	public void setCheckFalse() {
		check = false;
	}

	public Dialog getDialog() {
		return d;
	}

	public void setDialog(Dialog d) {
		this.d = d;
	}

	public Object getAbort() {
		return ABORT;
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

	public void setCheckTrue() {
check = true;		
	}

	public boolean getEndFlag() {
		return EndFlag;
	}

	public void setEndFlag() {
		EndFlag = true;
	}

}
