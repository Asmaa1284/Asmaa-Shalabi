
public class MasterStudent extends GraduateStudent{

	public MasterStudent(int id, String name, Major major,String thesis) {
		super(id, name, major, false, thesis);
	
	}

	@Override
	public void tution() {
		System.out.println("Master Student pay pay partial and work as TAs");
		
	}

}
