package Android.tests.Test;

import io.appium.java_client.android.AndroidDriver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Android.tests.Pages.AccountDeletion_Page;
import Android.tests.Pages.AddAccount_Page;
import Android.tests.Pages.Login_Page;
import Android.tests.Pages.Register_PageExcel;
import Android.tests.Pages.Transaction_Page;

public class AppiumMain {
	private AndroidDriver driver;
	
	 private LaunchingDevice base;
	 //private Register_Page reg;
	 private Register_PageExcel reg;
	 private Login_Page login;
	 private AddAccount_Page addAcc;
	 private Transaction_Page transact;
	 private AccountDeletion_Page accDel;

//	 configureAppLaunch();
//     btnReg();
//     credentials();
//     transacHistory();
//     transactions();
//     DeleteAcc();
//     credentials();
	
	 @BeforeClass
	 public void setup() {
		 
		 reg = new Register_PageExcel(driver);
		 
	 }
	 @Test(priority = 1)
	 public void applLaunch() throws MalformedURLException, FileNotFoundException {
		 base = new LaunchingDevice();
		 driver = base.configureAppLaunch();
  }
	 @Test(priority = 2)
	 public void Register() throws IOException {
	     Register_PageExcel reg = new Register_PageExcel(driver);
	     reg.registerUserFromExcel("src/test/java/utils/loginCredentials.xlsx", 1);
	 }

	 @Test(priority = 3)
	 public void Login() throws IOException {
		 Login_Page login =  new Login_Page(driver);
		 login.getUserFromExcel("src/test/java/utils/loginCredentials.xlsx", 1);
	 }
	 @Test(priority = 4)
	 public void transactHistory() throws IOException {
		 Transaction_Page transact = new Transaction_Page(driver);
		 transact.getUserFromExcel1("src/test/java/utils/credentials.xlsx", 2);
	 }
	 @Test(priority = 5)
	 public void transactHistory2() throws IOException {
		 Transaction_Page transact = new Transaction_Page(driver);
		 transact.getUserFromExcel2("src/test/java/utils/credentials.xlsx", 3);
	 }
	 @Test(priority = 6)
	 public void trans() throws IOException {
		 Transaction_Page transact = new Transaction_Page(driver);
		 transact.searchAmount("src/test/java/utils/credentials.xlsx", 3);
	 }
	 @Test(priority = 7)
	 public void delAccount() {
		 AccountDeletion_Page accDel = new AccountDeletion_Page(driver);
		 accDel.DeleteAcc();
	 }
	 @Test(priority = 8)
	 public void testLogin() throws IOException {
		 Login_Page login =  new Login_Page(driver);
		 login.getUserFromExcel("src/test/java/utils/loginCredentials.xlsx", 1);
	 }
	 
	 @AfterClass
	 public void quit() {
		 driver.quit();
	 }
	
}
