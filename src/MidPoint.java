import javafx.scene.shape.Line;

public class MidPoint implements LineInfoDisplayer {
	double x,y;
    String midPointString;
	@Override
	public String getInfo(Line line) {
		x= (line.getEndX()+line.getStartX())/2;
		y= (line.getEndY()+line.getStartY())/2;
		midPointString= "( "+x+","+y+" )";
		
		return midPointString;
	}

}
