package experiment.javafx.travelbasys.dialog.customer.list;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.View;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class CustomerListViewGUI implements View {

	private CustomerListModelGUI model;

	public CustomerListViewGUI(CustomerListModelGUI model) {
		this.model = (CustomerListModelGUI) model;
	}

	@Override
	public void run() {

		TableView table = new TableView<Customer>();

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

		// Erstelle Referenz zu Tabelle und fülle mit Daten
		// Erstellen Node (VBox) für Platzierung der Tabelle
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 10, 10, 10));
		// Platziere Tabelle in der VBox
		vbox.getChildren().addAll(table);
		model.setTable(table);
		model.setWindow(vbox);
	}

	public void show() {
		model.getTable().setItems(model.getData());
		model.getRoot().setCenter(model.getWindow());
	}
}