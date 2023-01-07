import javafx.application.*;
import javafx.event.*;

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;

import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class GuessNumber extends Application implements EventHandler<ActionEvent> {
	private Text numFieldLabel,resulText;
	private TextField numField;
    private Button calculateButton,clearButton;
    private int num;
    private String high = "Too High ! ", low = "Too Low !";
    GridPane pane;
    TilePane numPane,buttonPane;
	@Override
	public void start(Stage primaryStage) throws Exception {
		num = (int) (Math.random()*(100));
		pane = new GridPane();
		pane.setStyle("-fx-background-color:AQUA");
		pane.setVgap(20);
		pane.setAlignment(Pos.CENTER);
		numFieldLabel =new Text("Guess a Number from 0 to 100:");
		numField = new TextField();
		numField.setAlignment(Pos.CENTER);
		numField.setStyle("-fx-border-color: blue");
		numField.setOnAction(this::handle);
	    numPane= new TilePane(numFieldLabel,numField);
		numPane.setAlignment(Pos.CENTER);
		pane.add(numPane, 0, 0);
		calculateButton =new Button("Guess!");
		calculateButton.setOnAction(this::handle);
		clearButton =new Button("Play again!");
		
		
	    buttonPane =new TilePane(calculateButton,clearButton);
	    clearButton.setOnAction(e->{ primaryStage.close();
        Platform.runLater( () -> {
			try {
				new GuessNumber().start( new Stage() );
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		} );});
		buttonPane.setAlignment(Pos.CENTER);
		pane.add(buttonPane, 0, 4);
		
		resulText = new Text("");
		 VBox vbox = new VBox(resulText);
		resulText.setTextAlignment(TextAlignment.CENTER);
		resulText.setFont(Font.font(28));
		resulText.setFill(Color.PURPLE);
		resulText.setTextOrigin(VPos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		
		//resulText.;
		
		pane.add(vbox, 0, 2);
		
		
		Scene scene = new Scene(pane,500,300,Color.TRANSPARENT);
		primaryStage.setTitle("Guess!");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	@Override
	public void handle(ActionEvent event) {
		if(!(numField.getText().isEmpty())) {
			try {
		int userNum = Integer.parseInt(numField.getText());
			
		
		if(userNum==num) {
			numPane.getChildren().remove(numField);
			clearButton.setText("You Want to play again");
			
			buttonPane.getChildren().remove(calculateButton);
			
			pane.setStyle("-fx-background-image: url('winner.gif');" 
					+ "               -fx-background-position: center center;"
					+ "               -fx-background-repeat: stretch;");
			resulText.setText("");

			numFieldLabel.setText("");
			
			
		}else if(userNum>num) {
			resulText.setText(high);
			resulText.setStroke(Color.RED);
			
		}else if(userNum < num) {
			resulText.setText(low);
			resulText.setStroke(Color.ORANGE);
		}
		numField.clear();
			}catch (NumberFormatException e) {
				resulText.setText("Not A Number !");
			}
		
		}else {
			resulText.setText("Error: Not a number");
		}
	}
		
	
	
	public static void main(String args[]) {
		launch(args);
	}
	

}
