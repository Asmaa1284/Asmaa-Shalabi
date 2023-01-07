import javafx.scene.shape.Line;
@FunctionalInterface
public interface LineInfoDisplayer {

    String getInfo(Line line);

    public static enum InfoType {
        DISTANCE, MIDPOINT, VERT_HORZ;
    }
      
    public static LineInfoDisplayer createLineInfoDisplayer(InfoType type) {
    	switch (type) {
		case DISTANCE:
			return (Line line) ->  "distance = "+ (int)Math.hypot(line.getEndX()-line.getStartX(),line.getEndY()- line.getStartY());
		case MIDPOINT:
			return (Line line) -> "Mid point is ("+(int)((line.getEndX()+line.getStartX())/2)+", "+(int)((line.getEndY()+line.getStartY())/2)+")"; 
		case VERT_HORZ:
			return (Line line) -> {
			
				if((line.getEndX()- line.getStartX()) == 0){
					  
					  return "it's vertical";
				}else if((line.getEndY()- line.getStartY())/(line.getEndX()- line.getStartX()) == 0) {
					return "It's Horizontal ";
				}else {
					return "It's not Horizontal or Virtical";
				 
				   
				}
				
				
			};
		
		}
    	return null;
    	 
		  
		
   
	   
   
       
    }

}