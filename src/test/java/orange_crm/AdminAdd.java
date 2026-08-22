package orange_crm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminAdd {

	public static void main(String[] args) {

		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Successfully LoggedIn");
		driver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		WebElement roleDrop = driver.findElement(By.xpath("(//div[contains(text(),'-- Select --')])[1]"));
		roleDrop.click();
		driver.findElement(By.xpath("//div[contains(text(),'Admin')]")).click();
		driver.findElement(By.cssSelector("input[placeholder='Type for hints...']")).sendKeys("Deepak");
		WebElement statusDrop = driver.findElement(By.xpath("(//div[contains(text(),'-- Select --')])[2]"));
	}

}
