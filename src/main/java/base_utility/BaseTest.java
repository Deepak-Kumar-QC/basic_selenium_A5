package base_utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import generic_utility.FileUtility;


public class BaseTest {
	public static WebDriver driver;
	
	@BeforeClass
	public void openBro() throws IOException {
		FileUtility file=new FileUtility();
			String BROWSER=file.getDataFromPropertiesFile("bro");
			if(BROWSER.equals("chrome")) {
				driver=new ChromeDriver();
			}
			else if(BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
			}else if(BROWSER.equals("edge")) {
				driver=new EdgeDriver();
			}else {
				driver=new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
	}
	@BeforeMethod
	public void login() throws IOException {
		FileUtility file=new FileUtility();
		String url=file.getDataFromPropertiesFile("url");
		driver.get(url);
		String un=	file.getDataFromPropertiesFile("un"); 
		driver.findElement(By.name("username")).sendKeys(un);
		String pass=	file.getDataFromPropertiesFile("pass");
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Successfully LoggedIn!");
	}
	@AfterMethod
	public void logout() {
		System.out.println("logout");
	}

	@AfterClass
	public void closeBro() {
		driver.quit();
	}
}
