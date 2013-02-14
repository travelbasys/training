package de.travelbasys.trainingfx.MainWindow;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Types;
import java.util.Locale;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialogs;
import javafx.stage.Stage;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;

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
import de.travelbasys.trainingfx.dialog.other.Import.ImportDialogGUI;

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
						Dialog d = new ImportDialogGUI();
						d.run();
					}
				});

		this.view.getExportingItem().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						String pattern = AppContext.getMessage("CSVPattern");
						JFileChooser fileChooser = new JFileChooser();
						FileFilter fileFilter1 = new FileNameExtensionFilter(
								AppContext.getMessage("CSVFiles"), ".csv");
						FileFilter fileFilter2 = new FileNameExtensionFilter(
								AppContext.getMessage("MDBFiles"), ".mdb");
						fileChooser.setAcceptAllFileFilterUsed(false);
						fileChooser.addChoosableFileFilter(fileFilter1);
						fileChooser.addChoosableFileFilter(fileFilter2);
						int result = fileChooser.showSaveDialog(null);
						if (result == JFileChooser.APPROVE_OPTION) {
							File outputFile = fileChooser.getSelectedFile();
							if (outputFile != null) {
								try {

									String ext = ((FileNameExtensionFilter) (fileChooser
											.getFileFilter())).getExtensions()[0];
									if (ext == ".csv") {
										FileWriter fw = new FileWriter(
												(outputFile + ext).trim());
										PrintWriter pw = new PrintWriter(fw);
										pw.println(pattern);
										for (Customer customer : Dao.getDAO()
												.findAll()) {
											AppContext.println(customer);
											pw.println(customer.toCSV());
										}
										pw.close();
									} else if (ext == ".mdb") {
										outputFile = new File(outputFile
												.getAbsolutePath() + ext);
										Database db = Database
												.create(outputFile);
										Table newTable = new TableBuilder(
												"tb_customer")
												.addColumn(
														new ColumnBuilder(
																"customerid")
																.setSQLType(
																		Types.INTEGER)
																.toColumn())
												.addColumn(
														new ColumnBuilder(
																"lastname")
																.setSQLType(
																		Types.VARCHAR)
																.toColumn())
												.addColumn(
														new ColumnBuilder(
																"firstname")
																.setSQLType(
																		Types.VARCHAR)
																.toColumn())
												.addColumn(
														new ColumnBuilder(
																"birthdate")
																.setSQLType(
																		Types.DATE)
																.toColumn())
												.addColumn(
														new ColumnBuilder(
																"adress")
																.setSQLType(
																		Types.VARCHAR)
																.toColumn())
												.addColumn(
														new ColumnBuilder(
																"postalcode")
																.setSQLType(
																		Types.VARCHAR)
																.toColumn())
												.addColumn(
														new ColumnBuilder(
																"email")
																.setSQLType(
																		Types.VARCHAR)
																.toColumn())
												.toTable(db);
										for (Customer customer : Dao.getDAO()
												.findAll()) {
											newTable.addRow(customer.getId(),
													customer.getLastName(),
													customer.getFirstName(),
													customer.getBirthdate(),
													customer.getAdress(),
													customer.getPostalcode(),
													customer.getEmail());
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
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
