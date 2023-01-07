package java211s;



public class NoPay implements Payer {     // M3 USING STRATEGY

	@Override
	public void pay() {
	  System.out.println("There's no Pay!");
		
	}

}
