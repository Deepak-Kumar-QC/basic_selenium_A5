package orange_crm;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PimAdd {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Successfully LoggedIn!");
		
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		
		driver.findElement(By.name("firstName")).sendKeys("Deepak");
		driver.findElement(By.name("lastName")).sendKeys("Kumar");
		
		File file = new File("C:\\Users\\deepak.Kumar14\\Downloads\\pic.jpg");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(file.getAbsolutePath());
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		By successToast = By.xpath("//div[contains(@class,'oxd-toast--success')]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		boolean status = wait.until(ExpectedConditions.visibilityOfElementLocated(successToast)).isDisplayed();
		System.out.println("Candidate Added Successfully : " + status);
		String expectedName = "Deepak";
		String expectedLastName = "Kumar";

		String actualName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")))
				.getAttribute("value");

		String actualLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")))
				.getAttribute("value");

		if (actualName.equals(expectedName) && actualLastName.equals(expectedLastName)) {

			System.out.println("Name & Last Name are matching!");
		} else {

			System.out.println("Name & Last Name are not matching!");

			System.out.println("Expected First Name : " + expectedName);
			System.out.println("Actual First Name   : " + actualName);

			System.out.println("Expected Last Name  : " + expectedLastName);
			System.out.println("Actual Last Name    : " + actualLastName);
		}
		Thread.sleep(10000);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("./errorShots/ps"+Math.random()+".png");
		FileHandler.copy(source, destination);
		
		driver.findElement(By.cssSelector("p[class='oxd-userdropdown-name']")).click();
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Successfully Logged Out!");
		driver.quit();
	}
	
}
