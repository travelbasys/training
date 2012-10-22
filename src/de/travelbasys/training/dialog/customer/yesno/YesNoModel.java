package de.travelbasys.training.dialog.customer.yesno;

import de.travelbasys.training.framework.Model;

/**
 * erzeugt eine Instanz der Klasse CustomerDeleteDialog und verwaltet Daten
 * 
 * @author
 */
public class YesNoModel implements Model {
	private String decisiontemp;
	private int decision;
	private boolean deleteFlag;
	private boolean FlagCheck = true;

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

	public boolean getFlagCheck() {
		return FlagCheck;
	}

	public void setFlagCheck() {
		FlagCheck = false;
	}

}