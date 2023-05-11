package Android.tests.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AccountDeletion_Page {
	private AndroidDriver driver;

	public AccountDeletion_Page(AndroidDriver driver) {
	    this.driver = driver;
	  }
	
	public void DeleteAcc() {
    	driver.navigate().back();
    	driver.navigate().back();
    	
    	WebElement delBtn = driver.findElement(By.id("com.example.proiectmobilebanking:id/btnDeleteAccount"));
    	
    	if (delBtn.isDisplayed()) {
    		delBtn.click();
    	}
    	else {
    		System.out.println("Element is not available");
    	}

}
}
