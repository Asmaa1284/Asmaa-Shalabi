package java211s;



public class EmployeeFactory {  // M3 USING FACTORY

	public static Employee addEmployee(String type,int id, String n) {
		Employee e ;
		
		if(EmployeeDepartment.ADMIN.employeeDep().equalsIgnoreCase(type)) {
		e = new Admin(id,n);
		
		}
	else if((EmployeeDepartment.CUSTOMER_SERVICE.employeeDep().equalsIgnoreCase(type))) {
		e= new CustomerService(n,id);
	}else if(EmployeeDepartment.Sales.employeeDep().equalsIgnoreCase(type)) {
		e= new Sales(id,n);
		
		}else {
			
		throw new IllegalArgumentException();
	}
		return e;
	}
	
		
		
		

}
