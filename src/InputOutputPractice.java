import java.io.*;

import java.nio.file.*;
import static java.nio.file.StandardCopyOption.*;

import java.util.Scanner;

public class InputOutputPractice {

	public static void main(String[] args) throws Exception{
//		Scanner fileScanner= new Scanner(new FileInputStream("input_onperline.txt"));
//		PrintWriter out = new PrintWriter(new FileOutputStream("output_alloneline.txt",true));
//		while(fileScanner.hasNext()) {
//			String oneLine = fileScanner.nextLine();
//			out.print(oneLine+" ");
//		}
//		
//		
//		
//		
//		
//		
//		fileScanner.close();
//		out.close();
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter the file name to copy:");
		String userFile= scan.nextLine();
		Path userInputPath = Paths.get(userFile);
		if(Files.exists(userInputPath)) {
			System.out.println("That's a valid file, YUP");
			System.out.println("Enter the directory of where you want the copy");
			String userOutputDir = scan.nextLine();
			Path userOutputPath =Paths.get(userOutputDir);
			if(Files.isDirectory(userOutputPath)) {
				System.out.println("exist");
				Files.copy(userInputPath, userOutputPath.resolve(userInputPath.getFileName()),REPLACE_EXISTING);
				
			}else {
				System.out.println("Not Exist");
			}
		}else {
			System.out.println("That's not valid file!");
		}

	}

}
