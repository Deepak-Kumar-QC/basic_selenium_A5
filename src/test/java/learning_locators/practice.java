package learning_locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://automationwithpiyush.vercel.app/locators.html");
	driver.findElement(By.id("login-username")).sendKeys("Deepak");
	driver.findElement(By.name("user_email_address")).sendKeys("deepak.kumar@gmail.com");
	driver.findElement(By.linkText("Go to Dashboard")).click();
	List<WebElement> un=driver.findElements(By.tagName("a"));
	int m=un.size();
	System.out.println(m);
	driver.quit();
}
}
