package experiment.statistik;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Die Klasse startet eine JavaFX Testanwendung.
 * 
 * <p>
 * Sie zeigt ein Fenster mit einem leeren Chart und zwei Buttons. Der "Open"
 * Button zeigt einen Auswahldialog für Dateien. Der "Show" Button stellt die
 * Daten aus der gewählten Datei in einem Liniendiagramm dar.
 * </p>
 * 
 * @author isenbuegel
 * @version 1.0
 */
public class Example1 extends Application {

	private static AnchorPane root;

	/**
	 * Standard Methode, die beim Laden der Klasse von der JVM ausgeführt wird.
	 * 
	 * @param args
	 *            die Parameter von der Kommandozeile.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Standard JavaFX methode: baut das User Interface (UI). Wird automatisch
	 * von der <code>launch</code> Methode gerufen.
	 * 
	 * @param primaryStage
	 *            der Container, in dem das UI erzeugt wird.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = FXMLLoader.getDefaultClassLoader().getResource(
					"experiment/statistik/MainFrame.fxml");
			root = FXMLLoader.load(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		primaryStage.setScene(new Scene(root, 1800, 800));
		primaryStage.show();
	}

	/**
	 * wird ausgeführt, wenn die Anwendung beendet wird.
	 * 
	 * <p>
	 * Schreibt einfach nur "Stopped" nach <b>Standard Output</b> und ruft dann
	 * die Oberklassenmethode.
	 * </p>
	 */
	@Override
	public void stop() throws Exception {
		System.out.println("Stopped");
		super.stop();
	}
}
