package java211s;


import java.util.Objects;

public class FreshVegetable extends Perishable{
	private String product;

	public FreshVegetable(String name, float wight, String expDate, String product) {
		super(name, wight, expDate);
		this.product = product;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "FreshVegetable [product=" + product + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(product);
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
		FreshVegetable other = (FreshVegetable) obj;
		return Objects.equals(product, other.product);
	}

	
	

}
