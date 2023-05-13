package Android.tests.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

public class Login_Page {
    private AndroidDriver driver;
    ExtentTest test;

    public Login_Page(AndroidDriver driver, ExtentTest test) 
    {
        this.driver = driver;
        this.test = test;
    }

    public void credentials(String email, String password) throws InterruptedException {
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/tv_username")).sendKeys(email);
    	test.log(LogStatus.INFO,"Username from excel file: " + email);
    	
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/tv_password")).sendKeys(password);
    	test.log(LogStatus.INFO,"Password from excel file: " + password);
    	
		Thread.sleep(3000);
    }
		
    	
    	public void getUserFromExcel(String filePath, int row) throws IOException, InterruptedException {
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
        	test.log(LogStatus.PASS, "Successfully passed the information from excel!");
    }
}
    
