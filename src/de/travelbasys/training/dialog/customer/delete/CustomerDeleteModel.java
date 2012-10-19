package de.travelbasys.training.dialog.customer.delete;

import java.util.ArrayList;
import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.util.AppContext;

/**
 * erzeugt eine Instanz der Klasse CustomerDeleteDialog und verwaltet Strings
 * für Ausgaben
 */
@SuppressWarnings("serial")
public class CustomerDeleteModel extends ArrayList<String> {
	private String customeridtemp;
	private int customerid;
	private String decisiontemp;
	private int decision;
	private Customer user;
	private List<Customer> userlist = null;
	private boolean deleteFlag;
	private boolean FlagCheck = true;
	private boolean end = true;
	private boolean gotuser = true;

	public CustomerDeleteModel() {
		super();
		add(AppContext.getMessage("AttentionIntPrompt"));
		add(AppContext.getMessage("DelOK"));
		add(AppContext.getMessage("IDPrompt"));
		add(AppContext.getMessage("UserFound"));
		add(AppContext.getMessage("DelUserQ"));
		add(AppContext.getMessage("Yes"));
		add(AppContext.getMessage("No"));
		add(AppContext.getMessage("ChooseErr"));
		add(AppContext.getMessage("IDNotFoundErr"));
		add(AppContext.getMessage("DelUserAbort"));
		add(AppContext.getMessage("NumberErr"));
	}

	public String getCustomeridtemp() {
		return customeridtemp;
	}

	public void setCustomeridtemp(String customeridtemp) {
		this.customeridtemp = customeridtemp;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getDecisiontemp() {
		return decisiontemp;
	}

	public void setDecisiontemp(String decisiontemp) {
		this.decisiontemp = decisiontemp;
	}

	public int getDecision() {
		return decision;
	}

	public void setDecision(int decision) {
		this.decision = decision;
	}

	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}

	public List<Customer> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<Customer> userlist) {
		this.userlist = userlist;
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

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	public boolean isGotuser() {
		return gotuser;
	}

	public void setGotuser(boolean gotuser) {
		this.gotuser = gotuser;
	}

}