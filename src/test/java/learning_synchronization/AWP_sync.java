package learning_synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AWP_sync {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://automationwithpiyush.vercel.app/synchronization.html");

//		click on start process
//		WebElement start = driver.findElement(By.xpath("//button[contains(text(),'START PROCESS')]"));
//		start.click();
		
//		click on stop process
//		WebElement stop = driver.findElement(By.xpath("//button[contains(text(),'STOP PROCESS')]"));
//		stop.click();
		
//		explicit wait
		
//		click on unlock
		WebElement unlock = driver.findElement(By.id("trigger-display"));
		unlock.click();		
		
//		clear the value
		WebElement target = driver.findElement(By.id("target-display"));
				
//		we need to explicitly wait for element to be clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(target));
				
		
		target.clear(); // InvalidElementStateException: Element is not currently interactable 
		target.sendKeys("hey there...."); // ElementNotInteractableException: element not interactable
		
		
		Thread.sleep(3000);
		driver.quit();
	}
}