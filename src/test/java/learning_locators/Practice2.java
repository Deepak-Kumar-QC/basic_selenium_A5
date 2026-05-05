package learning_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice2 {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://automationwithpiyush.vercel.app/locatorsSignin.html");
	driver .findElement(By.xpath("//input[@id='email']")).sendKeys("deepak.kumar@gmail.com");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
	driver.findElement(By.xpath("//input[@id='terms_checkbox']")).click();
	driver.findElement(By.xpath("//button[contains(text(),'Secure Login')]")).click();

	}

}
