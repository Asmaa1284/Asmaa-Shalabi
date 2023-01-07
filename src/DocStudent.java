
public class DocStudent extends GraduateStudent{

	public DocStudent(int id, String name, Major major, String theisis) {
		super(id, name, major, false, theisis);
		
		
	}

	@Override
	public void tution() {
	  System.out.println("doc students don't pay tuition but work in research and as TAs");
		
	}

}
