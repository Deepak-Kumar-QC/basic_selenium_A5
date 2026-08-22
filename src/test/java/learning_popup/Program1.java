package learning_popup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Program1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://admin:admin@automationwithpiyush.vercel.app/popups.html");
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("Deepak Kumar");
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[onclick='triggerAlert()']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[onclick='triggerConfirm()']")).click();
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[onclick='triggerConfirm()']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[onclick='triggerPrompt()']")).click();
		driver.switchTo().alert().sendKeys("admin");
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		System.out.println("Parent window id: "+parent);
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.cssSelector("button[onclick='openMultipleWindows()']"));
		act.scrollToElement(ele).build().perform();
		Thread.sleep(2000);
		ele.click();
		Thread.sleep(2000);
		for (String s : driver.getWindowHandles()) {

			if (!s.equals(parent)) {
				driver.switchTo().window(s);
				System.out.println("Child Window id: "+s);
				System.out.println("Title : " + driver.getTitle());

				driver.close();
			}
		}
		driver.switchTo().window(parent);
		driver.quit();
	}

}
