package Android.tests.Pages;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Register_PageExcel {
    private AndroidDriver driver;

    public Register_PageExcel(AndroidDriver driver) {
        this.driver = driver;
    }

    public void btnReg(String firstName, String lastName, String email, String iban, String password) {
        driver.findElement(By.id("com.example.proiectmobilebanking:id/register_button_main")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("com.example.proiectmobilebanking:id/et_firstName")).sendKeys(firstName);
        driver.findElement(By.id("com.example.proiectmobilebanking:id/et_lastName")).sendKeys(lastName);
        driver.findElement(By.id("com.example.proiectmobilebanking:id/et_email")).sendKeys(email);
        driver.findElement(By.id("com.example.proiectmobilebanking:id/et_iban")).sendKeys(iban);
        driver.findElement(By.id("com.example.proiectmobilebanking:id/et_password")).sendKeys(password);
        driver.findElement(By.id("com.example.proiectmobilebanking:id/et_confirmPassword")).sendKeys(password);

        driver.findElement(By.id("com.example.proiectmobilebanking:id/rb_male")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("com.example.proiectmobilebanking:id/bt_register")).click();
    }

    public void registerUserFromExcel(String filePath, int row) throws IOException {
        // Open the Excel file
        FileInputStream file = new FileInputStream(new File(filePath));

        // Get the workbook instance for XLSX file format
        Workbook workbook = WorkbookFactory.create(file);

        // Get the first sheet
        Sheet sheet = workbook.getSheetAt(0);

        // Get the values from the Excel sheet
        String firstName = sheet.getRow(row).getCell(2).getStringCellValue();
        String lastName = sheet.getRow(row).getCell(3).getStringCellValue();
        String email = sheet.getRow(row).getCell(0).getStringCellValue();
        Cell ibanCell = sheet.getRow(row).getCell(4);
        String iban = "";
        if(ibanCell.getCellType() == CellType.NUMERIC) {
            iban = String.valueOf((long) ibanCell.getNumericCellValue());
        } else {
            iban = ibanCell.getStringCellValue();
        }
        String password = sheet.getRow(row).getCell(1).getStringCellValue();

        // Close the Excel file
        file.close();

        // Fill in the registration form
        btnReg(firstName, lastName, email, iban, password);
    }
}
