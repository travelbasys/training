package experiment.javafx.travelbasys.dialog.customer.show;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

public class CustomerShowViewGUI implements View {

	private CustomerShowModelGUI model;

	public CustomerShowViewGUI(Model model) {
		this.model = (CustomerShowModelGUI) model;
	}

	public void run() {

		final TextField txt_customerid = new TextField();
		Label lbl_customerid = new Label("CustomerID:");
		Label lbl_menu = new Label("Customer Show");
		lbl_menu.setFont(new Font("Arial", 30));

		GridPane grid = new GridPane();
		Button btn = new Button("Search");

		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		GridPane.setConstraints(lbl_menu, 0, 0);
		GridPane.setConstraints(lbl_customerid, 0, 1);
		GridPane.setConstraints(txt_customerid, 3, 1);
		GridPane.setConstraints(btn, 10, 10);
		grid.getChildren()
				.addAll(lbl_menu, lbl_customerid, txt_customerid, btn);
		model.setTxt_customerid(txt_customerid);
		model.setBtn(btn);
		model.setWindow(grid);
	}

	public void show() {
		model.getRoot().setCenter(model.getWindow());
	}
}
