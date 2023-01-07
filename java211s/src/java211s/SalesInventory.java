package java211s;

import java.util.ArrayList;
import java.util.List;

public class SalesInventory {
  private List <Perishable> sales;
  public SalesInventory() {
	  this.sales= new ArrayList<>();
  }
  public  void addItem(String type,float wieght,String name,String eD,String p) {
	  Perishable per= InventoryFactory.newItem(type, name, wieght, eD, p);
	  sales.add(per);
  }
}
