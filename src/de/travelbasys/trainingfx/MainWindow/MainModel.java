package de.travelbasys.trainingfx.MainWindow;

import java.util.HashSet;
import java.util.Set;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Model;

public class MainModel implements Model {

	private Stage primaryStage;
	private Pane pane;
	private Set<Integer> numbers = new HashSet<Integer>();

	private double percent;

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Pane getPane() {
		return pane;
	}

	public void setPane(Pane pane) {
		this.pane = pane;
	}

	public void setNumbers(Set<Integer> numbers) {
		this.numbers = numbers;
	}

	public Set<Integer> getNumbers() {
		return numbers;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public double getPercent() {
		return percent;
	}
}
