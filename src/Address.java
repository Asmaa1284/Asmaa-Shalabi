import java.lang.annotation.*;
import java.lang.reflect.*;

public class Address {
	@ProperLength
	private String street;
	private String street2;
	@ProperLength(maxLength = 40)
	private String city;
	@ProperLength(minLength = 2,maxLength = 2 )
	private String state;
	@ProperLength(minLength = 5,maxLength = 5 )
	private String zip;

	public Address(String street, String street2, String city, String state, String zip) throws IllegalArgumentException, ReflectiveOperationException  {
		
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		
		validateLengths();
	}
	
	private void validateLengths() throws IllegalArgumentException, ReflectiveOperationException {
		// YOUR CODE HERE
      /* some pseudocode in case it helps:
		 * get the current class
		 * get all fields in this class
		 * 	  NOTE: use the method myClass.getDeclaredFields() to access private fields;
		 *      (getFields() only accesses public fields)
		 * check if the ProperLength annotation is present for that field
		 * if it is, get the annotation object 
		 * get the min and max from the annotation
		 * then get the value for that field
		 *      NOTE: the method myField.get(myObject) can be used to obtain the value of a field for a particular object;
		 *      note that this returns an Object, so you'll need to cast it
		 * check that the length of the value matches the specifications of the annotation
		 * if the length isn't valid, throw an exception with a descriptive message of what field is invalid and why  
		 */
		
		
		String className = "Address";
		Class clss = Class.forName(className);
		//Address obj= new Address(className, className, className, className, className) ;
		Field[] fields= clss.getDeclaredFields();
	
		for(Field field: fields) {
			
			if(field.isAnnotationPresent(ProperLength.class)) {
				
				ProperLength annotation=field.getAnnotation(ProperLength.class);
			
				
				if(field.get(this).toString().length()>annotation.maxLength()){
					
					
					field.setAccessible(true);
					field.set(this, null);
					
					
		
					throw new IllegalArgumentException("Invalid Address "+field.getName()+" too Long");
					
			
				}else if(field.get(this).toString().length()<annotation.minLength()|| field.get(this).equals(null)) {
					field.setAccessible(true);
					field.set(this, null);
					
					
		
					throw new IllegalArgumentException("Invalid Address "+field.getName()+" too short");
					
				}
			}
			}
//				
		
					
			}
		
		
		
	
	@Override
	public String toString() {
		String s = street + (street2.length()>0 ? "\t"+street2 : "") +
				"\t" + city + ", " + state + " " + zip;
		return s;
				
	}
}
