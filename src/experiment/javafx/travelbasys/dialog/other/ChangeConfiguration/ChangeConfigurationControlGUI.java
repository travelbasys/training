package experiment.javafx.travelbasys.dialog.other.ChangeConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialogs;
import javafx.scene.text.Text;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Config;
import de.travelbasys.training.util.Configuration;

public class ChangeConfigurationControlGUI implements Control {

	private ChangeConfigurationViewGUI view;
	private ChangeConfigurationModelGUI model;
	protected static final String DATABASE_KEY = "database";
	protected static final String LANGUAGE_KEY = "lang";
	protected static final String STYLESHEET_KEY = "stylesheet";
	protected static final String DATABASE_TYPE_KEY = "database_type";
	protected static File ini = new File(Config.CONFIG_FILENAME);
	private Properties config;
	private Text languagestr;
	private Text dbtypestr;

	@SuppressWarnings("unchecked")
	public void init(Model model, View view) {
		this.view = (ChangeConfigurationViewGUI) view;
		this.model = (ChangeConfigurationModelGUI) model;

		config = new Properties();
		try {
			config.load(new FileInputStream(ini));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		languagestr = new Text();
		dbtypestr = new Text();

		this.view.getAbortButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ChangeConfigurationControlGUI.this.view.getStage().close();
			}
		});

		this.view.getDatabaseNameField().textProperty()
				.addListener(new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {

						ChangeConfigurationControlGUI.this.model
								.setDatabaseName(ChangeConfigurationControlGUI.this.view
										.getDatabaseNameField().getText()
										.trim());

						ChangeConfigurationControlGUI.this.view
								.updateSaveButton();

					}
				});

		this.view.getDatabaseTypeComboBox().valueProperty()
				.addListener(new ChangeListener<Text>() {

					@Override
					public void changed(
							ObservableValue<? extends Text> observable,
							Text oldValue, Text newValue) {

						if (!newValue.getText().isEmpty()) {

							if (newValue.getText().equals(
									AppContext.getMessage("DatabaseType1"))) {
								ChangeConfigurationControlGUI.this.model
										.setDatabaseTypeStr("txt");
								ChangeConfigurationControlGUI.this.model
										.setDatabaseType(1);
							} else if (newValue.getText().equals(
									AppContext.getMessage("DatabaseType2"))) {
								ChangeConfigurationControlGUI.this.model
										.setDatabaseTypeStr("mysql");
								ChangeConfigurationControlGUI.this.model
										.setDatabaseType(2);
							} else if (newValue.getText().equals(
									AppContext.getMessage("DatabaseType3"))) {
								ChangeConfigurationControlGUI.this.model
										.setDatabaseTypeStr("access");
								ChangeConfigurationControlGUI.this.model
										.setDatabaseType(3);
							} else {
								ChangeConfigurationControlGUI.this.model
										.setDatabaseTypeStr("default");
								ChangeConfigurationControlGUI.this.model
										.setDatabaseType(0);
							}
						}

						ChangeConfigurationControlGUI.this.view
								.updateSaveButton();
					}

				});

		this.view.getLanguageComboBox().valueProperty()
				.addListener(new ChangeListener<Text>() {

					@Override
					public void changed(
							ObservableValue<? extends Text> observable,
							Text oldValue, Text newValue) {

						System.out.println(newValue.getText());
						
						if (!newValue.getText().isEmpty()) {
							ChangeConfigurationControlGUI.this.model
									.setLanguage(newValue.getText());
						}

						ChangeConfigurationControlGUI.this.view
								.updateSaveButton();
					}
				});

		this.view.getStylesheetComboBox().valueProperty()
				.addListener(new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {

						if (!newValue.isEmpty()) {
							ChangeConfigurationControlGUI.this.model
									.setStylesheet(newValue);

							ChangeConfigurationControlGUI.this.view
									.updateSaveButton();
						}
					}

				});

		this.view.getSaveButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				String lang = ChangeConfigurationControlGUI.this.model
						.getLang();
				if (lang.equals(AppContext.getMessage("German"))) {
					lang = "de";
					Config.updateLanguage(new Locale("de"));
				} else if (lang.equals(AppContext.getMessage("English"))) {
					lang = "en";
					Config.updateLanguage(new Locale("en"));
				} else {
					lang = "default";
					Config.updateLanguage(new Locale("en"));
				}

				config.setProperty(DATABASE_KEY,
						ChangeConfigurationControlGUI.this.model
								.getDatabaseName());
				config.setProperty(DATABASE_TYPE_KEY,
						ChangeConfigurationControlGUI.this.model
								.getDatabaseTypeStr());
				config.setProperty(LANGUAGE_KEY, lang);
				config.setProperty(STYLESHEET_KEY,
						ChangeConfigurationControlGUI.this.model
								.getStylesheet());
				try {
					config.store(new FileOutputStream(ini),
							"Travelbasys User Manager - Properties");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				Dao.setDAO(ChangeConfigurationControlGUI.this.model
						.getDatabaseType());
				Dao.getDAO().init((String) Configuration.get("db"));

				Dialogs.showInformationDialog(
						ChangeConfigurationControlGUI.this.view.getStage(),
						"Konfiguration gespeichert.", "Information",
						AppContext.getMessage("TravelbasysManager"));
			}
		});

		this.view.getDatabaseNameField().setText(
				(String) Configuration.get("db"));
		this.view.getDatabaseTypeComboBox().setValue(getDBTypeString());
		this.view.getLanguageComboBox().setValue(getLanguageString());
		this.view.getStylesheetComboBox().setValue(config.get("stylesheet"));

	}

	private Text getLanguageString() {
		if (config.get("lang").equals("en")) {
			languagestr.setText(AppContext.getMessage("English"));
		} else if (config.get("lang").equals("de")) {
			languagestr.setText(AppContext.getMessage("German"));
		} else {
			languagestr.setText("default");
		}
		return languagestr;
	}

	private Text getDBTypeString() {
		int dbtype;
		try {
			dbtype = Integer.parseInt((String) Configuration.get("dbtype"));
		} catch (NumberFormatException e) {
			dbtype = 0;
		}

		switch (dbtype) {
		case 1:
			dbtypestr.setText(AppContext.getMessage("DatabaseType1"));
			break;
		case 2:
			dbtypestr.setText(AppContext.getMessage("DatabaseType2"));
			break;
		case 3:
			dbtypestr.setText(AppContext.getMessage("DatabaseType3"));
			break;
		default:
			dbtypestr.setText("default");
			break;
		}
		return dbtypestr;
	}

	@Override
	public void handleInput(Object value) throws Exception {
	}
}
