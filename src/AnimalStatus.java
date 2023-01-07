
public enum AnimalStatus {
NEW_AND_BEING_EVALUATED(false),SHORT_TERM(true),LONG_TERM(false);
	private boolean status;

AnimalStatus(Boolean status) {
	this.status= status;
	
}

public boolean isStatus() {
	return status;
}

public void setStatus(boolean status) {
	this.status = status;
}
}
