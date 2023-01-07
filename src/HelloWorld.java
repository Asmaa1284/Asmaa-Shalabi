import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class HelloWorld extends Application {
	private Button button;
	private Text helloText;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new FlowPane();
	    helloText= new Text("     Ignore the glass ceiling and \n"
				+ "    do your work. If you’re focusing on the glass ceiling,\n"
				+ " focusing on what you don’t have, focusing on the limitations,\n"
				+ " then you will be limited.");
		helloText.setFont(Font.font("Helvetica",36));
		helloText.setFill(Color.BLUE);
		pane.getChildren().add(helloText);
		button = new Button("Click Here!");
		button.setOnAction(this::handleButton);
		pane.getChildren().add(button);
		Scene scene = new Scene(pane,1500,500,Color.LIGHTBLUE);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello!");
		primaryStage.show();
		
	}
	private void handleButton(ActionEvent event) {
		helloText.setText("You clicked!");
		helloText.setFont(Font.font("Helvetica",50));
		button.setDisable(true);
	}
	public static void main(String[] args) {
		launch(args);

	}
}

	
