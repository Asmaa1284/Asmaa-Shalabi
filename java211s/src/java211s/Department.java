package java211s;



import java.util.*;

public class Department { // M3 USING FACTORY
	private List<Employee> empList;
	public Department() {
		empList = new ArrayList<>();
	}
	public void addEmployee(Employee e) {
		this.empList.add(e);
	}
	public void addEmployee(String type,int id, String n) {
		Employee ef=  EmployeeFactory.addEmployee(type, id, n);
		this.empList.add(ef);
	}
	public List<Employee> getEmpList() {
		return empList;
	}
	
	

}
