package experiment.javafx.travelbasys;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Dialogs.DialogOptions;
import javafx.scene.control.Dialogs.DialogResponse;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.CustomerDAO;
import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.dao.mysql.MySQLCustomerDAO;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.CommandLine;
import de.travelbasys.training.util.Configuration;

public class MainControl implements Control {

	private MainView view;
	@SuppressWarnings("unused")
	private MainModel model;
	private ObservableList<Customer> data;
	private CustomerDAO dao;
	private Label lbl_menu = new Label();

	public MainControl(Model model, View view) {
		this.model = (MainModel) model;
		this.view = (MainView) view;
		// Initialisiere MySQl Verbindung(& Funktionen)
		dao = new MySQLCustomerDAO();
		Configuration.init(CommandLine.getOptions());
		dao.init((String) Configuration.get("db"));

		// Setzte Schrift für Menüüberschrift
		lbl_menu.setFont(new Font("Arial", 30));

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

						// (Experimentell) Erstellen einer Tabelle in welcher
						// Labels &
						// Textfelder angelegt werden für das Anlegen eines
						// neuen
						// Customers

						final TextField txt_lastname = new TextField();
						final TextField txt_firstname = new TextField();
						final TextField txt_age = new TextField();
						final TextField txt_adress = new TextField();
						final TextField txt_postalcode = new TextField();
						final TextField txt_email = new TextField();

						lbl_menu.setText("Customer Create");
						Label lbl_lastname = new Label("Lastname:");
						Label lbl_firstname = new Label("Firstname:");
						Label lbl_age = new Label("Age:");
						Label lbl_adress = new Label("Adress:");
						Label lbl_postalcode = new Label("Postalcode:");
						Label lbl_email = new Label("EMail:");

						GridPane grid = new GridPane();
						Button btn = new Button("Send");

						grid.setPadding(new Insets(10, 10, 10, 10));
						grid.setVgap(5);
						grid.setHgap(5);
						GridPane.setConstraints(lbl_menu, 0, 0);
						GridPane.setConstraints(lbl_lastname, 0, 1);
						GridPane.setConstraints(lbl_firstname, 0, 2);
						GridPane.setConstraints(lbl_age, 0, 3);
						GridPane.setConstraints(lbl_adress, 0, 4);
						GridPane.setConstraints(lbl_postalcode, 0, 5);
						GridPane.setConstraints(lbl_email, 0, 6);
						GridPane.setConstraints(txt_lastname, 1, 1);
						GridPane.setConstraints(txt_firstname, 1, 2);
						GridPane.setConstraints(txt_age, 1, 3);
						GridPane.setConstraints(txt_adress, 1, 4);
						GridPane.setConstraints(txt_postalcode, 1, 5);
						GridPane.setConstraints(txt_email, 1, 6);
						GridPane.setConstraints(btn, 10, 10);
						grid.getChildren().addAll(lbl_menu, lbl_lastname,
								lbl_firstname, lbl_age, lbl_adress,
								lbl_postalcode, lbl_email, txt_lastname,
								txt_firstname, txt_age, txt_adress,
								txt_postalcode, txt_email, btn);
						MainControl.this.view.getRoot().setCenter(grid);

						btn.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent e) {

								int dummyId = 0;
								try {
									Customer customer = new Customer(
											dummyId,
											txt_lastname.getText(),
											txt_firstname.getText(),
											Integer.parseInt(txt_age.getText()),
											txt_adress.getText(),
											txt_postalcode.getText(), txt_email
													.getText());
									dao.create(customer);
									Dialogs.showInformationDialog(
											(Stage) MainControl.this.view
													.getRoot().getScene()
													.getWindow(),
											"Transaction successful.",
											"Information",
											"Travelbasys Customer Manager");
								} catch (CustomerDaoException d) {
									Dialogs.showErrorDialog(
											(Stage) MainControl.this.view
													.getRoot().getScene()
													.getWindow(),
											"Transaction failed.", "Error",
											"Travelbasys Customer Manager");
								} catch (NumberFormatException d) {
									Dialogs.showErrorDialog(
											(Stage) MainControl.this.view
													.getRoot().getScene()
													.getWindow(),
											"Wrong syntax.", "Error",
											"Travelbasys Customer Manager");
								}
							}

						});
					}
				});

		this.view.getCustomerShowItem().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						final TextField txt_kundennr = new TextField();
						Label lbl_kundennr = new Label("CustomerID:");
						lbl_menu.setText("Customer Show");
						GridPane grid = new GridPane();
						Button btn = new Button("Search");

						btn.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent e) {
								try {
									if (getData().get(0) != null) {
										Dialogs.showInformationDialog(
												(Stage) MainControl.this.view
														.getRoot().getScene()
														.getWindow(),
												"Lastname: "
														+ getData().get(0)
																.getLastName()
														+ "\nFirstname: "
														+ getData().get(0)
																.getFirstName()
														+ "\nAge: "
														+ getData().get(0)
																.getAge()
														+ "\nAdress: "
														+ getData().get(0)
																.getAdress()
														+ "\nPostalcode: "
														+ getData()
																.get(0)
																.getPostalcode()
														+ "\neMail: "
														+ getData().get(0)
																.getEmail(),
												"Customer found: "
														+ txt_kundennr
																.getText(),
												"Travelbasys Customer Manager");
									} else {
										Dialogs.showErrorDialog(
												(Stage) MainControl.this.view
														.getRoot().getScene()
														.getWindow(),
												"Customer not found: "
														+ txt_kundennr
																.getText(),
												"Error",
												"Travelbasys Customer Manager");
									}
								} catch (NumberFormatException d) {
									Dialogs.showErrorDialog(
											(Stage) MainControl.this.view
													.getRoot().getScene()
													.getWindow(),
											"Wrong syntax: "
													+ txt_kundennr.getText(),
											"Error",
											"Travelbasys Customer Manager");
								}

							}

							private ObservableList<Customer> getData() {
								data = FXCollections.observableArrayList(dao
										.findById(Integer.parseInt(txt_kundennr
												.getText())));
								return data;
							}
						});

						grid.setPadding(new Insets(10, 10, 10, 10));
						grid.setVgap(5);
						grid.setHgap(5);
						GridPane.setConstraints(lbl_menu, 0, 0);
						GridPane.setConstraints(lbl_kundennr, 0, 1);
						GridPane.setConstraints(txt_kundennr, 3, 2);
						GridPane.setConstraints(btn, 10, 10);
						grid.getChildren().addAll(lbl_menu, lbl_kundennr,
								txt_kundennr, btn);

						MainControl.this.view.getRoot().setCenter(grid);
					}
				});

		this.view.getCustomerDeleteItem().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						final TextField txt_kundennr = new TextField();
						Label lbl_kundennr = new Label("CustomerID:");
						lbl_menu.setText("Customer Delete");

						GridPane grid = new GridPane();
						Button btn = new Button("Search");

						btn.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent e) {
								try {

									// Erzeuge Dialog-Options-Objekt

									DialogOptions options = DialogOptions.YES_NO;
									if (getData().get(0) != null) {

										// Übergebe Rückgabewert des
										// ConfirmDialoges an
										// Dialog-Response-Objekt
										// Optionen werden ans zu zeigende
										// Dialog-Objekt weitergegeben (letztes
										// Feld)

										DialogResponse response = Dialogs
												.showConfirmDialog(
														(Stage) MainControl.this.view
																.getRoot()
																.getScene()
																.getWindow(),
														"Lastname: "
																+ getData()
																		.get(0)
																		.getLastName()
																+ "\nFirstname: "
																+ getData()
																		.get(0)
																		.getFirstName()
																+ "\nAge: "
																+ getData()
																		.get(0)
																		.getAge()
																+ "\nAdress: "
																+ getData()
																		.get(0)
																		.getAdress()
																+ "\nPostalcode: "
																+ getData()
																		.get(0)
																		.getPostalcode()
																+ "\neMail: "
																+ getData()
																		.get(0)
																		.getEmail()
																+ "\nDelete?",
														"Customer found: "
																+ txt_kundennr
																		.getText(),
														"Travelbasys Customer Manager",
														options);
										// Anhand des Responses vom Dialog wird
										// eine Aktion ausgeführt

										switch (response) {
										case YES:
											try {
												dao.delete(getData().get(0));
											} catch (Exception f) {
												Dialogs.showErrorDialog(
														(Stage) MainControl.this.view
																.getRoot()
																.getScene()
																.getWindow(),
														"Unknown Error",
														"Error",
														"Travelbasys Customer Manager");
											}
											break;
										case NO:
											Dialogs.showInformationDialog(
													(Stage) MainControl.this.view
															.getRoot()
															.getScene()
															.getWindow(), "",
													"Vorgang abgebrochen.",
													"Travelbasys Customer Manager");
											break;
										default:
											break;
										}
									} else {
										Dialogs.showErrorDialog(
												(Stage) MainControl.this.view
														.getRoot().getScene()
														.getWindow(),
												"Customer not found: "
														+ txt_kundennr
																.getText(),
												"Error",
												"Travelbasys Customer Manager");
									}
								} catch (NumberFormatException d) {
									Dialogs.showErrorDialog(
											(Stage) MainControl.this.view
													.getRoot().getScene()
													.getWindow(),
											"Wrong syntax: "
													+ txt_kundennr.getText(),
											"Error",
											"Travelbasys Customer Manager");
								}

							}

							private ObservableList<Customer> getData() {
								data = FXCollections.observableArrayList(dao
										.findById(Integer.parseInt(txt_kundennr
												.getText())));
								return data;
							}
						});

						grid.setPadding(new Insets(10, 10, 10, 10));
						grid.setVgap(5);
						grid.setHgap(5);
						GridPane.setConstraints(lbl_menu, 0, 0);
						GridPane.setConstraints(lbl_kundennr, 0, 1);
						GridPane.setConstraints(txt_kundennr, 3, 2);
						GridPane.setConstraints(btn, 10, 10);
						grid.getChildren().addAll(lbl_menu, lbl_kundennr,
								txt_kundennr, btn);

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
						data = FXCollections.observableArrayList(dao.findAll());
						System.out.println(data);
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
