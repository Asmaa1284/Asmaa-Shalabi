import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentDriver {

	public static void main(String[] args) {
		List<Student>students=new ArrayList<>();
		Student bStudent= new Bachelor(1, "Aycil", Major.ART, false, 4.0);
		Student artStudent= new BachArtStudent(2, "Ali", Major.ART, false, 3.8);
		Student sciStudent= new BachSciStudent(3, "Asmaa", true, Major.COMPUTER_SCIENCE, 4.5);
        Student mStudent= new MasterStudent(4, "Menna", Major.ACCOUNTING);
        Student dStudent=new DocStudent(5, "Ehab", Major.ACCOUNTING);
        students.add(dStudent);
        students.add(mStudent);
        students.add(sciStudent);
        students.add(artStudent);
        students.add(bStudent);
        for(Student s: students) {
        	s.tution();
        	s.register(s.getId(), s.getName());
        	if(s instanceof BachSciStudent) {
        		((BachSciStudent)s).scinceDegree();
        	}
        }
        Collections.sort(students);
        for(Student s: students) {
        	System.out.println(s.toString());
        }
	}

}
