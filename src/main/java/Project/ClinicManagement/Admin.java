package Project.ClinicManagement;

public class Admin extends Person {

    public Admin(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String getRole() {
        return "Admin";
    }
}
