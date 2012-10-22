package de.travelbasys.training.dialog.customer.yesno;

import java.util.ArrayList;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.util.AppContext;

/**
 * erzeugt eine Instanz der Klasse CustomerDeleteDialog und verwaltet Daten
 * 
 * @author
 */
public class YesNoModel extends ArrayList<String> implements Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String decisiontemp;
	private int decision;
	private boolean deleteFlag;
	private boolean EndFlag = false;

	public YesNoModel() {
		super();
		add(AppContext.getMessage("DelUserQ"));
		add(AppContext.getMessage("Yes"));
		add(AppContext.getMessage("No"));
	}

	public String getDecisiontemp() {
		return decisiontemp;
	}

	public void setDecisiontemp(String temp) {
		decisiontemp = temp;
	}

	public int getDecision() {
		return decision;
	}

	public void setDecision(int decision) {
		this.decision = decision;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public boolean getDeleteFlag() {
		return deleteFlag;
	}

	public boolean getEndFlag() {
		return EndFlag;
	}

	public void setEndFlag() {
		EndFlag = true;
	}

}