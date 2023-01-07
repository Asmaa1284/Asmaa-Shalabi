package java211s;



import java.util.Comparator;

public class Employee implements Comparable<Employee>, User {
 
  private int id;
  private String name;
  private static final int DEFAULT_ID = 5;
  private static int numOfEmp=0;  // M2 HOMEWORK STATIC
  private Status status; // M2 HOMEWORK ENUM
  private int hours;
  private Payer payer; // M3 USING STRATEGY
  public final static Comparator<Employee> Name_comparator = new EmployeeNameComparator();  // M3 USING COMPARATOR
  public final static Comparator<Employee> Id_comparator = new EmployeeNameIdComparator(); // M3 USING COMPARATOR
  private static class EmployeeNameComparator implements Comparator<Employee>{   // M3 USING COMPARATOR

	@Override
	public int compare(Employee e1, Employee e2) {
		
		return e1.name.compareToIgnoreCase(e2.name);
	}
	  
  }
  private static class EmployeeNameIdComparator implements Comparator<Employee>{   // M3 USING COMPARATOR

	@Override
	public int compare(Employee e1, Employee e2) {
		if(e1.name.compareToIgnoreCase(e2.name)==0) {
			return Integer.compare(e1.id, e2.id);
		}else {
		
		return e1.name.compareToIgnoreCase(e2.name);
		}
	}
	  
  }


public Employee(int id, String name) {
	this.id=id;
	this.name=name;
	numOfEmp++;// M2 HOMEWORK STATIC
	 
}
public Employee(int id, String name, Status status) {  // M2 HOMEWORK ENUM

	this(id,name);
	this.status=status;  // M2 HOMEWORK ENUM
	this.payer= setPayer();  // M3 USING STRATEGY
	
}
private Payer setPayer() {
	
	if(this.status.eStatus().equalsIgnoreCase("f")) {
		this.payer= new Salary();     // M3 USING STRATEGY
	}else if(this.status.eStatus().equalsIgnoreCase("a")) {
		this.payer= new Salary();
	}else if(this.status.eStatus().equalsIgnoreCase("p")) {
		this.payer= new HourlyPaid(); // M3 USING STRATEGY
	}else {
		this.payer= new NoPay();  // M3 USING STRATEGY
	}
	return this.payer;
}
public Status getStatus() { // M2 HOMEWORK ENUM
	return status;
}
public void setStatus(Status status) { // M2 HOMEWORK ENUM
	this.status = status;
}
public Employee(String name,Status status) { // M2 HOMEWORK ENUM
	
	this( DEFAULT_ID,name,status);
	
}
public Status empStatus() {    //M2 HOMEWORK ENUM
	if (this.hours<= 0) {
		return Status.Retired;
	}else if(this.hours <40) {
		return Status.Part_time;
	}else {
		return Status.Full_time;
	}
}
public static int getEmplyeeNum() {      //M2 HOMEWORK STATIC
	return numOfEmp;
}
public int getId() {
	return id;
}
public void setId(int id) {
	if(id >= 0) {
	this.id = id;
	}
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return this.name +" (id =" + id + ")";
}

@Override
public boolean equals(Object obj) {
	boolean isEquals;
	
	if (obj instanceof Employee) {
		 
		Employee nE= (Employee)obj;
		
		int nId= nE.getId();
		String nName= nE.getName();
		if((id==nId) &&( name.equalsIgnoreCase(nName))) {
		
			isEquals= true;
		}else {
			isEquals= false;
		}
	
     }else {
    	 
	isEquals= false;
	}
	return isEquals;
}
@Override
public int compareTo(Employee o) {   //
	if(this.name.compareToIgnoreCase(o.getName())!=0) {
		return this.name.compareToIgnoreCase(o.getName());
	}else {
		return Integer.compare(id, o.getId());
	}
}
@Override
public void logIn() {    // M3 USING STRATEGY
	System.out.println("welcome Employee!");
	
}
public void getPaid() {   // M3 USING STRATEGY
	this.payer.pay();
}

}
