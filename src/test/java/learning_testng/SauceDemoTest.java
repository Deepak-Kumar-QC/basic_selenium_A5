package learning_testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceDemoTest {
	@Test(dataProvider="getData")
	public void login(String un,String pw) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.saucedemo.com/");
		try {
		//enter username
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pw);
		//click on login button
		driver.findElement(By.id("login-button")).click();
		
		boolean status = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(status);
		}
		finally{
		Thread.sleep(1000);
		driver.quit();
		}
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] loginData=new Object[6][2];
		
		loginData[0][0]="standard_user";
		loginData[0][1]="secret_sauce";
		
		loginData[1][0]="locked_out_user";
		loginData[1][1]="secret_sauce";
		
		loginData[2][0]="problem_user";
		loginData[2][1]="secret_sauce";
		
		loginData[3][0]="performance_glitch_user";
		loginData[3][1]="secret_sauce";
		
		loginData[4][0]="error_user";
		loginData[4][1]="secret_sauce";
		
		loginData[5][0]="visual_user";
		loginData[5][1]="secret_sauce";
		return loginData;
	}
}
