import java.util.*;


public class ServeThread extends Thread{
	List<Food>fList=new ArrayList<>();
	
	public ServeThread(List f) {
		this.fList=f;
	}
	public void run() {
		for(int i=0;i< fList.size();i++) {
			
				synchronized (fList.get(i)) {
					
					try {
					
				System.out.println("Server Ready");
				System.out.println("Server Starting: " +fList.get(i).toString());
				Thread.sleep(fList.get(i).getServeTime()*1000);
				System.out.println("Server Ending: " +fList.get(i).toString());
				
				
			}catch(InterruptedException ex) {
				return;
			}
			
		}
		}
	}
	

}
