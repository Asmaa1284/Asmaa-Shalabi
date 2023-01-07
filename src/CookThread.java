import java.util.*;

public class CookThread extends Thread{
	List<Food> foodList = new ArrayList<>();
	public CookThread(List<Food> foodList) {
		this.foodList=foodList;
	}
	@Override
	public void run() {
		for(int i=0;i< foodList.size();i++) {
			synchronized (foodList.get(i)) {
				
			
			System.out.println("COOK READY");
			System.out.println("Cook STarting: "+ foodList.get(i).toString());
			try {
				
				Thread.sleep(foodList.get(i).getCookTime()*1000);
				System.out.println("Cook Ending: " +foodList.get(i).toString());
				foodList.get(i).notifyAll();
				
				
			}catch(InterruptedException ex) {
				return;
			}
		}
			
		}
		System.out.println("The cook gets to go home!");
	}

}
