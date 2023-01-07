package java211s;



import java.util.ArrayList;
import java.util.Objects;

public class Admin extends Employee{
  private ArrayList<Employee>employees= new ArrayList<>();
	public Admin(int id, String name) {
		super(id, name);
		
	}

	public Admin(String name) {
		super(name,Status.ADMIN); //M2 HOMEWORK ENUM
		
	}

	@Override
	public String toString() {
		String s= super.toString();
		s += " The Admin ";
		return s;
	}
	public boolean addEmployee(Employee e) {
		//Employee nE= e;
		return employees.add(e);
	}
	public void review() {
		for(int i=0;i<employees.size();i++) {
			System.out.println(employees.get(i).toString());
		}
	}


	@Override
	public boolean equals(Object obj) {
		
		Admin other = (Admin) obj;
		return super.equals(other) && Objects.equals(employees, other.employees);
	}
	
	
	

}
