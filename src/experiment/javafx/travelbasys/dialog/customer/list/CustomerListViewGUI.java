package experiment.javafx.travelbasys.dialog.customer.list;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import de.travelbasys.training.framework.View;
import experiment.javafx.travelbasys.CreateCustomerTableView;

public class CustomerListViewGUI implements View {

	private CustomerListModelGUI model;

	public CustomerListViewGUI(CustomerListModelGUI model) {
		this.model = (CustomerListModelGUI) model;
	}

	@Override
	public void run() {
		new EventHandler<ActionEvent>() {
			
		
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void handle(ActionEvent arg0) {
				// Erstelle Referenz zu Tabelle und fülle mit Daten
				TableView table;
				table = new CreateCustomerTableView().getTable();
				table.setItems(model.getData());
				// Erstellen Node (VBox) für Platzierung der Tabelle
				VBox vbox = new VBox();
				vbox.setSpacing(5);
				vbox.setPadding(new Insets(10, 10, 10, 10));
				// Platziere Tabelle in der VBox
				vbox.getChildren().addAll(table);
				// Aktualisiere Bildbereich mit der VBox
				model.getRoot().setCenter(vbox);				
			}};
		

}}