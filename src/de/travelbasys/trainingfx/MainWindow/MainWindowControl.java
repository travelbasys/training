package de.travelbasys.trainingfx.MainWindow;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Locale;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialogs;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Config;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.trainingfx.dialog.about.AboutDialogGUI;
import de.travelbasys.trainingfx.dialog.customer.create2.CustomerCreate2DialogGUI;
import de.travelbasys.trainingfx.dialog.customer.delete2.CustomerDelete2DialogGUI;
import de.travelbasys.trainingfx.dialog.customer.list.CustomerListDialogGUI;
import de.travelbasys.trainingfx.dialog.customer.show2.CustomerShow2DialogGUI;
import de.travelbasys.trainingfx.dialog.customer.update2.CustomerUpdate2DialogGUI;
import de.travelbasys.trainingfx.dialog.other.ChangeConfiguration.ChangeConfigurationDialogGUI;

public class MainWindowControl implements Control {

	private MainWindowView view;
	@SuppressWarnings("unused")
	private MainWindowModel model;

	public MainWindowControl(MainWindowModel model) {
		this.model = (MainWindowModel) model;
	}

	public void init(View view) {
		this.view = (MainWindowView) view;

		// Setze EventHandler für Exit-Menüpunkt
		this.view.getExitItem().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Dao.getDAO().terminate();
				System.exit(0);
			}
		});

		this.view.getImportingItem().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						FileChooser fileChooser = new FileChooser();
						fileChooser.getExtensionFilters().addAll(
								new FileChooser.ExtensionFilter(AppContext
										.getMessage("CSVFiles"), "*.csv"),
								new FileChooser.ExtensionFilter(AppContext
										.getMessage("MDBFiles"), "*.mdb"));
						File inputFile = fileChooser.showOpenDialog(null);
						
						String ext = null;
						String s = inputFile.getName();
						int i = s.lastIndexOf('.');

						if (i > 0 && i < s.length() - 1)
							ext = s.substring(i + 1).toLowerCase();

						if (ext == null) {
							ext = "";
						}
						
						System.out.println(inputFile.getAbsolutePath());
						System.out.println(ext);
						
					}
				});

		this.view.getExportingItem().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						String pattern = AppContext.getMessage("CSVPattern");
						FileChooser fileChooser = new FileChooser();
						fileChooser.getExtensionFilters().addAll(
								new FileChooser.ExtensionFilter(AppContext
										.getMessage("CSVFiles"), "*.csv"),
								new FileChooser.ExtensionFilter(AppContext
										.getMessage("MDBFiles"), "*.mdb"));
						java.io.File outputFile = fileChooser.showSaveDialog(null).getAbsoluteFile();
					try{

							FileWriter fw = new FileWriter(outputFile);
							PrintWriter pw = new PrintWriter(fw);
							pw.println(pattern);
							for (Customer customer : Dao.getDAO().findAll()) {
								AppContext.println(customer);
								pw.println(customer.toFormat("csv"));
							}
							pw.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
		this.view.getCustomerCreateItem().setOnAction(
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Dialog d = new CustomerCreate2DialogGUI(
								MainWindowControl.this.view.getRoot());
						d.run();
					}
				});

		this.view.getCustomerShowItem().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {

						Dialog d = new CustomerShow2DialogGUI(
								MainWindowControl.this.view.getRoot());
						d.run();

					}
				});

		this.view.getCustomerEditItem().setOnAction(
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						// "Standard"
						// Dialog d = new CustomerUpdate2DialogGUI(
						// MainWindowControl.this.view.getRoot());
						//
						// FXML
						Dialog d = new CustomerUpdate2DialogGUI(
								MainWindowControl.this.view.getRoot());
						d.run();
					}
				});

		this.view.getCustomerDeleteItem().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						Dialog d = new CustomerDelete2DialogGUI(
								MainWindowControl.this.view.getRoot());
						d.run();
					}
				});

		this.view.getLotteryItem().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
			}
		});

		this.view.getAboutItem().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				Dialog d = new AboutDialogGUI();
				d.run();
			}
		});

		this.view.getCustomerListItem().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						Dialog d = new CustomerListDialogGUI(
								MainWindowControl.this.view.getRoot());
						d.run();
					}
				});

		this.view.getChangeLanguage1Item().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						Config.updateLanguage(new Locale("de"));
						// MainControl.this.view.init();
						// init(MainControl.this.view);
					}

				});

		this.view.getChangeLanguage2Item().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						Config.updateLanguage(new Locale("en"));
						// MainControl.this.view.init();
						// init(MainControl.this.view);
					}

				});

		this.view.getChangeDB1Item().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						try {
							int dbtype = 1;
							Dao.setDAO(dbtype);
							Dao.getDAO().init((String) Configuration.get("db"));
							Dialogs.showInformationDialog(
									(Stage) MainWindowControl.this.view
											.getRoot().getScene().getWindow(),
									"Datenbank gewechselt.", "Information",
									AppContext.getMessage("TravelbasysManager"));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				});
		this.view.getChangeDB2Item().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						try {
							int dbtype = 2;
							Dao.setDAO(dbtype);
							Dao.getDAO().init((String) Configuration.get("db"));
							Dialogs.showInformationDialog(
									(Stage) MainWindowControl.this.view
											.getRoot().getScene().getWindow(),
									"Datenbank gewechselt.", "Information",
									AppContext.getMessage("TravelbasysManager"));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
		this.view.getChangeDB3Item().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						try {
							int dbtype = 3;
							Dao.setDAO(dbtype);
							Dao.getDAO().init((String) Configuration.get("db"));
							Dialogs.showInformationDialog(
									(Stage) MainWindowControl.this.view
											.getRoot().getScene().getWindow(),
									"Datenbank gewechselt.", "Information",
									AppContext.getMessage("TravelbasysManager"));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

		this.view.getConfigurationItem().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						Dialog d = new ChangeConfigurationDialogGUI();
						d.run();
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
