

public class SanFransiscoStreet implements Comparable<SanFransiscoStreet> {
private String name;
private String type;
private String fullName;
public SanFransiscoStreet(String name,String type, String fullName) {
	this.name=name;
	this.type= type;
	this.fullName= fullName;
	
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
@Override
public String toString() {
	return "San Fransisco Street [Type=" + name + ", full Name=" + type + ", Name=" + fullName + "]";
}


@Override
public boolean equals(Object obj) {
	boolean isEqual;
	if (obj instanceof SanFransiscoStreet) {
SanFransiscoStreet sFs= (SanFransiscoStreet)obj;
		
		String nType= sFs.getType();
		String nName= sFs.getName();
		String nFull =sFs.getFullName();
		if((this.type.equalsIgnoreCase(nType)) &&( name.equalsIgnoreCase(nName))&& (this.fullName.equalsIgnoreCase(nFull))) {
		
			isEqual= true;
		}else {
			isEqual= false;
		}
	
     }else {
    	 
	isEqual= false;
	}
	return isEqual;
	
}

@Override
public int compareTo(SanFransiscoStreet o) {
	if(this.name.compareToIgnoreCase(o.getName())!=0) {
		return this.name.compareToIgnoreCase(o.getName());
	}else {
		return this.type.compareToIgnoreCase(o.getType());
	}
	

}
}
