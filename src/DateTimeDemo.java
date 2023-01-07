import java.awt.geom.Point2D;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.*;
import java.time.temporal.*;
import java.util.Arrays;
import java.util.Scanner;

public class DateTimeDemo {
public static void main(String[]args) {
	LocalDate today= LocalDate.now();
	System.out.println(today);
	DateTimeFormatter outputFormatter= DateTimeFormatter.ofPattern("MMMM dd,YY");
	System.out.println("Today is "+today.format(outputFormatter));
	LocalDate tomorrow = today.plus(1,ChronoUnit.DAYS);
	System.out.println("Today is still "+ today.format(outputFormatter));
	System.out.println("Tomorrow is "+ tomorrow.format(outputFormatter));
	LocalDate aprilFools= LocalDate.of(2023, Month.APRIL, 1);
	Period timeToFoolPeriod = Period.between(today, aprilFools);
	System.out.println(timeToFoolPeriod);
	System.out.println("April Fools Day is in " + timeToFoolPeriod.get(ChronoUnit.DAYS));
	Scanner scanner= new Scanner(System.in);
	System.out.println("enter The month:");
	String s= scanner.nextLine();
	Month month= null ;
	 
	try{
	     month=	Month.of(Integer.parseInt(s));
	     
	     System.out.println(month);
	}catch (DateTimeException e) {
		 System.out.println("try again!");
	}
	}
	

	   
	   
	  }




