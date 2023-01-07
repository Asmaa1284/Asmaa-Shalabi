
public class BachArtStudent extends Bachelor {

	public BachArtStudent(int id, String name, Major major,boolean graduated, double gpa) {
		super(id, name, major, graduated, gpa);
	
	}
	public void artDegree() {
		System.out.println("You Earned Art Degree");
	}

}
