import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class HelloWorldFx extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new FlowPane();
		Text helloText= new Text("     Ignore the glass ceiling and \n"
				+ "    do your work. If you’re focusing on the glass ceiling,\n"
				+ " focusing on what you don’t have, focusing on the limitations,\n"
				+ " then you will be limited.");
		helloText.setFont(Font.font("Helvetica",36));
		helloText.setFill(Color.BLUE);
		pane.getChildren().add(helloText);
		Scene scene = new Scene(pane,1500,500,Color.LIGHTBLUE);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello!");
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);

	}

	

}
