package experiment.javafx.travelbasys.dialog.customer.list;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class CustomerListViewGUI implements View {

	@SuppressWarnings("unused")
	private CustomerListModelGUI model;
	private BorderPane root;
	private VBox vbox;
	private TableView table;

	public CustomerListViewGUI(CustomerListModelGUI model, BorderPane root) {
		this.model = (CustomerListModelGUI) model;
		this.root = root;
	}

	@Override
	public void run() {

		table = new TableView<Customer>();

		TableColumn customerIDCol = new TableColumn(AppContext.getMessage("CustomerIDTable"));
		customerIDCol.setMinWidth(100);
		customerIDCol
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"id"));

		TableColumn lastNameCol = new TableColumn(AppContext.getMessage("LastnameTable"));
		lastNameCol.setMinWidth(100);
		lastNameCol
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"lastName"));

		TableColumn firstNameCol = new TableColumn(AppContext.getMessage("FirstnameTable"));
		firstNameCol.setMinWidth(100);
		firstNameCol
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"firstName"));

		TableColumn ageCol = new TableColumn(AppContext.getMessage("AgeTable"));
		ageCol.setMinWidth(100);
		ageCol.setCellValueFactory(new PropertyValueFactory<Customer, String>(
				"age"));

		TableColumn adressCol = new TableColumn(AppContext.getMessage("AdressTable"));
		adressCol.setMinWidth(100);
		adressCol
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"adress"));

		TableColumn postalcodeCol = new TableColumn(AppContext.getMessage("PostalcodeTable"));
		postalcodeCol.setMinWidth(100);
		postalcodeCol
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"postalcode"));

		TableColumn emailCol = new TableColumn(AppContext.getMessage("EmailTable"));
		emailCol.setMinWidth(100);
		emailCol.setCellValueFactory(new PropertyValueFactory<Customer, String>(
				"email"));

		table.getColumns().addAll(customerIDCol, lastNameCol, firstNameCol,
				ageCol, adressCol, postalcodeCol, emailCol);

		// Erstelle Referenz zu Tabelle und fülle mit Daten
		// Erstellen Node (VBox) für Platzierung der Tabelle
		vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 10, 10, 10));
		// Platziere Tabelle in der VBox
		vbox.getChildren().addAll(table);
	}

	public void show() {
		root.setCenter(vbox);
	}

	public BorderPane getRoot() {
		return root;
	}

	public VBox getVbox() {
		return vbox;
	}

	public TableView getTable() {
		return table;
	}
}