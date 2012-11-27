package de.travelbasys.training.dialog.other.lottery;

import java.util.ArrayList;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.util.AppContext;

public class LotteryNumbersModel extends ArrayList<String> implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LotteryNumbersModel() {
		super();
		add(AppContext.getMessage("LotteryNumbersStart"));
	}
}
