

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIImageDisplay extends Application{

	

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox primaryBox= new VBox();
		Image softImage= new Image("images.jfif");
		ImageView softView = new ImageView(softImage);
		primaryBox.getChildren().add(softView);
		Scene scene= new Scene(primaryBox,300,300,Color.AZURE);
		primaryStage.setTitle("GUI Image");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);

	}

}
