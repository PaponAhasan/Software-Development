package Lab_05;

public class Student extends PersonalInfo {
    
	public Student(int id, String name, String dept, double cgpa) {
		super(id, name, dept, cgpa);
	}

	@Override
	void personalAddress(int id, String home_district, Double height, String gender) {
		System.out.println(id);
		System.out.println(home_district);
		System.out.println(height);
		System.out.println(gender);
	}

	@Override
	void academicInfo(int id, String name, String dept, double cgpa) {
		System.out.println(id);
		System.out.println(name);
		System.out.println(dept);
		System.out.println(cgpa);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHome_district() {
		return home_district;
	}

	public void setHome_district(String home_district) {
		this.home_district = home_district;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
     
}
