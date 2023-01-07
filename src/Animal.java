import java.util.Comparator;


public abstract class Animal implements Comparable<Animal>{

    private String name;
    private int age;
    private Exercisable exercise;
    private AnimalStatus status;
    public final static Comparator<Animal> Id_comparator = new AnimalAgeComparator();
 
    public Animal(String name, int age, Exercisable exercise, AnimalStatus status) {
        this.name = name;
        this.exercise = exercise;
        this.age = age;
        this.status = status;
    }
    public static class AnimalAgeComparator implements Comparator<Animal>{

		public int compare(Animal a1, Animal a2) {
			
			if(a1.name.compareToIgnoreCase(a2.name)==0) {
				return Integer.compare(a1.age, a2.age);
			}else {
			
			return a1.name.compareToIgnoreCase(a2.name);
			}
		}

	
		
		} 
    public void exercise() {
    	 //  System.out.println(this.exercise);
    	if(this.exercise instanceof OutsideExerciser) {
    		System.out.println("It's outside");
    	}else if(this.exercise instanceof InsideExerciser) {
    		System.out.println("It's inside");
    	}
    	}

    public AnimalStatus getStatus() {
        return status;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }
    public Exercisable getExercise() {
        return exercise;
    }
    public void setExercise(Exercisable exercise) {
        this.exercise = exercise;
    }
    @Override
    public String toString() {
        return name + " (Age: " + age + ")";
    }
    @Override
    public boolean equals(Object o) {
    	boolean isEquals;
    	
    	if (o instanceof Animal) {
    		 
    		Animal a= (Animal)o;
    		
    		int aAge= a.getAge();
    		String nName= a.getName();
    		if((age==aAge) &&( name.equalsIgnoreCase(nName))) {
    		
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
    public int compareTo(Animal o) {   
    	if(this.name.compareToIgnoreCase(o.getName())!=0) {
    		return this.name.compareToIgnoreCase(o.getName());
    	}else {
    		return Integer.compare(age, o.getAge());
    	}
    }
    public void adopt() {    
    	System.out.println("updated Done!");
    }
}