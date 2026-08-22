package learning_dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice_dropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		driver.get("https://automationwithpiyush.vercel.app/dropdown.html");
		WebElement drop = driver.findElement(By.id("single-select"));
		Select sel = new Select(drop);
		sel.selectByVisibleText("New York, USA");
		WebElement multiDrop = driver.findElement(By.id("multi-select"));
		Select sel1 = new Select(multiDrop);
		if (sel1.isMultiple()) {
			sel1.selectByIndex(0);
			sel1.selectByIndex(1);
			sel1.selectByIndex(2);
			sel1.selectByVisibleText("RestAssured API");
			sel1.selectByValue("jen");

			List<WebElement> selectedOptions = sel1.getAllSelectedOptions();
			System.out.println("Total selected options: " + selectedOptions.size());
			System.out.println("Selected Options are below:");
			for (WebElement option : selectedOptions) {
				System.out.println(option.getText());
			}
			sel1.deselectByIndex(2);
			sel1.deselectByValue("jen");
			sel1.deselectByVisibleText("RestAssured API");
			WebElement firstSelected = sel1.getFirstSelectedOption();
			System.out.println("Get First Selected option: " + firstSelected.getText());
			List<WebElement> allSelectedOptions = sel1.getAllSelectedOptions();
			System.out.println("After deselection options: " + allSelectedOptions.size());
			System.out.println("After Deselection remaining Options are selected below:");
			for (WebElement option : allSelectedOptions) {
				System.out.println(option.getText());
			}
			sel1.deselectAll();
			List<WebElement> finalOptions = sel1.getAllSelectedOptions();

			System.out.println("Size after deselection all option: "+finalOptions.size());
			System.out.println("Deselected All Successfully.");
		} else {
			System.out.println("It is not multiselection dropdown");
		}
		driver.quit();
	}
}
