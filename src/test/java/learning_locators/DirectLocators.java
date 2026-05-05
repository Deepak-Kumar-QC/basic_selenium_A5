package learning_locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DirectLocators {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		driver.get("https://automationwithpiyush.vercel.app/signup.html");
//
//		WebElement un = driver.findElement(By.name("firstname"));
//		un.sendKeys("admin");
//
//		driver.findElement(By.cssSelector("input[placeholder='Surname']")).sendKeys("kumar");

		driver.get("https://www.amazon.com");
		Thread.sleep(3000);
		List<WebElement> links = driver.findElements(By.tagName("a"));

		int length = links.size();
		System.out.println(length);

		Thread.sleep(2000);
		driver.quit();
	}
}