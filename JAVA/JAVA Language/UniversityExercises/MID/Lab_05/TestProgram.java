package Lab_05;

import java.util.Scanner;

public class TestProgram {
	public static void main(String[] args) {
		PersonalInfo objInfo;
		objInfo  = new Student(22,"Papon","CSE",3.5);
		objInfo.personalAddress(22, "Lakshmipur", 5.5, "Male");
		objInfo.academicInfo(22, "Papon", "CSE", 3.5);
		
		Student objStudent = new Student(22,"Papon","CSE",3.5);
		//System.out.println(objStudent);
		
		Scanner input = new Scanner(System.in);
		objStudent.setId(input.nextInt());
		objStudent.setHome_district(input.next());
		objStudent.setHeight(input.nextDouble());
		objStudent.setGender(input.next());
		objStudent.setName(input.next());
		objStudent.setDept(input.next());
		objStudent.setCgpa(input.nextDouble());
		
		System.out.println(objStudent.getId());
		System.out.println(objStudent.getHome_district());
		System.out.println(objStudent.getHeight());
		System.out.println(objStudent.getGender());
		System.out.println(objStudent.getName());
		System.out.println(objStudent.getDept());
		System.out.println(objStudent.getCgpa());
		input.close();
	}
}
