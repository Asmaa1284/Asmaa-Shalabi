package java211s;



public enum EmployeeDepartment {
	Sales("S"),CUSTOMER_SERVICE("CS"),ADMIN("A");  // M3 USING FACTORY
	private String empDep;
	private EmployeeDepartment(String empDep) {
		this.empDep =empDep;
	}
	public String employeeDep() {
		return this.empDep;
	}
	  @Override
	    public String toString() {
	    	String text = super.toString().substring(0,1) + super.toString().substring(1).toLowerCase();
			text += this.empDep; 
			return text;
	    }


}
