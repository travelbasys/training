package experiment.hostStatistik;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

public class MainController {

	@FXML
	private static Button button;
	@FXML
	private static Button openButton;
	@FXML
	private static LineChart<String, Integer> lineChart;
	@FXML
	private static CategoryAxis categoryAxis;
	@FXML
	private static NumberAxis numberAxis;
	private static ArrayList<ReportRecord> reportRecords;

	@FXML
	private static void openFile() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"CSV files (*.csv)", "*.csv");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show open file dialog
		File inputFile = fileChooser.showOpenDialog(null);

		System.out.println(inputFile);

		// Datei lesen

		try {
			@SuppressWarnings("deprecation")
			URL url = inputFile.toURL();

			BetterBufferedReader reader = new BetterBufferedReader(
					new InputStreamReader(url.openStream()));

			reportRecords = new ArrayList<ReportRecord>();
			StringTokenizer st = null;
			String line;

			// The first line contains the column names. We must skip it.
			reader.skipLines(1);
			while ((line = reader.readLine()) != null) {
				ReportRecord rr = new ReportRecord();
				st = new StringTokenizer(line, ";");

				rr.d = st.nextToken();
				rr.menu = st.nextToken();
				rr.menuTyp = st.nextToken();
				rr.menuText = st.nextToken();
				rr.stunde = st.nextToken();
				rr.anzStunde = new Integer(st.nextToken());
				reportRecords.add(rr);
			}
			reader.close();
		} catch (IOException io) {
		}
	}

	@SuppressWarnings("unchecked")
	@FXML
	private static void handleButton() {

		XYChart.Series<String, Integer> seriesRBSweb = new XYChart.Series<String, Integer>();
		XYChart.Series<String, Integer> seriesWebService = new XYChart.Series<String, Integer>();

		int anzStundeRBSweb = 0;
		int anzStundeWebService = 0;
		String d = null;
		int b = 0;
		for (ReportRecord rr : reportRecords) {

			if (rr.d.equals(d)) {
				b++;
				if (rr.menuTyp.equals("webService")) {
					anzStundeWebService = anzStundeWebService + rr.anzStunde;
				}

				else {
					anzStundeRBSweb = anzStundeRBSweb + rr.anzStunde;
				}
				System.out.println(anzStundeRBSweb);
				System.out.println(anzStundeWebService);
				continue;

			} else {

				if (d != null) {
					Data<String, Integer> objRBSweb = new XYChart.Data<String, Integer>(
							d, anzStundeRBSweb);
					Data<String, Integer> objWebService = new XYChart.Data<String, Integer>(
							d, anzStundeWebService);

					anzStundeRBSweb = 0;
					anzStundeWebService = 0;

					seriesRBSweb.getData().add(objRBSweb);
					seriesWebService.getData().add(objWebService);
				}

				d = rr.d;

			}
		}
		lineChart.getData().addAll(seriesRBSweb, seriesWebService);
	}
}
