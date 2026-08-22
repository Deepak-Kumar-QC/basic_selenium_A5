package learning_Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://automationwithpiyush.vercel.app/actions.html");

		WebElement hoverEle = driver.findElement(By.xpath("//button[contains(text(),'Hover')]"));
		Actions act = new Actions(driver);
		// hover
		act.moveToElement(hoverEle).build().perform();
		// click
		WebElement clickEle = driver.findElement(By.id("click-icon"));
		act.click(clickEle).build().perform();
		// Rightclick
		WebElement rightEle = driver.findElement(By.id("right-click-area"));
		act.contextClick(rightEle).build().perform();
		// Doubleclick
		WebElement doubleEle = driver.findElement(By.id("double-click-area"));
		act.doubleClick(doubleEle).build().perform();
		// click And Hold+release
		WebElement holdEle = driver.findElement(By.id("hold-icon"));
		act.clickAndHold(holdEle).pause(Duration.ofSeconds(3)).release().build().perform();
		// scrollActions
		act.scrollByAmount(0, 100).pause(Duration.ofSeconds(1)).build().perform();
		// dragAndDrop
		WebElement dragSourceEle = driver.findElement(By.id("prod-laptop"));
		WebElement dragDestEle = driver.findElement(By.id("cart-zone"));
		act.moveToElement(dragDestEle).dragAndDrop(dragSourceEle, dragDestEle).build().perform();
		// RangeSlider
		act.scrollByAmount(0, 100).pause(Duration.ofSeconds(1)).scrollByAmount(0, 100).pause(Duration.ofSeconds(1))
				.scrollByAmount(0, 100).build().perform();
		WebElement pulseSlider = driver.findElement(By.id("pulse-slider"));
		act.scrollByAmount(0, 100).build().perform();
		driver.quit();
	}

}
