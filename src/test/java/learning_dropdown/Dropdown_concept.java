package learning_dropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_concept {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://automationwithpiyush.vercel.app/signup.html");
		
		WebElement dayDD=driver.findElement(By.id("day"));
		Select daySel=new Select(dayDD);
		daySel.selectByIndex(0);
		Thread.sleep(2000);
		daySel.selectByValue("2");
		Thread.sleep(2000);
		daySel.selectByVisibleText("3");
		Thread.sleep(2000);
		WebElement w=daySel.getFirstSelectedOption();
		System.out.println(w);
		if(daySel.isMultiple()) {
			daySel.deselectAll();
		}
		driver.quit();
	}

}
