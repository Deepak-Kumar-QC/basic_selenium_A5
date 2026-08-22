package learning_iframe;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://automationwithpiyush.vercel.app/frames.html");
		driver.switchTo().frame(0);
		driver.findElement(By.id("name_input")).sendKeys("Deepak Kumar");
		driver.switchTo().parentFrame();
		driver.switchTo().frame(2);
	
		driver.findElement(By.cssSelector("input[value='O-']")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(3);
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		driver.findElement(By.id("secret_code")).sendKeys("times@123");
		driver.switchTo().defaultContent();
		driver.quit();
	}

}
