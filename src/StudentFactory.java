
public class StudentFactory {
	public static Student addStudent(int id,String name, Major maj,boolean graduated,Object g) {
		Student student= null;
		if(g instanceof Double ) {
			double gpa= (Double)g;
			student= new Bachelor(id, name, maj, graduated, gpa);
			
		}else if(g instanceof String) {
			String theisiString= (String)g;
			student= new GraduateStudent(id, name, maj, graduated, theisiString);
		}
		return student;
	}

}
