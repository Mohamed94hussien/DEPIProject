package Project.ClinicManagement;

public abstract class Person {

	protected String name;
	protected int age;
	protected String gender;

	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public abstract String getRole();
}
