

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;

import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class IncDecButtons extends Application {
   private Text counterText;
   private Button incButton,deButton;
   private int counter,interval;
   private TextField intervalField;
   private Text intervalFieldLabelText;

	@Override
	public void start(Stage primaryStage) throws Exception {
		counter=0;
		interval=1;
		VBox mainBox= new VBox();
		mainBox.setStyle("-fx-background-color:cyan");
		mainBox.setAlignment(Pos.CENTER);
		mainBox.setSpacing(10);
		counterText = new Text("0");
		counterText.setFont(Font.font("Helvetica",28));
		counterText.setFill(Color.BLACK);
		mainBox.getChildren().add(counterText);
		incButton = new Button("+");
		incButton.setOnAction(this::handleButton);
		deButton = new Button("-");
		deButton.setOnAction(this::handleButton);
		HBox buttonBox= new HBox(incButton,deButton);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(10);
		mainBox.getChildren().add(buttonBox);
		intervalFieldLabelText = new Text("interval : ");
		intervalField = new TextField("1");
		intervalField.setOnAction(this::processTextField);
		HBox intervalBox = new HBox(intervalFieldLabelText,intervalField);
		intervalBox.setAlignment(Pos.CENTER);
		mainBox.getChildren().add(intervalBox);
		intervalBox.setSpacing(10);
		Scene scene = new Scene(mainBox,200,200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello");
		primaryStage.show();
		
	}
	private void processTextField(ActionEvent event) {
		interval = Integer.parseInt(intervalField.getText());
	}
	private void handleButton(ActionEvent event) {
		if (event.getSource()==incButton) {
			counter+= interval;
		}else if (event.getSource()==deButton) {
			counter-=interval;
		}
		counterText.setText(Integer.toString(counter));
	}
	public static void main(String[] args) {
		launch(args);

	}

}
