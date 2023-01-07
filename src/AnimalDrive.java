import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AnimalDrive {
	public static void main(String[] args) {
		{
			for(String temp: args) {
				System.out.print(temp);
			}
		}
		Integer[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		pintArray(arr);
		List<Animal> animals= new ArrayList<>();
		Map<String,Animal>animalMap= new HashMap<>();
		Animal dog1= new Dog("rex",3,AnimalStatus.LONG_TERM);
		Animal dog2= new Dog("ted",2,AnimalStatus.SHORT_TERM);
		Animal dog3= new Dog("max",4,AnimalStatus.NEW_AND_BEING_EVALUATED);
		Animal cat1= new Cat("bousy",5,new InsideExerciser(),AnimalStatus.LONG_TERM);
		Animal cat2= new Cat("tom",1,new OutsideExerciser(),AnimalStatus.NEW_AND_BEING_EVALUATED);
		Animal cat3= new Cat("tiffany",2,new InsideExerciser(),AnimalStatus.SHORT_TERM);
		int minAge =2;
		Animal dog4= new Dog("candy", 6,AnimalStatus.SHORT_TERM );
		animals.add(cat3);
		animals.add(cat2);
		animals.add(cat1);
		animals.add(dog3);
		animals.add(dog2);
		animals.add(dog1);
		List<String>adoptetedList= new ArrayList<>();
		adoptetedList.add(cat3.getName());
		adoptetedList.add(dog1.getName());
		adoptetedList.add(dog4.getName());
		//PrintWriter out = new PrintWriter(new FileOutputStream("animals.txt",true));
		String fileNameString="animals.txt";
	   countAdoptableAnimals(animals);
		    
		    for(Animal a: animals) {
		    	animalMap.put(a.getName(), a);
		    }
		    adoptionUpdates(animalMap,adoptetedList);
		
		//printOlderAnimalsToFile(animals,minAge,fileNameString);
//		try {
//		//	Scanner scan= new Scanner(new FileInputStream(fileNameString));
//		PrintWriter out = new PrintWriter(new FileOutputStream("animals.txt",true));
//			//while(scan.hasNext()) {
//				for(Animal animal: animals) {
//				if(animal.getAge()> minAge) {
//				//	String a = scan.nextLine();
//					//Integer age= Integer.parseInt(scan.nextLine()); 
//				//System.out.println(age);
//				out.println(animal.getName()+" ");
//				}
//				}
//				out.close();
//			
//			//scan.close();
//		} catch (FileNotFoundException e) {
//			
//			System.out.println(e.getMessage());
//		}
	}
	public static void printOlderAnimalsToFile(List<Animal> animals, int minAge, String fileName) {
		try {
			
			PrintWriter out = new PrintWriter(new FileOutputStream("animals.txt",true));
				
					for(Animal animal: animals) {
					if(animal.getAge()> minAge) {
					
					out.println(animal.getName()+" ");
					}
					}
					out.close();
				
				
			} catch (FileNotFoundException e) {
				
				System.out.println(e.getMessage());
			}
	}
	public static int countAdoptableAnimals(List<Animal> animals) {
	    
	    int counter=0;
	    for(Animal animal:animals) {
	    	if(animal.getStatus().isStatus()) {
	    		counter++;
	    	}
	    }
	    System.out.println(counter);
	    return counter;

	}

public static void adoptionUpdates(Map<String, Animal> animalMap, List<String> animalNameList) {
   for(String name: animalNameList) {
	if(animalMap.containsKey(name)) {
    	animalMap.get(name).adopt();
    	System.out.println(name);
    }
   }
}
public static <T >void pintArray(T[] arr){
	for(int i=0;i<arr.length;i=i+2) {
		System.out.println(arr[i]);
	}
	
}

}     
	
	



