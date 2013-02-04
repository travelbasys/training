package de.travelbasys.trainingfx.dialog.customer.list;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.training.util.ConfigurationEvent;
import de.travelbasys.training.util.ConfigurationListener;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class CustomerListViewGUI implements View, ConfigurationListener {

	@SuppressWarnings("unused")
	private CustomerListModelGUI model;
	private BorderPane root;
	private VBox vbox;
	private TableView table;
	private TableColumn customerIDCol;
	private TableColumn lastNameCol;
	private TableColumn firstNameCol;
	private TableColumn birthDateCol;
	private TableColumn adressCol;
	private TableColumn postalcodeCol;
	private TableColumn emailCol;

	public CustomerListViewGUI(CustomerListModelGUI model, BorderPane root) {
		this.model = (CustomerListModelGUI) model;
		this.root = root;
	}

	public void init() {

		Configuration.addConfigurationListener(this);

		table = new TableView<Customer>();

		customerIDCol = new TableColumn();
		customerIDCol.setMinWidth(100);
		customerIDCol
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"id"));

		lastNameCol = new TableColumn();
		lastNameCol.setMinWidth(100);
		lastNameCol
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"lastName"));

		firstNameCol = new TableColumn();
		firstNameCol.setMinWidth(100);
		firstNameCol
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"firstName"));

		birthDateCol = new TableColumn();
		birthDateCol.setMinWidth(100);
		birthDateCol
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"birthdate"));

		adressCol = new TableColumn();
		adressCol.setMinWidth(100);
		adressCol
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"adress"));

		postalcodeCol = new TableColumn();
		postalcodeCol.setMinWidth(100);
		postalcodeCol
				.setCellValueFactory(new PropertyValueFactory<Customer, String>(
						"postalcode"));

		emailCol = new TableColumn();
		emailCol.setMinWidth(100);
		emailCol.setCellValueFactory(new PropertyValueFactory<Customer, String>(
				"email"));

		table.getColumns().addAll(customerIDCol, lastNameCol, firstNameCol,
				birthDateCol, adressCol, postalcodeCol, emailCol);
		// Erstelle Referenz zu Tabelle und fülle mit Daten
		// Erstellen Node (VBox) für Platzierung der Tabelle
		vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 10, 10, 10));
		// Platziere Tabelle in der VBox
		vbox.getChildren().addAll(table);

		handleConfigurationEvent(null);

	}

	public void run() {
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

	@Override
	public void handleConfigurationEvent(ConfigurationEvent e) {
		customerIDCol.setText(AppContext.getMessage("CustomerIDTable"));
		lastNameCol.setText(AppContext.getMessage("LastnameTable"));
		firstNameCol.setText(AppContext.getMessage("FirstnameTable"));
		birthDateCol.setText(AppContext.getMessage("BirthdateTable"));
		adressCol.setText(AppContext.getMessage("AdressTable"));
		postalcodeCol.setText(AppContext.getMessage("PostalcodeTable"));
		emailCol.setText(AppContext.getMessage("EmailTable"));
	}

}