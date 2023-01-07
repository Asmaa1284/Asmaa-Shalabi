package java211s;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class StoreTester {
	public static void main(String[]args) {

		SalesInventory sv= new SalesInventory();
		for(int i=0;i<5;i++) {
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter type of food?(Can Or Fresh) ");
			String type= sc.nextLine();
			System.out.println("Enter the weight? ");
			float w= sc.nextFloat();
			System.out.println("Enter the name? ");
			String name= sc.nextLine();
			sc.nextLine();
			System.out.println("Enter the exp date? ");
			String exDate= sc.nextLine();
			System.out.println("Enter the product ");
			String pro= sc.nextLine();
			sv.addItem(type, w, name, exDate, pro);
		}
		
	}

}
