package de.travelbasys.training.dialog.customer.Delete;

import java.util.HashMap;

import de.travelbasys.training.dialog.Model;
import de.travelbasys.training.util.AppContext;

@SuppressWarnings("serial")
public class CustomerDeleteModel extends HashMap<String, String> implements
		Model {

	public CustomerDeleteModel() {
		super();
		put("promptAttention", AppContext.getMessage("AttentionPrompt"));
		put("promptID", AppContext.getMessage("IDPrompt"));
		put("promptUserFound", AppContext.getMessage("UserFound"));
		put("promptDelUserQ", AppContext.getMessage("DelUserQ"));
		put("promptYes", AppContext.getMessage("Yes"));
		put("promptNo", AppContext.getMessage("No"));
		put("promptDelOK", AppContext.getMessage("ChooseErr"));
		put("promptIDNotFoundErr", AppContext.getMessage("IDNotFoundErr"));
		put("promptDelUserAbort", AppContext.getMessage("DelUserAbort"));
		put("promptNumberErr", AppContext.getMessage("NumberErr"));
	}

	@Override
	public String getPrompt(String fieldName) {
		return get("prompt" + fieldName);
	}

}