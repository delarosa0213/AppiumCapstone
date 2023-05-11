package Android.tests.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class Transaction_Page {
	private AndroidDriver driver;
	
	public Transaction_Page(AndroidDriver driver) {
	    this.driver = driver;
	  }
	
	public void transacHistory1(String firstAccName, String iban1, String amount1) {
		
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/btnHistory")).click();
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/fabAdd")).click();
    	
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//Add 1st acc
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_beneficiary2")).sendKeys(firstAccName);
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_accountNumber2")).sendKeys(iban1);
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_amount2")).sendKeys(amount1);
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/btn_send2")).click();
    	
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public void transacHistory2(String secAccName, String iban2, String amount2) {

	    driver.findElement(By.id("com.example.proiectmobilebanking:id/fabAdd")).click();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block				
			e.printStackTrace();
		}	
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_beneficiary2")).sendKeys(secAccName);
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_accountNumber2")).sendKeys(iban2);
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_amount2")).sendKeys(amount2);
    	
    	
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/spinner_status")).click();
    	driver.findElement(By.xpath("(//android.widget.TextView)[2]")).click();
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/btn_send2")).click();
    	
    	String firstAcc = driver.findElement(By.xpath("(//android.widget.TextView)[1]")).getText();
    	System.out.println("Validated First Account: " + firstAcc);
    	
    	driver.findElement(By.xpath("(//android.view.ViewGroup)[4]")).click();
    	String secAcc = driver.findElement(By.xpath("(//android.widget.TextView)[5]")).getText();
    	System.out.println("Validated Second Account: " + secAcc);
    }

	
	public void getUserFromExcel1(String filePath, int row2) throws IOException {
        // Open the Excel file
        FileInputStream file = new FileInputStream(new File(filePath));

        // Get the workbook instance for XLSX file format
        Workbook workbook = WorkbookFactory.create(file);

        // Get the first sheet
        Sheet sheet = workbook.getSheetAt(0);
        


        // Get the values from the Excel sheet first Acc
        String firstAccName = sheet.getRow(row2).getCell(2).getStringCellValue();
        
        Cell ibanCell = sheet.getRow(row2).getCell(4);
        String iban1 = "";
        if(ibanCell.getCellType() == CellType.NUMERIC) {
            iban1 = String.valueOf((long) ibanCell.getNumericCellValue());
        } else {
            iban1 = ibanCell.getStringCellValue();
        }
        
        Cell amountCell = sheet.getRow(row2).getCell(5);
        String amount1 = "";
        if(amountCell.getCellType() == CellType.NUMERIC) {
        	amount1 = String.valueOf((long) amountCell.getNumericCellValue());
        } else {
        	amount1 = amountCell.getStringCellValue();
        }

        // Fill in the registration form
        transacHistory1(firstAccName, iban1, amount1);
	}
        
      public void getUserFromExcel2(String filePath, int row3) throws IOException {
            // Open the Excel file
    	FileInputStream file = new FileInputStream(new File(filePath));

            // Get the workbook instance for XLSX file format
       	Workbook workbook = WorkbookFactory.create(file);

            // Get the first sheet
       	Sheet sheet = workbook.getSheetAt(0);        
        //2nd beneficiary acc
        String secAccName = sheet.getRow(row3).getCell(2).getStringCellValue();
        
        Cell ibanCell2 = sheet.getRow(row3).getCell(4);
        String iban2 = "";
        if(ibanCell2.getCellType() == CellType.NUMERIC) {
            iban2 = String.valueOf((long) ibanCell2.getNumericCellValue());
        } else {
            iban2 = ibanCell2.getStringCellValue();
        }
        
        
        Cell amountCell2 = sheet.getRow(row3).getCell(5);
        String amount2 = "";
        if(amountCell2.getCellType() == CellType.NUMERIC) {
        	amount2 = String.valueOf((long) amountCell2.getNumericCellValue());
        } else {
        	amount2 = amountCell2.getStringCellValue();
        }

        // Close the Excel file
        file.close();
        
        transacHistory2(secAccName, iban2, amount2);

       
 }

    public void transactions(String amountSearch) {
    	driver.navigate().back();
    	
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/btnRaport")).click();
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/btnRaportAmount")).click();
    	
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/etRaportAmount")).sendKeys(amountSearch);
    	
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/btnViewRaportAmount")).click();
    	
    	//validating 1st account
    	WebElement firstAcc = driver.findElement(By.xpath("(//android.widget.TextView)[1]"));
    	if(firstAcc.isDisplayed()) {
    	    System.out.println("Element is displayed");
    	} else {
    	    System.out.println("Element is not displayed");
    	}
    	
    	//validating 2nd acc
    	WebElement secAcc = driver.findElement(By.xpath("(//android.widget.TextView)[5]"));
    	if(secAcc.isDisplayed()) {
    	    System.out.println("Element is displayed");
    	} else {
    	    System.out.println("Element is not displayed");
    	}
    	 
}
    public void searchAmount(String filePath, int row4) throws IOException{
    	// Open the Excel file
        FileInputStream file = new FileInputStream(new File(filePath));

        // Get the workbook instance for XLSX file format
        Workbook workbook = WorkbookFactory.create(file);

        // Get the first sheet
        Sheet sheet = workbook.getSheetAt(0);
        
        Cell amountCell3 = sheet.getRow(row4).getCell(5);
        String amountSearch = "";
        if(amountCell3.getCellType() == CellType.NUMERIC) {
        	amountSearch = String.valueOf((long) amountCell3.getNumericCellValue());
        } else {
        	amountSearch = amountCell3.getStringCellValue();
        }
        file.close();
        transactions(amountSearch);
	}
    
}