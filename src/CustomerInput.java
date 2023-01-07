
import java.io.*;
import java.util.*;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class CustomerInput extends Application {

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

        Scene scene = new Scene(primaryBox, 475, 200, Color.TRANSPARENT);
        primaryStage.setTitle("Customer Data Upload");
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
    	int cOrderNum;
    	int custNum=0;
    	int totalOrder=0;
		try {
			ArrayList<Customer> customers= new ArrayList<>();
			fileScanner = new Scanner(new FileInputStream(file));
			
			while(fileScanner.hasNext()) {
				String line = fileScanner.nextLine();
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(",");
				String cId = lineScan.next();
				if(cId.contains("@")) {
					throw new InvalidCharacterException();
				}
			    cOrderNum= Integer.parseInt(lineScan.next());
				totalOrder+=cOrderNum;
				customers.add(new Customer(cId, cOrderNum));
				custNum++;
				System.out.println(customers);
				statusText.setText("Success, you created "+ custNum );
				resultText.setText("There are " + totalOrder + " Orders succsessfully made.");
				uploadButton.setVisible(false);


			}

			
		} catch (FileNotFoundException | NullPointerException |NumberFormatException |InvalidCharacterException e) {
			statusText.setText("Error : "+e.getMessage() );
			resultText.setText("please try again!");
			uploadButton.setVisible(true);



			
		}

    }

    public static void main(String[] args) {
        launch(args);
    }

}