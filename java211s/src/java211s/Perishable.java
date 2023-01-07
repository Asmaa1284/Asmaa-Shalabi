package java211s;

import java.util.Objects;

public class Perishable implements Comparable<Perishable> {
	private String name;
	private float wight;
	private String expDate;
	public Perishable(String name, float wight, String expDate) {
		
		this.name = name;
		this.wight = wight;
		this.expDate = expDate;
	}
	@Override
	public String toString() {
		return "Perishable [name=" + name + ", wight=" + wight + ", expDate=" + expDate + "]";
	}
	
	public int comparTo(Perishable per) {
	 if(this.name.compareTo(per.getName())!=0) {
		 return this.name.compareTo(per.getName());
	 }else {
		 return Float.compare(this.wight, per.getWight());
	 }
 }
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perishable other = (Perishable) obj;
		return Objects.equals(expDate, other.expDate) && Objects.equals(name, other.name)
				&& Float.floatToIntBits(wight) == Float.floatToIntBits(other.wight);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getWight() {
		return wight;
	}
	public void setWight(float wight) {
		this.wight = wight;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	@Override
	public int compareTo(Perishable o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
