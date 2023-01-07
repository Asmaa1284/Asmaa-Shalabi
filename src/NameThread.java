import java.util.*;
public class NameThread implements Runnable{


	
	private int printNum;
	private String message;
	
	public NameThread(String message, int printNum) {
		this.message = message;
		this.printNum= printNum;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i<printNum; i++) {
		
			System.out.println(message );
		}
	}

	public static void main(String[] args) {
		
			Thread thread = new Thread(new NameThread("Asmaa", 10));
			Thread thread1 = new Thread(new NameThread("Winter", 100));
			thread.start();
			thread1.start();
		//}
	}
	

}
