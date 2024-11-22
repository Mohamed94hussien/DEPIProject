package Project.ClinicManagement;

public class Patient extends Person {
    private String disease;

    public Patient(String name, int age, String gender, String disease) {
        super(name, age, gender);
        this.disease = disease;
    }

    public String getDisease() {
        return disease;
    }

    @Override
    public String getRole() {
        return "Patient";
    }
}
