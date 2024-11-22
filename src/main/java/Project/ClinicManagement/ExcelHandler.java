package Project.ClinicManagement;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHandler {

    private static final String FILE_PATH = "patients_data.xlsx";

    // Write patient data to Excel file
    public static void writeDataToExcel(List<Patient> patients) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Patients");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Name");
        headerRow.createCell(1).setCellValue("Age");
        headerRow.createCell(2).setCellValue("Gender");
        headerRow.createCell(3).setCellValue("Disease");

        // Write patient data
        int rowCount = 1;
        for (Patient patient : patients) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(patient.getName());
            row.createCell(1).setCellValue(patient.getAge());
            row.createCell(2).setCellValue(patient.getGender());
            row.createCell(3).setCellValue(patient.getDisease());
        }

        // Write to file
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
            workbook.write(fos);
        }

        workbook.close();
    }

    // Read patient data from Excel file
    public static List<String[]> readDataFromExcel() throws IOException {
        List<String[]> data = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();
                String[] rowData = new String[row.getLastCellNum()];

                for (int i = 0; i < row.getLastCellNum(); i++) {
                    rowData[i] = row.getCell(i).toString();
                }

                data.add(rowData);
            }
        }

        return data;
    }

    // Search for a patient in Excel by name
    public static String searchPatientInExcel(String name) throws IOException {
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();
                String patientName = row.getCell(0).toString();
                if (patientName.equalsIgnoreCase(name)) {
                    StringBuilder patientData = new StringBuilder();
                    for (int i = 0; i < row.getLastCellNum(); i++) {
                        patientData.append(row.getCell(i).toString()).append("\t");
                    }
                    return patientData.toString();
                }
            }
        }

        return null;  // Return null if patient not found
    }

    // Delete a patient from Excel by name
    public static boolean deletePatientFromExcel(String name) throws IOException {
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            boolean found = false;

            while (iterator.hasNext()) {
                Row row = iterator.next();
                String patientName = row.getCell(0).toString();
                if (patientName.equalsIgnoreCase(name)) {
                    int rowIndex = row.getRowNum();
                    sheet.removeRow(row);
                    found = true;
                    break;
                }
            }

            // If found, rewrite the sheet without the deleted row
            if (found) {
                try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
                    workbook.write(fos);
                }
            }

            return found;
        }
    }
}
