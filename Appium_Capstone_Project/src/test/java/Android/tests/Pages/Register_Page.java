package Android.tests.Pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class Register_Page {
	private AndroidDriver driver;
	
	public Register_Page(AndroidDriver driver) 
    {
        this.driver = driver;
    }
	
	public void btnReg() {
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/register_button_main")).click();
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_firstName")).sendKeys("Red");
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_lastName")).sendKeys("dela Rosa");
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_email")).sendKeys("rostel@gmail.com");
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_iban")).sendKeys("63987654321");
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_password")).sendKeys("rostel");
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_confirmPassword")).sendKeys("rostel");
    	
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/rb_male")).click();
    	
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/bt_register")).click();
    }


}
