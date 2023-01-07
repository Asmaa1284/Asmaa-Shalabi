import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;

public class imageTransformation extends Application{

	

	@Override
	public void start(Stage primaryStage) throws Exception {
		int startX=100,startY=100,length=200,width=50;
		Group group =new Group();
		for(int i=0; i<10;i++) {
			Rectangle rect= new Rectangle(startX,startY,length,width);
			rect.setTranslateX(i*10);
			rect.setTranslateY(i*10);
			rect.setFill(Color.TRANSPARENT);
			rect.setStroke(Color.BLACK);
			group.getChildren().add(rect);
			
		}
		Scene scene= new Scene(group,200,200,Color.AQUA);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Transfomations");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);

	}

}
