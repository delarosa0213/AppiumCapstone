package Android.tests.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class Login_Page {
    private AndroidDriver driver;

    public Login_Page(AndroidDriver driver) 
    {
        this.driver = driver;
    }

    public void credentials(String email, String password) {
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/tv_username")).sendKeys(email);
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/tv_password")).sendKeys(password);
    	
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    	
    	public void getUserFromExcel(String filePath, int row) throws IOException {
            // Open the Excel file
            FileInputStream file = new FileInputStream(new File(filePath));

            // Get the workbook instance for XLSX file format
            Workbook workbook = WorkbookFactory.create(file);

            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);

            // Get the values from the Excel sheet
            String email = sheet.getRow(row).getCell(0).getStringCellValue();
            String password = sheet.getRow(row).getCell(1).getStringCellValue();

            // Close the Excel file
            file.close();

            // Fill in the registration form
            credentials(email,password);
            

        	driver.findElement(By.id("com.example.proiectmobilebanking:id/login_button")).click();
    }
}
    
