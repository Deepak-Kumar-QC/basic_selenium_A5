package learning_locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws InterruptedException  {
		WebDriver driver=new ChromeDriver();
//		WebElement un=driver.findElement();
//		WebElement un=driver.findElement(Locator);
//		WebElement un=driver.findElement(By.id("ABC"));
		driver.manage().window().maximize();
		driver.get("https://automationwithpiyush.vercel.app/signup.html");
		WebElement un=driver.findElement(By.name("firstname"));
		un.sendKeys("Admin");
		driver.findElement(By.cssSelector("input[placeholder='Surname']")).sendKeys("kumar");
		driver.get("https://www.amazon.in/");
		Thread.sleep(6000);
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int l=links.size();
		System.out.println(l); //372
		driver.quit();
	}

}
