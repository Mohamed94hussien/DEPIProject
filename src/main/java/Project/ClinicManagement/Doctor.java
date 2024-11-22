package Project.ClinicManagement;

public class Doctor extends Person {
    private String specialty;

    public Doctor(String name, int age, String gender, String specialty) {
        super(name, age, gender);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public String getRole() {
        return "Doctor";
    }
}
