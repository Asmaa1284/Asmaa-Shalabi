
public class GraduateStudent extends Student {


private String thesis;
public GraduateStudent(int id, String name, Major major, boolean graduated, String thesis) {
	super(id, name, major, graduated);
	this.thesis= thesis;
}
@Override
public void tution() {
	System.out.println("Graduated Student don't pay");
	
}
public String getThesis() {
	return thesis;
}
public void setThesis(String thesis) {
	this.thesis = thesis;
}
public void graduated(){
	System.out.println("Congratulations, You did it! ");
	
}
}
