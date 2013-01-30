package experiment.hostStatistik;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;

public class MainController0 {

	@FXML
	private static Button button;
	@FXML
	private static LineChart<String,Integer> lineChart;
	@FXML
	private static CategoryAxis categoryAxis;
	@FXML
	private static NumberAxis numberAxis;

	private static int a = 0;
	
	
	@FXML
	private static void handleButton() {

		lineChart.getData().clear();

		XYChart.Series<String,Integer> series = new XYChart.Series<String,Integer>();
		
		int[] data = new int[10];
		for (int i = 0; i < data.length; i++) {
			data[i] = a * a * a * a;
			a++;
			series.getData().add(new XYChart.Data<String,Integer>(String.valueOf(i), data[i]));
		}

		lineChart.getData().add(series);

		a = a - 9;
		categoryAxis.setLabel("x-Werte");
		numberAxis.setLabel("y-Werte");
	}
}