import java.util.Scanner;

public class ExceptionPractice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
		System.out.println("Enter a positive number: ");
		int num = Integer.parseInt(scan.nextLine());
		if(num > 0) {
			System.out.println("Yes!");
		}else {
			System.out.println("No it's not a number");
		}

	}catch(NumberFormatException ex) {
		System.out.println("Sorry, that is not a number");
	}
		System.out.println("Bye");
		}

}
