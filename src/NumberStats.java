import java.util.ArrayList;
import java.util.Collections;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;

import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class NumberStats extends Application {
   private Text numFieldLabel;
   private TextField numField;
   private Button calculateButton,clearButton;
   private Text resultText;
   private ArrayList<Integer> numList;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		numList = new ArrayList<>();
		GridPane pane = new GridPane();
		pane.setStyle("-fx-background-color:AQUA");
		pane.setVgap(20);
		pane.setAlignment(Pos.CENTER);
		
		numFieldLabel =new Text("Enter a Number:");
		numField = new TextField();
		numField.setOnAction(this::processNumberTextField);
		TilePane numPane= new TilePane(numFieldLabel,numField);
		pane.add(numPane, 0, 0);
		
		calculateButton =new Button("Calculate!");
		calculateButton.setOnAction(this::calculateHandler);
		clearButton =new Button("Clear!");
		TilePane buttonPane =new TilePane(calculateButton,clearButton);
		pane.add(buttonPane, 0, 1);
		
		resultText = new Text("");
		pane.add(resultText, 0, 2);
		
		
		
		
		Scene scene= new Scene(pane,300,300);
		primaryStage.setTitle("Number Stats");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	private void calculateHandler(ActionEvent event) {
		if(numList.isEmpty()) {
		int total=0,min,max;
		double ave;
		for(int n: numList) {
			total+=n;
		}
		ave= ((double)total)/numList.size();
		min= Collections.min(numList);
		max=Collections.max(numList);
		String resultString="Min = "+min+" \n"+
		"Max = "+ max+"\n"+ " total = "+total+"\n"+
				" average = "+ave;
		resultText.setText(resultString);
		}else {
			resultText.setText("Eroor: empty list");
		}
	}
	
	private void processNumberTextField(ActionEvent event) {
		try {
		int userNum = Integer.parseInt(numField.getText());
		numList.add(userNum);
		resultText.setText("");
		}catch(NumberFormatException ex) {
			resultText.setText("Error: Not a number");
			
		}finally {
		numField.clear();
	}
	}
	public static void main(String[] args) {
		launch(args);

	}

}
