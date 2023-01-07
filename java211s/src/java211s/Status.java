package java211s;



public enum Status {   // M2 HOMEWORK ENUM
	Part_time("P"),Full_time("F"),Retired("R"),ADMIN("A");
    private String empStaus;
    private Status(String empStatus) {
    	this.empStaus=empStatus;
    }
    public String eStatus() {
    	return this.empStaus;
    }
    @Override
    public String toString() {
    	String text = super.toString().substring(0,1) + super.toString().substring(1).toLowerCase();
		text += this.empStaus; 
		return text;
    }
}
