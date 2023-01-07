

public enum Major {
	ACCOUNTING("A"), COMPUTER_SCIENCE("CS"), ART("ART");
	private String major;
	
	private Major(String major) {
		this.major= major;
	}
	public String stMajor() {
		return this.major;
	}
	 @Override
	    public String toString() {
	    	String text = super.toString().substring(0,1) + super.toString().substring(1).toLowerCase();
			text += this.major; 
			return text;
	    }
	

}
