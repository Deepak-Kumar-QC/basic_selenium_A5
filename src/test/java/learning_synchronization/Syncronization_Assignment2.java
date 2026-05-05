package learning_synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Syncronization_Assignment2 {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://automationwithpiyush.vercel.app/synchronization.html");

	//Implicit Wait
	driver.findElement(By.xpath("//button[contains(text(),'START')]")).click();
	driver.findElement(By.xpath("//button[contains(text(),'STOP')]")).click();
	
	//Explicit Wait
	driver.findElement(By.id("trigger-display")).click();
	WebElement monitorUnlock = driver.findElement(By.id("target-display"));
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.elementToBeClickable(monitorUnlock)).click();
	monitorUnlock.clear();
	monitorUnlock.sendKeys("My name is System Monitor");
	
	driver.findElement(By.id("trigger-input")).click();
	WebElement commandUnlock = driver.findElement(By.id("target-input"));
	
	wait.until(ExpectedConditions.elementToBeClickable(commandUnlock)).click();
	commandUnlock.sendKeys("My name id Command Line");
	}

	
	
}
