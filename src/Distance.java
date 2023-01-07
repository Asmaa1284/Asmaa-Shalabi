import javafx.scene.shape.Line;

public class Distance implements LineInfoDisplayer{
    double x1,x2,y1,y2;
    String distanceString;
    
	public Distance(double x1, double x2, double y1, double y2) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

	public String getDistanceString() {
		return distanceString;
	}

	public void setDistanceString(String distanceString) {
		this.distanceString = distanceString;
	}

	@Override
	public String getInfo(Line line) {
		x1=line.getStartX();
		x2= line.getEndX();
		y1 = line.getStartY();
		y2= line.getEndY();
		int d=(int) Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
		
		
		return "The distance is " + d;
	}

}
