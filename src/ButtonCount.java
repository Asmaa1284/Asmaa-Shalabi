import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class ButtonCount extends Application {
	private Button button;
	private Text buttonCountText;
	private int count;
	private Scene scene;
	@Override
	public void start(Stage primaryStage) throws Exception {
		count=0;
		Pane pane = new FlowPane();
		button = new Button("Click me!");
		pane.setStyle("-fx-background-color: null;");
		button.setOnAction(this::handleButton);
		pane.getChildren().add(button);
		buttonCountText = new Text("Count:0");
		
		buttonCountText.setFont(Font.font(28));
		
		pane.getChildren().add(buttonCountText);
	   scene = new Scene(pane,300,300);
	   scene.setFill(Color.PINK);
		primaryStage.setTitle("Button Clicks count");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	private void handleButton(ActionEvent event) {
		count++;
		if(count%5==0) {
	
			scene.setFill(Color.color(Math.random(),Math.random(),Math.random()));
		}
		buttonCountText.setText("Count: "+ count);
	}
	public static void main(String[] args) {
		launch(args);

	}

	

}
