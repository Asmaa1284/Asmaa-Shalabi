import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class PoliceDriver {

	public static void main(String[] args) {
	
		 readOnlyFileWithList();
		//readFilewithMap();
//		 MappingPoliceViolence mViolence= new MappingPoliceViolence.ViolenceBuilder("fds", "trd", "race").age(98).date("date")
//				 .streetAdress("strAdres").
//			    	city("sa").state("ca").county("al").agencyresp("na")
//			    	.causeOfDeath("causeOfDeath").build();
//		 
//		 System.out.println(mViolence.toString());
			
			    
			
		
	}
	public static void readOnlyFileWithList() {
		int count=0;
		try(Scanner fileScan = new Scanner(new FileReader(new File("Mapping_Police_Violence.csv")))){
			String lineString = fileScan.nextLine();
			List<MappingPoliceViolence> list= new ArrayList<MappingPoliceViolence>();
			Map<String,List<MappingPoliceViolence>> map= new HashMap<>();
			Set<String> keys= new HashSet<>();
			while(fileScan.hasNext()) {
				String line = fileScan.nextLine();
				
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(",");
				String name = lineScan.next();
				
				int age= Integer.parseInt(lineScan.next());
				
				String gender = lineScan.next();
				
				String race = lineScan.next();
				String date = lineScan.next();
				String strAdres= lineScan.next();
				String city= lineScan.next();
				
				String state = lineScan.next();
			if(!(keys.contains(state))){
				keys.add(state);
			}
				String county=lineScan.next();
				String agencyresp= lineScan.next();
				String causeOfDeath= lineScan.next();
				//System.out.println(name +" "+ age+" "+ race);
				MappingPoliceViolence mappingPoliceViolence= new MappingPoliceViolence.ViolenceBuilder(name, gender, race).age(age).date(date).streetAdress(strAdres).
				    	city(city).state(state).county(county).agencyresp(agencyresp).causeOfDeath(causeOfDeath).build();
				
				
			    list.add(mappingPoliceViolence);
			    
			    
			}
			System.out.println(keys.size());
			 Collections.sort(list);
			//System.out.println(list.get(0));// What is the youngest case?La'Mello Parker 1 year old
			
			fileScan.close();
			Stream<MappingPoliceViolence> stream= list.stream();
			Long size= stream.filter(MappingPoliceViolence->MappingPoliceViolence.getState().equalsIgnoreCase("ca")).count();
			System.out.println("violince in ca:"+ size);
			for(MappingPoliceViolence m: list) {
				if(m.getState().equalsIgnoreCase("ca")) {
					count++;
				}
			}
			//System.out.println(count);// How many cases in california?648
			for(MappingPoliceViolence mv: list) {
				if(!(map.containsKey(mv.getState()))) {
					map.put(mv.getState(),new ArrayList<MappingPoliceViolence>());
				}
				map.get(mv.getState()).add(mv);
			}
			//System.out.println(map.get("CA"));
			

	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
		
	}
	public static void readFilewithMap() {
		int count=0;
		try(Scanner fileScan = new Scanner(new FileReader(new File("Mapping_Police_Violence.csv")))){
			String lineString = fileScan.nextLine();
			//List<MappingPoliceViolence> list= new ArrayList<MappingPoliceViolence>();
			Map<String,MappingPoliceViolence> map= new HashMap<>();
			while(fileScan.hasNext()) {
				String line = fileScan.nextLine();
				
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(",");
				String name = lineScan.next();
				
				int age= Integer.parseInt(lineScan.next());
				
				String gender = lineScan.next();
				
				String race = lineScan.next();
				String date = lineScan.next();
				String strAdres= lineScan.next();
				String city= lineScan.next();
				
				String state = lineScan.next();
				String county=lineScan.next();
				String agencyresp= lineScan.next();
				String causeOfDeath= lineScan.next();
				MappingPoliceViolence mappingPoliceViolence= new MappingPoliceViolence.ViolenceBuilder(name, gender, race).age(age).date(date).streetAdress(strAdres).
				    	city(city).state(state).county(county).agencyresp(agencyresp).causeOfDeath(causeOfDeath).build();
				
				
			    map.put(name,mappingPoliceViolence);
			    
	}
			
			System.out.println("Done!");
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	

}
}