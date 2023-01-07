import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;


import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;



public class StreetDriver extends Application  {
//	public static void main(String[]args) {
//		String stName;
//    	String fullName;
//    	int strNum=0;
//	List<SanFransiscoStreet> streets= new ArrayList<>();
//	File file= new File("Street_Names.CSV");
//	 
//	try(Scanner fileScan = new Scanner(new FileReader(file))){
//		
//		while(fileScan.hasNext()) {
//			String line = fileScan.nextLine();
//			Scanner lineScan = new Scanner(line);
//			lineScan.useDelimiter(",");
//			String type = lineScan.next();
//			
//		    stName= lineScan.next();
//			fullName= lineScan.next();
//			
//			streets.add(new SanFransiscoStreet(stName,fullName,type));
//			strNum++;
//			System.out.println(streets);
//			
//			Map<Integer, SanFransiscoStreet> map = new HashMap<>(); 
//			for(int i=0;i< streets.size();i++) {
//				map.put(i, streets.get(i));
//			}
//			System.out.println("Map  : " + map); 
//			System.out.println("San Francisco has "+ strNum+ " total street");//how many streets in san fransico?
////
////
//	} }catch (FileNotFoundException e) {
//		
//		e.printStackTrace();
//	}
//	}
    private Stage primaryStage;
    private Text statusText, resultText;
    private Button uploadButton;

    private final static Font RESULT_FONT = Font.font("Helvetica", 24);
    private final static Font INPUT_FONT = Font.font("Helvetica", 20);

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        VBox primaryBox = new VBox();
        primaryBox.setAlignment(Pos.CENTER);
        primaryBox.setSpacing(20);
        primaryBox.setStyle("-fx-background-color: white");

        VBox uploadBox = new VBox();
        uploadBox.setAlignment(Pos.CENTER);
        uploadBox.setSpacing(20);
        Text uploadLabel = new Text("Upload a comma-separated file with customer data.");
        uploadLabel.setFont(INPUT_FONT);
        uploadButton = new Button("Upload data");
        uploadButton.setOnAction(this::processDataUpload);

        uploadBox.getChildren().add(uploadLabel);
        uploadBox.getChildren().add(uploadButton);
        primaryBox.getChildren().add(uploadBox);

        VBox resultsBox = new VBox();
        resultsBox.setAlignment(Pos.CENTER);
        resultsBox.setSpacing(20);
        statusText = new Text("");
        statusText.setVisible(false);
        statusText.setFont(RESULT_FONT);
        statusText.setFill(Color.RED);
        resultText = new Text("");
        resultText.setVisible(false);
        resultText.setFont(RESULT_FONT);
        resultsBox.getChildren().add(statusText);
        resultsBox.getChildren().add(resultText);
        
        primaryBox.getChildren().add(resultsBox);
        
       
        Scene scene = new Scene(primaryBox,472,200,Color.TRANSPARENT);
        primaryStage.setTitle("Street Data Upload");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void processDataUpload(ActionEvent event) {
        statusText.setVisible(true);
        resultText.setVisible(true);
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(primaryStage);
        parseFile(file);

    }

    private void parseFile(File file) {
    	Scanner fileScanner;
    	String stName;
    	String fullName;
    	int custNum=0;
    	int totalOrder=0;
		try {
			List<SanFransiscoStreet> streets= new ArrayList<>();
			fileScanner = new Scanner(new FileInputStream(file));
			//fileScanner.next();
			while(fileScanner.hasNext()) {
				String line = fileScanner.nextLine();
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(",");
				String type = lineScan.next();
				
			    stName= lineScan.next();
				fullName= lineScan.next();
				
				streets.add(new SanFransiscoStreet(stName,fullName,type));
				custNum++;
				System.out.println(streets);
				statusText.setText("Success, you created "+ custNum );
				resultText.setText("There are " + totalOrder + " Orders succsessfully made.");
				uploadButton.setVisible(false);
				Map<Integer, SanFransiscoStreet> map = new HashMap<>(); 
				for(int i=0;i< streets.size();i++) {
					map.put(i, streets.get(i));
				}
				System.out.println(streets.size()); 


			}

			
		} catch (FileNotFoundException | NullPointerException |NumberFormatException |NoSuchElementException e) {
			statusText.setText("Error : "+e.getMessage() );
			resultText.setText("please try again!");
			uploadButton.setVisible(true);



			
		}

    }

    public static void main(String[] args) {
        launch(args);
    }
}

