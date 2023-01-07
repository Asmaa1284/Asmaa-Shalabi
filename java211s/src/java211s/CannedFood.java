package java211s;

import java.util.Objects;

public class CannedFood extends Perishable{
	private String made;
	private String brand;
	public CannedFood(String name, float wight, String expDate,String brand) {
		super(name, wight, expDate);
		
		this.brand = brand;
	}
	public String getMade() {
		return made;
	}
	public void setMade(String made) {
		this.made = made;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(brand, made);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CannedFood other = (CannedFood) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(made, other.made);
	}
	@Override
	public String toString() {
		String s= super.toString();
		s+= "CannedFood [made=" + made + ", brand=" + brand + "]";
		return s;
	}
	

}
