package java211s;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EmployeeTester {

	public static void main(String[] args) {
		 ArrayList<Employee> e= new ArrayList<>();
		 ArrayList<Customer> c= new ArrayList<>();
		Employee employee1= new Employee(123,"Ahmed",Status.Full_time);
		Employee employee2= new Employee("Aycil",Status.Part_time);
		Employee employee3= new Employee(65,"Ahmed");
		Admin admin= new Admin(111,"Asmaa");
		Admin admin2= new Admin(121,"Asmaa");
		Sales sale1= new Sales(222,"Ehab");
		e.add(employee1);
		e.add(employee2);
		e.add(employee3);
		e.add(admin);
		e.add(sale1);
		Customer c1= new Customer("Ahmed","12345");
		Customer c2= new Customer("Aycil","0000");
		Customer c3= new Customer("Asmaa","5555");
		c.add(c1);
		c.add(c2);
		c.add(c3);
		System.out.println(admin.toString());
		System.out.println(Employee.getEmplyeeNum());//M2 HOMEWORK Static 
		System.out.println(c.toString());
		System.out.println(admin.equals(admin2));
		System.out.println("id is "+ employee1.getId());
		System.out.println("id is "+ employee2.getId());
		employee1.setId(-65);
		System.out.println("id is "+ employee1.getId());
		System.out.println("id is "+ employee2.getId());
		employee1.setId(65);
		System.out.println("id is "+ employee1.getId());
		System.out.println("id is "+ employee2.getId());
		System.out.println(employee1);
		System.out.println(employee2);
		System.out.println(employee1.equals(employee2));
		System.out.println(employee3.equals(employee1));
		System.out.println(admin.addEmployee(employee1));
		admin.review();
		System.out.println(e);
		Collections.sort(e);
		System.out.println(e);
		Items item = new Items.ItemBuilder("apple", "iphone14", 1200.20f)
				.color("silver")
				.discreption("256 g brand new")
				.weight(1.2f)
				.quantity(1).build();  // M3 USING BUILDER
		User user1 = new Employee(12345,"asmaa");
		User user2 = new Customer("ehab","9999");
		user1.logIn();    // M3 USING STRATEGY
		user2.logIn();    // M3 USING STRATEGY
		employee1.getPaid();   // M3 USING STRATEGY
		Department dep= new Department();// M3 USING FACTORY
		
	    ArrayList<Employee> empList = new ArrayList<>();
	    for(int i=0;i <3; i++) {
	    	Scanner sc= new Scanner(System.in);
		
				
				System.out.println("Enter the Department: A for admin ,cS for customer Service, s for sales");
				 String ed = sc.nextLine();
				System.out.println("Enter the I.D:");
				 int id= sc.nextInt();
				
				System.out.println("Enter name:");
				 String  n = sc.next();
				
				 Employee emp = EmployeeFactory.addEmployee(ed, id, n); 
		            empList.add(emp);
	    }
	    System.out.println(empList);
	    Collections.sort(empList, Employee.Id_comparator);  // M3 USING COMPARATOR
        System.out.println(empList);
		
	}

}
