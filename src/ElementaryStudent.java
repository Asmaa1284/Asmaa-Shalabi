
public class ElementaryStudent extends Student  {

	public ElementaryStudent(int id, String name) {
		super(id, name);
		super.setMajor("Elementary");
	}
	public String toString() {
		return super.toString()+ " Elemantary .";
	}
	@Override
	public void tution() {
		System.out.println("Elementary don't pay!");
		
	}

}
