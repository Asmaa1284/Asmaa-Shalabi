
public enum Type {
BACHELOR_ARTS("BAA"),BACHELOR_SCINCE("BAS"),MASTERS("MASTER"),PHP("PHP");
private String studentType;
Type(String string) {
 this.studentType=string;
}
public String getType() {
	return studentType;
}
}
