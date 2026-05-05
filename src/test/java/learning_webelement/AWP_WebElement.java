package learning_webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AWP_WebElement {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://automationwithpiyush.vercel.app/signup.html");

//		ACTIONS
		Thread.sleep(3000);
		WebElement fn = driver.findElement(By.name("firstname"));
		fn.sendKeys("admin");

		Thread.sleep(1000);
		fn.clear();

		Thread.sleep(1000);
		fn.sendKeys("admin@1234");

		WebElement signup = driver.findElement(By.tagName("button"));

//		GETTERS
		String tag = signup.getTagName();
		String type = signup.getAttribute("type");
		String bg = signup.getCssValue("background-color");
		String vt = signup.getText();

		System.out.println("Tagname of button is : " +tag);
		System.out.println(type);
		System.out.println(bg);
		System.out.println(vt);

		Dimension dim = signup.getSize();
		System.out.println(dim);

		Point pt = signup.getLocation();
		System.out.println(pt);

		Rectangle rect = signup.getRect();
		int x = rect.getX();
		System.out.println(x);

//		signup.click();
//		signup.submit();

		Thread.sleep(1000);
		WebElement maleRadio = driver.findElement(By.xpath("//label[contains(text(),'Male')]/input"));

//		VERIFICATION/VALIDATION/BOOLEAN
		if (maleRadio.isDisplayed() && maleRadio.isEnabled()) {
			maleRadio.click();
			if (maleRadio.isSelected()) {
				System.out.println("Male is selected....");
			}
		}

		Thread.sleep(3000);
		driver.quit();
	}
}