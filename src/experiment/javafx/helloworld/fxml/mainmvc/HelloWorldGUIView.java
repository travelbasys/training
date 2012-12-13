package experiment.javafx.helloworld.fxml.mainmvc;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

public class HelloWorldGUIView implements View {
	private Stage stage;
	private Scene scene;
	private HelloWorldGUIModel model;

	public HelloWorldGUIView(Model model, Stage stage) {
		this.model = (HelloWorldGUIModel) model;
		this.stage = stage;
	}

	@Override
	public void run() {
		stage.show();
	}

	public void init() {
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource(
					"/helloworld/main/Sample.fxml"));
			scene = new Scene(root);
			((Button) getNode("#changeButton")).setDisable(true);
			((Button) getNode("#changeButton")).setDefaultButton(true);
			stage.setScene(scene);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Node getNode(String cssRef) {
		return scene.lookup(cssRef);
	}

	public void update() {
		((Button) getNode("#changeButton")).setDisable(model.isInvalid());
	}

}
