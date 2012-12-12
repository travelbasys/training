package experiment.javafx.helloworld;

/**
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * A sample that shows both an un-editable and an editable ComboBox.
 * 
 * @see javafx.scene.control.ComboBox
 * @see javafx.scene.control.ComboBoxBuilder
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ComboBoxSample extends Application {

	private final ObservableList strings = FXCollections.observableArrayList(
			"Option 1", "Option 2", "Option 3", "Option 4", "Option 5",
			"Option 6", "Longer ComboBox item", "Option 7", "Option 8",
			"Option 9", "Option 10", "Option 12");

	private final ObservableList<Text> texts = FXCollections
			.observableArrayList(new Text("abc"), new Text("efg"));

	private void init(Stage primaryStage) {
		Group root = new Group();
		primaryStage.setScene(new Scene(root));

		ComboBox<Text> box = new ComboBox<Text>();
		box.getItems().addAll(texts);

		ComboBox box2 = new ComboBox();
		box2.getItems().addAll(new Text("abc"), new Text("efg"),
				new Text("jdk"));

		HBox hbox = HBoxBuilder.create().alignment(Pos.CENTER).spacing(15)
				.build();

		// Non-editable combobox. Created with a builder
		ComboBox uneditableComboBox = ComboBoxBuilder
				.create()
				.id("uneditable-combobox")
				.promptText("Make a choice...")
				.items(FXCollections.observableArrayList(strings.subList(0, 8)))
				.build();

		// Editable combobox. Use the default item display length
		ComboBox<String> editableComboBox = new ComboBox<String>();
		editableComboBox.setId("second-editable");
		editableComboBox.setPromptText("Edit or Choose...");
		editableComboBox.setItems(strings);
		editableComboBox.setEditable(true);

		hbox.getChildren().addAll(uneditableComboBox, editableComboBox, box,
				box2);
		root.getChildren().add(hbox);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		init(primaryStage);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
