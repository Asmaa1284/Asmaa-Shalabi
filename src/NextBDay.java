import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class NextBDay extends Application implements EventHandler<ActionEvent>{
	private Text numFieldLabel,resulText;
	private TextField numField;
    private Button calculateButton,clearButton;
    private int num;
    GridPane pane;
    TilePane numPane,buttonPane;
	@Override
	public void handle(ActionEvent event) {
		if(!(numField.getText().isEmpty()))
				{
			try {
			String birthdayString= numField.getText();
			DateTimeFormatter outputFormatter= DateTimeFormatter.ofPattern("LL-dd-yyy");
			LocalDate birthDate= LocalDate.parse(birthdayString,outputFormatter);
			LocalDate today= LocalDate.now();
			
			System.out.println(today);
			System.out.println(birthDate);
			
			Period agePeriod= Period.between( today,birthDate);
			System.out.println(agePeriod);
			Long birthday= agePeriod.get(ChronoUnit.DAYS);
			
			
			Long age= ChronoUnit.YEARS.between(birthDate,today);
			
			System.out.println("you are "+ age+ " years old");
			numPane.getChildren().remove(numField);
			
			buttonPane.getChildren().remove(calculateButton);
			buttonPane.getChildren().remove(clearButton);
			
			pane.setStyle("-fx-background-color: AQUA;" 
					+ "               -fx-background-position: center center;"
					+ "               -fx-background-repeat: stretch;");
			
			resulText.setText("you are "+ age+ " years old \nand your next bithday in "+ birthday+" days");
				
			numFieldLabel.setText("");
				
				}catch(DateTimeParseException ex) {
					resulText.setText("Try again");
				}
				}
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		pane = new GridPane();
		pane.setStyle("-fx-background-color:Pink");
		pane.setVgap(20);
		pane.setAlignment(Pos.CENTER);
		numFieldLabel =new Text("Enter your Birthday:\n Ex: 12-25-2010");
		numField = new TextField();
		numField.setAlignment(Pos.CENTER);
		numField.setStyle("-fx-border-color: blue");
		numField.setOnAction(this::handle);
	    numPane= new TilePane(numFieldLabel,numField);
		numPane.setAlignment(Pos.CENTER);
		pane.add(numPane, 0, 0);
		calculateButton =new Button("Enter");
		calculateButton.setOnAction(this::handle);
		clearButton =new Button("Try another Birthday!");
		
		
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
		
		
		
		pane.add(vbox, 0, 2);
		
		
		Scene scene = new Scene(pane,500,300,Color.TRANSPARENT);
		primaryStage.setTitle("Next Birthday!");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	public static void main(String args[]) {
		launch(args);
	}

}
