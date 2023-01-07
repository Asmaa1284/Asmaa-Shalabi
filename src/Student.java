

public  abstract class Student implements Comparable<Student>{
	private int id;
	private String name;
	private Major major; 
	private boolean graduated;
	public static int total=0;
	public Student(int id,String name, Major major, boolean graduated) {
		this.id=id;
		this.name=name;
		this.major=major;
		this.graduated=graduated;
		total++;
		
		
	}
	public Student (int id, String name) {
		this.id=id;
		this.name=name;
		total++;
	}
	public void setId(int id) {
		if(id > 0) {
			this.id=id;
		}
	}
	public int getId() {
		return this.id;
	}
	public void setName(String name) {
		if(!(name.isEmpty())) {
			this.name=name;
		}
	}
	public String getName() {
		return this.name;
	}
	public void setMajor(Major major) {
		this.major=major;
	}
	public Major getMajor() {
		return this.major;
	}

	public String toString() {
		String string= "Student name: "+ name+ ", ID: "+ id+ " , Major : "+ major;
		return string;
		
	}
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student student = (Student) obj;
			int sId= student.getId();
			String sName= student.getName();
			//Major sMajor= student.getMajor();
			if(this.id==sId&&(this.name.equalsIgnoreCase(sName))) {
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}
	}
	@Override
	public int compareTo(Student o) {
		if(name.compareToIgnoreCase(o.getName())!=0) {
		return name.compareToIgnoreCase(o.getName());
	}else {
		return Integer.compare(id, o.getId()) ;
	}
	}
	public void register(int id, String name) {
		
		this.id=id;
		this.name=name;
		System.out.println("success, you registered!");
		Student.total++;
		
	}
	public abstract void tution(); 
}
