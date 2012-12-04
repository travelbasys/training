package experiment.javafx.travelbasys;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.dao.mysql.MySQLCustomerDAO;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.CommandLine;
import de.travelbasys.training.util.Configuration;
import experiment.javafx.travelbasys.dialog.customer.create.CustomerCreateDialogGUI;
import experiment.javafx.travelbasys.dialog.customer.show.CustomerShowDialogGUI;
import experiment.javafx.travelbasys.dialog.customer.update.CustomerUpdateDialogGUI;

public class MainControl implements Control {

	private MainView view;
	@SuppressWarnings("unused")
	private MainModel model;
	private ObservableList<Customer> data;

	public MainControl(Model model, View view) {
		this.model = (MainModel) model;
		this.view = (MainView) view;
		// Initialisiere MySQl Verbindung(& Funktionen)
		Dao.setDAO(new MySQLCustomerDAO());
		Configuration.init(CommandLine.getOptions());
		Dao.getDAO().init((String) Configuration.get("db"));

		// Setze EventHandler für Exit-Menüpunkt
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
						Dialog d = new CustomerCreateDialogGUI(
								MainControl.this.view.getRoot());
						d.run();
					}
				});

		this.view.getCustomerShowItem().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {

						Dialog d = new CustomerShowDialogGUI(
								MainControl.this.view.getRoot());
						d.run();

					}
				});

		this.view.getCustomerEditItem().setOnAction(
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Dialog d = new CustomerUpdateDialogGUI(
								MainControl.this.view.getRoot());
						d.run();
					}
				});

		this.view.getCustomerDeleteItem().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
					}
				});

		this.view.getLotteryItem().setOnAction(new EventHandler<ActionEvent>() {

			private void buildlottery() {
			}

			@Override
			public void handle(ActionEvent arg0) {
				buildlottery();
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
						table = new CreateCustomerTableView().getTable();
						table.setItems(getData());
						// Erstellen Node (VBox) für Platzierung der Tabelle
						VBox vbox = new VBox();
						vbox.setSpacing(5);
						vbox.setPadding(new Insets(10, 10, 10, 10));
						// Platziere Tabelle in der VBox
						vbox.getChildren().addAll(table);
						// Aktualisiere Bildbereich mit der VBox
						MainControl.this.view.getRoot().setCenter(vbox);
					}

					private ObservableList<Customer> getData() {
						data = FXCollections.observableArrayList(Dao.getDAO()
								.findAll());
						return data;
					}
				});
	}

	@Override
	public void init(Model model, View view) {
	}

	@Override
	public void handleInput(Object value) throws Exception {
	}

}
