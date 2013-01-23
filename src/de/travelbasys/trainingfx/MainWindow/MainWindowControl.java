package de.travelbasys.trainingfx.MainWindow;

import java.util.Locale;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialogs;
import javafx.stage.Stage;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Config;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.trainingfx.dialog.about.AboutDialogGUI;
import de.travelbasys.trainingfx.dialog.customer.create.CustomerCreateDialogGUI;
import de.travelbasys.trainingfx.dialog.customer.delete.CustomerDeleteDialogGUI;
import de.travelbasys.trainingfx.dialog.customer.list.CustomerListDialogGUI;
import de.travelbasys.trainingfx.dialog.customer.show.CustomerShowDialogGUI;
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

		this.view.getCustomerCreateItem().setOnAction(
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Dialog d = new CustomerCreateDialogGUI(
								MainWindowControl.this.view.getRoot());
						d.run();
					}
				});

		this.view.getCustomerShowItem().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {

						Dialog d = new CustomerShowDialogGUI(
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
						Dialog d = new CustomerDeleteDialogGUI(
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
