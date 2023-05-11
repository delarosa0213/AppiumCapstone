package Android.tests.Test;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcel {
    public static void main(String[] args) {
        String filePath = "ExcelFile/credentials.xlsx";
        try {
            FileInputStream fis = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            
            Row row = sheet.getRow(1);
            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();
            String firstname = row.getCell(2).getStringCellValue();
            String lastname = row.getCell(3).getStringCellValue();
            String iban = String.valueOf(row.getCell(4).getNumericCellValue());
            
            //1st acc
            Row row2 = sheet.getRow(2);
            String firstname1 = row2.getCell(2).getStringCellValue();

            
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("Firstname: " + firstname);
           
            System.out.println("Lastname: " + lastname);
            System.out.println("IBAN: " + iban);
            
            System.out.println("Firstname1: " + firstname1);
            
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
