package ComparatorInterface;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		Student one = new Student("Anis", 23);
		Student two = new Student("Imran", 24);
		Student three = new Student("Karim", 25);
		
		ArrayList<Student>students = new ArrayList<>();
		//students.add(new Student("Anis", 23));
		students.add(one);
		students.add(two);
		students.add(three);
		
		Collections.sort(students,new Student());
		
		for(Student it:students) {
			System.out.println(it.name+" "+it.id);
		}
	}
}

