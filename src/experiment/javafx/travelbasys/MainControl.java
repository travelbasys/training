package experiment.javafx.travelbasys;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.CustomerDAO;
import de.travelbasys.training.dao.mysql.MySQLCustomerDAO;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

public class MainControl implements Control {

	private MainView view;
	@SuppressWarnings("unused")
	private MainModel model;
	private ObservableList<Customer> data;

	public MainControl(Model model, View view) {
		this.model = (MainModel) model;
		this.view = (MainView) view;

		this.view.getExitItem().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});

		this.view.getCustomerCreateItem().setOnAction(
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {

						// (Experimentell) Erstellen einer Tabelle in welcher
						// Labels &
						// Textfelder angelegt werden für das Anlegen eines
						// neuen
						// Customers

						TextField txt_lastname = new TextField();
						TextField txt_firstname = new TextField();
						TextField txt_age = new TextField();
						TextField txt_adress = new TextField();
						TextField txt_postalcode = new TextField();
						TextField txt_email = new TextField();

						Label lbl_lastname = new Label("Lastname:");
						Label lbl_firstname = new Label("Firstname:");
						Label lbl_age = new Label("Age:");
						Label lbl_adress = new Label("Adress:");
						Label lbl_postalcode = new Label("Postalcode:");
						Label lbl_email = new Label("EMail:");

						GridPane grid = new GridPane();
						grid.setPadding(new Insets(10, 10, 10, 10));
						grid.setVgap(5);
						grid.setHgap(5);
						GridPane.setConstraints(lbl_lastname, 0, 0);
						GridPane.setConstraints(lbl_firstname, 0, 1);
						GridPane.setConstraints(lbl_age, 0, 2);
						GridPane.setConstraints(lbl_adress, 0, 3);
						GridPane.setConstraints(lbl_postalcode, 0, 4);
						GridPane.setConstraints(lbl_email, 0, 5);
						GridPane.setConstraints(txt_lastname, 1, 0);
						GridPane.setConstraints(txt_firstname, 1, 1);
						GridPane.setConstraints(txt_age, 1, 2);
						GridPane.setConstraints(txt_adress, 1, 3);
						GridPane.setConstraints(txt_postalcode, 1, 4);
						GridPane.setConstraints(txt_email, 1, 5);
						grid.getChildren().addAll(lbl_lastname, lbl_firstname,
								lbl_age, lbl_adress, lbl_postalcode, lbl_email,
								txt_lastname, txt_firstname, txt_age,
								txt_adress, txt_postalcode, txt_email);
						MainControl.this.view.getRoot().setCenter(grid);
					}
				});

		this.view.getAboutItem().setOnAction(new EventHandler<ActionEvent>() {

			// Behandelt einen Klick auf das About-Item
			// Legt ein neues Fenster an, in welchem Name & Jahr innerhalb einer
			// (unsichtbaren) Tabelle angezeigt
			// werden.

			private Stage buildabout() {
				Stage aboutwindow = new Stage();
				aboutwindow.setTitle("About");

				Label name = new Label("Name: Daniel Rowlin");
				Label year = new Label("Year: 2012");

				// Erzeugt ein TabellenPanel.
				GridPane grid = new GridPane();
				// Setzt alle Ränder auf 10 Pixel.
				grid.setPadding(new Insets(10, 10, 10, 10));
				// Setzt den Abstand innerhalb der Tabelle auf 5 Pixel.
				grid.setVgap(5);
				grid.setHgap(5);
				// Setzt Zeilen/Spaltenposition der Elemente fest.
				// (Objekt, Spalte, Zeile)
				GridPane.setConstraints(name, 0, 0);
				GridPane.setConstraints(year, 0, 1);

				grid.getChildren().addAll(name, year);

				aboutwindow.setScene(new Scene(grid, 320, 240));
				aboutwindow.setResizable(false);
				return aboutwindow;
			}

			// Zeigt das Fenster

			@Override
			public void handle(ActionEvent arg0) {
				buildabout().show();
			}
		});

		this.view.getCustomerShowAllItem().setOnAction(
				new EventHandler<ActionEvent>() {

					@SuppressWarnings({ "rawtypes", "unchecked" })
					@Override
					public void handle(ActionEvent arg0) {
						// Erstelle Referenz zu Tabelle und fülle mit Daten
						TableView table;
						table = createCustomerTableView();
						table.setItems(getData());
						// Erstellen Node (VBox) für Platzierung der Tabelle
						final VBox vbox = new VBox();
						vbox.setSpacing(5);
						vbox.setPadding(new Insets(10, 10, 10, 10));
						// Platziere Tabelle in der VBox
						vbox.getChildren().addAll(table);
						// Aktualisiere Bildbereich mit der VBox
						MainControl.this.view.getRoot().setCenter(vbox);
					}

					private ObservableList<Customer> getData() {
						CustomerDAO dao = new MySQLCustomerDAO();
						dao.init("testdb");
						data = FXCollections.observableArrayList(dao.findAll());
						return data;
					}

					@SuppressWarnings({ "rawtypes", "unchecked" })
					private TableView<Customer> createCustomerTableView() {
						TableView<Customer> table = new TableView<Customer>();

						table.setEditable(true);

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

						TableColumn postalcodeCol = new TableColumn(
								"Postalcode");
						postalcodeCol.setMinWidth(100);
						postalcodeCol
								.setCellValueFactory(new PropertyValueFactory<Customer, String>(
										"postalcode"));

						TableColumn emailCol = new TableColumn("Email");
						emailCol.setMinWidth(100);
						emailCol.setCellValueFactory(new PropertyValueFactory<Customer, String>(
								"email"));

						table.getColumns().addAll(lastNameCol, firstNameCol,
								ageCol, adressCol, postalcodeCol, emailCol);
						return table;
					}
				});
	}

	@Override
	public void init(Model model, View view) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleInput(Object value) throws Exception {
		// TODO Auto-generated method stub

	}

}
