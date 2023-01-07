import javafx.scene.shape.Line;

public class VertOrHerz implements LineInfoDisplayer{
double x,y;
String vOrHString;
	@Override
	public String getInfo(Line line) {
		x= line.getEndX()- line.getStartX();
		y= line.getEndY()- line.getStartY();
		if(x==0) {
			vOrHString="It's virtical";
		}else if(y==0) {
			vOrHString="It's Horizontal";
		}
		
		return vOrHString;
	}
	

}
