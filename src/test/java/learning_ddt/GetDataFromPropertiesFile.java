package learning_ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {
	WebDriver driver;
	
	FileInputStream fs=new FileInputStream("./src/test/resources/common.properties");
	Properties pObj=new Properties();
	pObj.load(fs);
	
	String BROWSER=pObj.getProperty("bro");
	String URL=pObj.getProperty("url");
	String USERNAME=pObj.getProperty("un");
	String PASSWORD=pObj.getProperty("pass");
	
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
	
	driver.get(URL);
	driver.findElement(By.name("username")).sendKeys(USERNAME);
	driver.findElement(By.name("password")).sendKeys(PASSWORD);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	System.out.println("Successfully LoggedIn!");
	driver.quit();
	}

}
