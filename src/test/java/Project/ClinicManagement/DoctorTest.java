package Project.ClinicManagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoctorTest {

    @Test
    public void testDoctorCreation() {
        // Create a new Doctor object
        Doctor doctor = new Doctor("Dr. Mohammed", 45, "Male", "Cardiology");

        // Test if the name, age, gender, and specialty are set correctly
        assertEquals("Dr. Mohammed", doctor.getName());
        assertEquals(45, doctor.getAge());
        assertEquals("Male", doctor.getGender());
        assertEquals("Cardiology", doctor.getSpecialty());
    }

    @Test
    public void testGetSpecialty() {
        // Create a new Doctor object
        Doctor doctor = new Doctor("Dr. Fatma", 50, "Female", "Neurology");

        // Test if the getSpecialty method returns the correct specialty
        assertEquals("Neurology", doctor.getSpecialty());
    }

    @Test
    public void testGetRole() {
        // Create a new Doctor object
        Doctor doctor = new Doctor("Dr. Ali", 38, "Male", "Pediatrics");

        // Test if the getRole method returns "Doctor"
        assertEquals("Doctor", doctor.getRole());
    }
}