package learning_TakeScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Program1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.facebook.com/");
		//downcasting
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("./errorShots/ss"+Math.random()+".png");
		FileHandler.copy(source, destination);
		Thread.sleep(2000);
		WebElement login=driver.findElement(By.cssSelector("div[aria-label='Log in']"));
		File s1=login.getScreenshotAs(OutputType.FILE);
		File d1=new File("./errorShots/ss"+Math.random()+".png");
		FileHandler.copy(s1, d1);
		System.out.println("ScreenShot taken successfully");
		driver.quit();
	}

}
