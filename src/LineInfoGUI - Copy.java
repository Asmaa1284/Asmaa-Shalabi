import javafx.application.*;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;
import java.time.*;
import java.time.format.*;

public class LineInfoGUI extends Application {

    private Pane pane;
    private BorderPane borderPane;
    private Circle startPoint, endPoint;
    private Line line;
    private Button distanceButton, midpointButton, vertHorzButton;
    private Text distanceText, midpointText, vertHorzText, timeText; // USE THESE!
    private LineInfoDisplayer lineInfoDisplayer; // USE THIS!

    private static final int CIRCLE_RADIUS = 5;

    public void start(Stage primaryStage) {
        borderPane = new BorderPane();

        pane = new Pane();
        pane.setOnMouseClicked(this::handleMouseClicks);
        borderPane.setCenter(pane);

        distanceText = new Text("");
        distanceButton = new Button("Calculate Distance");
        // YOUR CODE HERE- ADD A STATEMENT TO SET THE ACTION OF THE BUTTON.   
        // USE A LAMBDA TO ASSIGN A VALUE TO lineInfoDisplayer AND
        // USE OBJECT TO GET THE STRING DESCRIBING THE DISTANCE.
        // UPDATE THE TEXT OBJECT TO DISPLAY THAT INFO.
        distanceButton.setOnAction(event -> {
        	lineInfoDisplayer= LineInfoDisplayer.createLineInfoDisplayer(LineInfoDisplayer.InfoType.DISTANCE);
        	try {
        	String string= lineInfoDisplayer.getInfo(line);
        	
        	distanceText.setText(string);
        
        	
        	}catch (NullPointerException e) {
        		distanceText.setText("Draw your Line First !");
			}
        	
        
        });
         
           
       

        midpointText = new Text("");
        midpointButton = new Button("Calculate Midpoint");
        // YOUR CODE HERE- ADD A STATEMENT TO SET THE ACTION OF THE BUTTON.     
        // SAME AS ABOVE BUT FOR MIDPOINT!
        midpointButton.setOnAction(event ->{
        lineInfoDisplayer= LineInfoDisplayer.createLineInfoDisplayer(LineInfoDisplayer.InfoType.MIDPOINT);
        try {
        	String string= lineInfoDisplayer.getInfo(line);
        	
        	midpointText.setText(string);
        
        	
        	}catch (NullPointerException e) {
        		midpointText.setText("enter your data!");
			}
        }
    
        );
        
        
        vertHorzText = new Text("");
        vertHorzButton = new Button("Determine Vertical/Horizontal");
        // YOUR CODE HERE- ADD A STATEMENT TO SET THE ACTION OF THE BUTTON.
        // SAME AS ABOVE BUT FOR VERTICAL/HORIZONTAL!
        vertHorzButton.setOnAction(event ->{
            lineInfoDisplayer= LineInfoDisplayer.createLineInfoDisplayer(LineInfoDisplayer.InfoType.VERT_HORZ);
            try {
            	String string= lineInfoDisplayer.getInfo(line);
            	
            	vertHorzText.setText(string);
            	
            
            	
            	}catch (NullPointerException e) {
            		vertHorzText.setText("enter your data!");
    			}
            }
        
            );

        
        timeText = new Text("");
        // SOMEWHERE IN THE CODE YOU WILL UPDATE THE TEXT OF THIS!
        
     
        TilePane distancePane = new TilePane(distanceButton, distanceText);
        distancePane.setAlignment(Pos.CENTER);
        TilePane midpointPane = new TilePane(midpointButton, midpointText);
        midpointPane.setAlignment(Pos.CENTER);
        TilePane vertHorzPane = new TilePane(vertHorzButton, vertHorzText);
        vertHorzPane.setAlignment(Pos.CENTER);
        TilePane timePane = new TilePane(timeText);
        timePane.setAlignment(Pos.CENTER);

        VBox controlBox = new VBox(distancePane,midpointPane,vertHorzPane,timePane);
        controlBox.setAlignment(Pos.CENTER);
        controlBox.setSpacing(15);

        borderPane.setBottom(controlBox);

        Scene scene = new Scene(borderPane, 500, 500, Color.WHITE);
        primaryStage.setTitle("Line Information");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleMouseClicks(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        
        if(startPoint==null ) { // no start point yet, set the start point
            startPoint = new Circle(x,y,CIRCLE_RADIUS);
            pane.getChildren().add(startPoint);
            createCoordinates(x,y);
            line = null;
        } else if(endPoint==null) { // start point, but not end point yet
        							// set the end point
            endPoint = new Circle(x,y,CIRCLE_RADIUS);
            pane.getChildren().add(endPoint);
            createCoordinates(x,y);
            
            line = new Line(startPoint.getCenterX(), startPoint.getCenterY(), endPoint.getCenterX(), endPoint.getCenterY());
            pane.getChildren().add(line);
            DateTimeFormatter outputFormatter= DateTimeFormatter.ofPattern("hh:mm a");
            LocalDateTime todayDate= LocalDateTime.now();
            timeText.setText(todayDate.format(outputFormatter));
                        
        } else { // startPoint != null && endPoint !=null
        	// both start and end are there, so this is starting a new line; 
        	// set a new start point
            pane.getChildren().clear();
            endPoint = null;
            line = null;
            distanceText.setText("");
            midpointText.setText(""); 
            vertHorzText.setText("");
            
            startPoint = new Circle(x,y,CIRCLE_RADIUS);
            pane.getChildren().add(startPoint);        
            createCoordinates(x,y);
        }
    }
    
    private void createCoordinates(double x, double y) {
        String coordinateString = "(" + x + ", " + y + ")";
        Text coordinates = new Text(x-CIRCLE_RADIUS, y-CIRCLE_RADIUS-2, coordinateString);
        pane.getChildren().add(coordinates);
    }
  

    public static void main(String[] args) {
        launch(args);
    }

}
