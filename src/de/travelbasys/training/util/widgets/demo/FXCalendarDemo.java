package de.travelbasys.training.util.widgets.demo;

import java.util.Locale;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import de.travelbasys.training.util.widgets.FXCalendar;
import de.travelbasys.training.util.widgets.FXCalendarUtility;

public class FXCalendarDemo extends Application {

	private Stage stage;
	private Scene scene;
	private BorderPane root;
	private VBox center;
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(final Stage stage) throws Exception {
		this.stage = stage;
		configureScene();
		configureStage();
		configureHeader();
		configureFooter();
		configureCenter();
		
		int i=1;
		configureSimpleDate(i++);
		configureDefaultDate(i++);
		configureWeekNumber(i++);
		configureLocaleCalendar(i++);
		configureCalendarTheme(i++);
		
	}

	private void configureStage(){
		stage.setTitle("FX Calendar Demo");
		stage.setX(0);
	    stage.setY(0);
	    stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
	    stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
	    stage.setScene(this.scene);
	    stage.show();
	}
	
	private void configureScene(){
		root = new BorderPane();
		root.autosize();	
	    this.scene = new Scene(root, Color.LINEN);
	    loadStyleSheet(scene);
	}

	private final void loadStyleSheet(Scene scene){
		scene.getStylesheets().add(FXCalendarDemo.class.getResource("/de/travelbasys/training/util/widgets/styles/calendar_styles.css").toExternalForm());
	}
	
	private void configureHeader(){
		StackPane sp = new StackPane();
		sp.setPrefHeight(100);
		sp.setAlignment(Pos.TOP_LEFT);
		sp.setStyle("-fx-background-color: linear-gradient(to bottom, #7A7A7A 0%, #333333 100%);-fx-opacity:.8;-fx-border-width: 0 0 2px 0;-fx-border-color: #868686;");
		
		Label header = new Label("JavaFX 2 .0 Calendar");
		header.setTextFill(Color.BEIGE);
		header.setTranslateX(10);
		header.setStyle("-fx-font-size:40;");
		header.setTranslateY(25);
		
		sp.getChildren().addAll(header);
		root.setTop(sp);
	}
	
	private void configureFooter(){
		StackPane sp = new StackPane();
		sp.setPrefHeight(20);
		sp.setAlignment(Pos.CENTER);
		sp.setStyle("-fx-background-color: linear-gradient(to bottom, #7A7A7A 0%, #333333 100%);-fx-opacity:.8;-fx-border-width: 2px 0 0 0;-fx-border-color: #6D6B69;");
		
		root.setBottom(sp);
	}
	
	private void configureCenter(){
		ScrollPane sp = new ScrollPane();
		sp.getStyleClass().add("centerBG");
		center = new VBox();
		center.setPadding(new Insets(10));
		center.setSpacing(25);
		
		sp.setContent(center);
		root.setCenter(sp);
	}
	
	private void configureSimpleDate(int i) {
		VBox vb = new VBox();
		vb.setSpacing(10);
		FeatureHeader header = new FeatureHeader("#"+i+" : Simple Calendar Control");
		FeatureLabel lbl = new FeatureLabel("Select the date : ");
		
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.getChildren().addAll(lbl, new FXCalendar());
		
		vb.getChildren().addAll(header,hb);
		center.getChildren().add(vb);
	}

	private void configureDefaultDate(int i) {
		VBox vb = new VBox();
		vb.setSpacing(10);
		FeatureHeader header = new FeatureHeader("#"+i+" : Calendar Control with Default date and Custom width");
		FeatureLabel lbl = new FeatureLabel("Select the date : ");
		final FXCalendar calendar = new FXCalendar();
		calendar.setValue(new FXCalendarUtility().convertStringtoDate("02/02/2001"));
		
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.getChildren().addAll(lbl, calendar);
		
		final FeatureLabel lbl2 = new FeatureLabel("");
		Button btn = new Button("Show Selected date");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				lbl2.setText( calendar.getValue().toString() );
			}
		});
		
		HBox hb1 = new HBox();
		hb1.setSpacing(10);
		hb1.getChildren().addAll(btn, lbl2);
		
		
		vb.getChildren().addAll(header,hb,hb1);
		center.getChildren().add(vb);
	}
	
	private void configureWeekNumber(int i) {
		VBox vb = new VBox();
		vb.setSpacing(10);
		FeatureHeader header = new FeatureHeader("#"+i+" : Calendar Control with Week Number display");
		FeatureLabel lbl = new FeatureLabel("Select the date : ");
		FXCalendar calendar = new FXCalendar();
		calendar.setShowWeekNumber(true);
		calendar.setValue(new FXCalendarUtility().convertStringtoDate("02/02/0001"));
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.getChildren().addAll(lbl, calendar);
		
		vb.getChildren().addAll(header,hb);
		center.getChildren().add(vb);
	}

	private void configureLocaleCalendar(int i) {
		VBox vb = new VBox();
		vb.setSpacing(10);
		FeatureHeader header = new FeatureHeader("#"+i+" : Calendar Control with Locale specific");
		FeatureLabel lbl1 = new FeatureLabel("Select the language : ");
		FeatureLabel lbl2 = new FeatureLabel("Select the date : ");
		final FXCalendar calendar = new FXCalendar();
		calendar.setLocale(Locale.ENGLISH);
		
		ObservableList<String> list = FXCollections.observableArrayList("English", "French", "Dutch");
		final ChoiceBox<String> cb = new ChoiceBox<String>( list);
		cb.getSelectionModel().select(0);
		cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue arg0, Number arg1, Number arg2) {
				if(arg2.intValue()==0){
					calendar.setLocale(Locale.ENGLISH);
				}else if(arg2.intValue()==1){
					calendar.setLocale(Locale.FRENCH);
				}else {
					calendar.setLocale(new Locale("nl","BE"));
				}
			}
		});
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.getChildren().addAll(lbl1, cb);
		
		HBox hb1 = new HBox();
		hb1.setSpacing(10);
		hb1.getChildren().addAll(lbl2, calendar);
		
		vb.getChildren().addAll(header,hb,hb1);
		center.getChildren().add(vb);
	}
	
	private void configureCalendarTheme(int i) {
		VBox vb = new VBox();
		vb.setSpacing(10);
		FeatureHeader header = new FeatureHeader("#"+i+" : Calendar Control with different Themes");
		
		FeatureLabel lbl1 = new FeatureLabel("Select the language ( Red Theme ): ");
		final FXCalendar calendar1 = new FXCalendar();
		calendar1.setBaseColor(Color.web("#940C02"));
		
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.getChildren().addAll(lbl1, calendar1);
		
		FeatureLabel lbl2 = new FeatureLabel("Select the date ( Black Theme ) : ");
		final FXCalendar calendar2 = new FXCalendar();
		calendar2.setBaseColor(Color.BLACK);
		
		HBox hb1 = new HBox();
		hb1.setSpacing(10);
		hb1.getChildren().addAll(lbl2, calendar2);
		
		vb.getChildren().addAll(header,hb,hb1);
		center.getChildren().add(vb);
	}
	
}

class FeatureHeader extends Label{
	public FeatureHeader(String str){
		super(str);
		setStyle("-fx-font-weight :bold;-fx-font-size: 16px;-fx-font-family: verdana,arial,helvetica,tahoma,sans-serif;");
	}
}

class FeatureLabel extends Label{
	public FeatureLabel(String str){
		super(str);
		setStyle("-fx-font-size: 12px;-fx-font-family: verdana,arial,helvetica,tahoma,sans-serif;");
	}
}



