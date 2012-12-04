package experiment.javafx.travelbasys;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.dao.mysql.MySQLCustomerDAO;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.CommandLine;
import de.travelbasys.training.util.Configuration;
import experiment.javafx.travelbasys.dialog.about.AboutDialogGUI;
import experiment.javafx.travelbasys.dialog.customer.create.CustomerCreateDialogGUI;
import experiment.javafx.travelbasys.dialog.customer.delete.CustomerDeleteDialogGUI;
import experiment.javafx.travelbasys.dialog.customer.list.CustomerListDialogGUI;
import experiment.javafx.travelbasys.dialog.customer.show.CustomerShowDialogGUI;
import experiment.javafx.travelbasys.dialog.customer.update.CustomerUpdateDialogGUI;

public class MainControl implements Control {

	private MainView view;
	@SuppressWarnings("unused")
	private MainModel model;

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
					public void handle(ActionEvent e) {

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
						Dialog d = new CustomerDeleteDialogGUI(
								MainControl.this.view.getRoot());
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
								MainControl.this.view.getRoot());
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
