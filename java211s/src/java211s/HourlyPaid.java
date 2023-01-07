package java211s;



public class HourlyPaid implements Payer{     // M3 USING STRATEGY

	@Override
	public void pay() {
		System.out.println("Get paid hourly!");
		
	}

}
