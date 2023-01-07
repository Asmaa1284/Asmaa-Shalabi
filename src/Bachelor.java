
public class Bachelor extends Student {
    private double gpa;
	public Bachelor(int id, String name, Major major, Boolean graduated, double gpa) {
		super(id, name,major,graduated);
		this.gpa=gpa;
		
	}
	

	public double getGpa() {
		return gpa;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}


	@Override
	public void tution() {
		System.out.println(" Have to pay full");
		
	}

}
