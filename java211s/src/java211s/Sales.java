
import java.util.ArrayList;


public class Sales extends Employee{
	private ArrayList<String> items= new ArrayList<>();

	public Sales(int id, String name) {
		super(id, name);
		
	}

	public Sales(String name,Status status) {
		super(name, status);
		
	}

	public ArrayList<String> getItems() {
		return items;
	}

	public void setItems(ArrayList<String> items) {
		if(items.size()>0) {
		this.items = items;
		}
	}

	@Override
	public String toString() {
		String s = super.toString();
		s += "Sales [items=" + items + "]";
		return s;
	}

	
	@Override
	public boolean equals(Object obj) {
		boolean isEquals;
		
		if (obj instanceof Sales) {
			 
			Sales s= (Sales)obj;
			
			ArrayList<String> cart= s.getItems();
			if(this.items.equals(cart)) {
			
				isEquals= true;
			}else {
				isEquals= false;
			}
		
	     }else {
	    	 
		isEquals= false;
		}
		return isEquals;
	}


}
