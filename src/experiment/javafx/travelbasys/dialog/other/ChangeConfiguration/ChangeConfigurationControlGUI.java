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

	@SuppressWarnings("unchecked")
	public void init(Model model, View view) {
		this.view = (ChangeConfigurationViewGUI) view;
		this.model = (ChangeConfigurationModelGUI) model;

		final Properties config = new Properties();
		try {
			config.load(new FileInputStream(ini));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

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
				.addListener(new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						String dbtypestr = newValue;
						if (dbtypestr.equals(AppContext
								.getMessage("DatabaseType1"))) {
							ChangeConfigurationControlGUI.this.model
									.setDatabaseTypeStr("txt");
							ChangeConfigurationControlGUI.this.model
									.setDatabaseType(1);
						} else if (dbtypestr.equals(AppContext
								.getMessage("DatabaseType2"))) {
							ChangeConfigurationControlGUI.this.model
									.setDatabaseTypeStr("mysql");
							ChangeConfigurationControlGUI.this.model
									.setDatabaseType(2);
						} else if (dbtypestr.equals(AppContext
								.getMessage("DatabaseType3"))) {
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

						ChangeConfigurationControlGUI.this.view
								.updateSaveButton();
					}
				});

		this.view.getLanguageComboBox().valueProperty()
				.addListener(new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {

						ChangeConfigurationControlGUI.this.model
								.setLanguage(newValue);

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

						ChangeConfigurationControlGUI.this.model
								.setStylesheet(newValue);

						ChangeConfigurationControlGUI.this.view
								.updateSaveButton();
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

	private String getLanguageString() {
		String languagestr;
		if (Locale.getDefault().toString().equals("en")) {
			languagestr = AppContext.getMessage("English");
		} else if (Locale.getDefault().toString().equals("de")) {
			languagestr = AppContext.getMessage("German");
		} else {
			languagestr = "default";
		}
		return languagestr;
	}

	private String getDBTypeString() {
		int dbtype;
		String dbtypestr;
		try {
			dbtype = Integer.parseInt((String) Configuration.get("dbtype"));
		} catch (NumberFormatException e) {
			dbtype = 0;
		}

		switch (dbtype) {
		case 1:
			dbtypestr = AppContext.getMessage("DatabaseType1");
			break;
		case 2:
			dbtypestr = AppContext.getMessage("DatabaseType2");
			break;
		case 3:
			dbtypestr = AppContext.getMessage("DatabaseType3");
			break;
		default:
			dbtypestr = "default";
			break;
		}
		return dbtypestr;
	}

	@Override
	public void handleInput(Object value) throws Exception {
	}
}
