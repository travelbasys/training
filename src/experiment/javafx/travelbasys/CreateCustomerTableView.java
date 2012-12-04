package experiment.javafx.travelbasys;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import de.travelbasys.training.business.Customer;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class CreateCustomerTableView extends TableView {

	private TableView table;

	public CreateCustomerTableView() {
		table = new TableView<Customer>();

		table.setEditable(true);

		TableColumn customerIDCol = new TableColumn("CustomerID");
		customerIDCol.setMinWidth(100);
		customerIDCol
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"id"));

		TableColumn lastNameCol = new TableColumn("Lastname");
		lastNameCol.setMinWidth(100);
		lastNameCol
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"lastName"));

		TableColumn firstNameCol = new TableColumn("Firstname");
		firstNameCol.setMinWidth(100);
		firstNameCol
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"firstName"));

		TableColumn ageCol = new TableColumn("Age");
		ageCol.setMinWidth(100);
		ageCol.setCellValueFactory(new PropertyValueFactory<Customer, String>(
				"age"));

		TableColumn adressCol = new TableColumn("Adress");
		adressCol.setMinWidth(100);
		adressCol
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"adress"));

		TableColumn postalcodeCol = new TableColumn("Postalcode");
		postalcodeCol.setMinWidth(100);
		postalcodeCol
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"postalcode"));

		TableColumn emailCol = new TableColumn("Email");
		emailCol.setMinWidth(100);
		emailCol.setCellValueFactory(new PropertyValueFactory<Customer, String>(
				"email"));

		table.getColumns().addAll(customerIDCol, lastNameCol, firstNameCol,
				ageCol, adressCol, postalcodeCol, emailCol);
	}

	public TableView getTable() {
		return table;
	}

}