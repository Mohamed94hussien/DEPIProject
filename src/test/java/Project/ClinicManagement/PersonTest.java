package Project.ClinicManagement;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	// Test if the constructor correctly initializes the fields
    @Test
    public void testPersonConstructor() {
        Patient patient = new Patient("John Doe", 30, "Male", "Flu");

        assertEquals("John Doe", patient.getName());
        assertEquals(30, patient.getAge());
        assertEquals("Male", patient.getGender());
    }

    // Test if the getName method returns the correct value
    @Test
    public void testGetName() {
        Patient patient = new Patient("Alice", 25, "Female", "Cold");

        assertEquals("Alice", patient.getName());
    }

    // Test if the getAge method returns the correct value
    @Test
    public void testGetAge() {
        Patient patient = new Patient("Bob", 45, "Male", "Allergy");

        assertEquals(45, patient.getAge());
    }

    // Test if the getGender method returns the correct value
    @Test
    public void testGetGender() {
        Patient patient = new Patient("Mary", 35, "Female", "Fever");

        assertEquals("Female", patient.getGender());
    }

    // Test if the getRole method returns the correct role for Patient
    @Test
    public void testGetRole() {
        Patient patient = new Patient("John Doe", 30, "Male", "Flu");

        assertEquals("Patient", patient.getRole());
    }
	
	
}
