
public class BachSciStudent extends Bachelor {

	public BachSciStudent(int id, String name,Boolean graduated, Major major, double gpa) {
		super(id, name, major, graduated, gpa);
		
	}
	public void scinceDegree() {
		System.out.println("You achieved a sc Degree");
	}

}
