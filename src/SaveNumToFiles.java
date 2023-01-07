import java.io.*;
import java.nio.file.*;
import java.util.Scanner;


public class SaveNumToFiles {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		try {
			System.out.println("Enter File name:");
		String userFile= scan.nextLine();
		PrintWriter out = new PrintWriter(new FileOutputStream(userFile,true));
		int userInput=0;
		while(userInput<10) {
			try {
			int num = Integer.parseInt(scan.nextLine());
			out.println(num);
			userInput++;
			}catch(NumberFormatException ex) {
				System.out.println("That's not a number!, try again");
			}
		}
		out.close();
		}catch(FileNotFoundException ex) {
			System.out.println("This file doesn't exist!");
		}finally {
			System.out.println("done!");
		}
	}

}
