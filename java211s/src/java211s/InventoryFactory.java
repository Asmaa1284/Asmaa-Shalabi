package java211s;

public class InventoryFactory {
	public static Perishable newItem(String type,String name,float w,String eD,String p ) {
		Perishable per;
		if(type.equalsIgnoreCase("fresh")) {
			per= new FreshVegetable(name,w,eD,p);
		}else if(type.equalsIgnoreCase("can")) {
			per = new CannedFood(name,w,eD,p);
		}else {
			throw new IllegalArgumentException();
		}
		return per; 
	}

}
