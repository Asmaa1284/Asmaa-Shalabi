package java211s;

public class ReflectionTester {

	public static void main(String[] args) throws ReflectiveOperationException {
		getClassInFormation();
		
		

	}

	public static void getClassInFormation() {
		
		Employee employee1= new Employee(123,"Ahmed",java211s.Status.Full_time);
		employee1.getPaid();
		Class clazz = employee1.getClass();
		System.out.println("\n"+ employee1.getName()+ " class="+ clazz.getName());
		
	}

}
