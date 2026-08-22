package learning_javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program1 {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	JavascriptExecutor jks=(JavascriptExecutor) driver;
	//Launch url
	jks.executeScript("window.location='https://www.zomato.com/';");
	//Scrolling
	jks.executeScript("window.scrollTo(0,500);");
	Thread.sleep(1000);
	jks.executeScript("window.scrollBy(0,500);");
	Thread.sleep(1000);
	jks.executeScript("window.scrollTo(0,500);");
	//Scrolling to top and bottom
	Thread.sleep(1000);
	jks.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
	Thread.sleep(1000);
	jks.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	//url launch
	jks.executeScript("window.location='https://automationwithpiyush.vercel.app/locatorsSignin.html';");
	//Enter Text
	jks.executeScript("document.getElementById('email').value='admin';");
	Thread.sleep(1000);
	//Click on WebElement
 	jks.executeScript("document.getElementById('terms_checkbox').click();");
 	
	WebElement e1=driver.findElement(By.id("email"));
	WebElement e2=driver.findElement(By.id("terms_checkbox"));
	jks.executeScript("arguments[0].value='Admin';",e1);
	jks.executeScript("arguments[1].click();",e1,e2);
	//launch url
	jks.executeScript("window.location='https://www.zomato.com/';");
	WebElement blinkit = driver.findElement(By.xpath("//div[text()='blinkit']"));
	Thread.sleep(2000);
	//Scroll in View top and bottom
	jks.executeScript("arguments[0].scrollIntoView(false);", blinkit);
	Thread.sleep(2000);
	jks.executeScript("arguments[0].scrollIntoView(true);", blinkit);
	
	driver.quit();
	}
	
}
