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

						int dbtype = (ChangeConfigurationControlGUI.this.view
								.getDatabaseTypeComboBox().getSelectionModel()
								.getSelectedIndex() + 1);

						if (!newValue.getText().isEmpty()) {
							ChangeConfigurationControlGUI.this.model
									.setDatabaseType(dbtype);
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

				int t = 0;
				t = ChangeConfigurationControlGUI.this.view
						.getLanguageComboBox().getSelectionModel()
						.getSelectedIndex();

				switch (t) {
				case 0:
					lang = "en";
					break;
				case 1:
					lang = "de";
					break;
				default:
					lang = "en";
					break;
				}

				Config.updateLanguage(new Locale(lang));

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
		setConfigDBTypeString();
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

	private void setConfigDBTypeString() {
		int dbtype;
		try {
			dbtype = Integer.parseInt((String) Configuration.get("dbtype"));
		} catch (NumberFormatException e) {
			dbtype = 0;
		}

		switch (dbtype) {
		case 1:
			ChangeConfigurationControlGUI.this.view.getDatabaseTypeComboBox()
					.getSelectionModel().select(0);
			break;
		case 2:
			ChangeConfigurationControlGUI.this.view.getDatabaseTypeComboBox()
					.getSelectionModel().select(1);
			break;
		case 3:
			ChangeConfigurationControlGUI.this.view.getDatabaseTypeComboBox()
					.getSelectionModel().select(2);
			break;
		default:
			ChangeConfigurationControlGUI.this.view.getDatabaseTypeComboBox()
					.getSelectionModel().select(0);
			break;
		}
	}

	@Override
	public void handleInput(Object value) throws Exception {
	}
}
