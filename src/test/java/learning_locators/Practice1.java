package learning_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		WebElement ub=driver.findElement(By.id("username"));
		ub.sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.cssSelector("button[id='submit']")).click();
		String exp="Logged-In-Successfully";
		String act=driver.getCurrentUrl();
		if(act.contains(exp))
			System.out.println("URL is Matched");
		else {
			System.out.println("URL is not matched");
		}
		
		String text=driver.findElement(By.xpath("//h1[@class='post-title']")).getText();

		if(text.contains("Successfully") || text.contains("Congratulations")) {
			System.out.println("✅ Success message verified");
        } else {
            System.out.println("❌ Success message NOT verified");
        }
			
			WebElement loginText=driver.findElement(By.xpath("//a[text()='Log out']"));
			if(loginText.isDisplayed()) {
				System.out.println("Login Button is displayed");
			}
			else {
				System.out.println("Login button is not displayed.");
			}
			
			
			driver.get("https://practicetestautomation.com/practice-test-login/");
			WebElement ub1=driver.findElement(By.id("username"));
			ub1.sendKeys("incorrectUser");
			driver.findElement(By.name("password")).sendKeys("Password123");
			driver.findElement(By.cssSelector("button[id='submit']")).click();
			String exp3="Your username is invalid!";
			String u=driver.findElement(By.cssSelector(".show")).getText();
			
			if(u.contains(exp3))
				System.out.println("Your username is invalid!");
			else {
				System.out.println("Passed");
			}
			
			driver.get("https://practicetestautomation.com/practice-test-login/");
			WebElement ub3=driver.findElement(By.id("username"));
			ub3.sendKeys("student");
			driver.findElement(By.name("password")).sendKeys("incorrectPassword ");
			driver.findElement(By.cssSelector("button[id='submit']")).click();
			String exp4="Your password is invalid!";
			String u1=driver.findElement(By.cssSelector(".show")).getText();
			
			if(u1.contains(exp4))
				System.out.println("Your password is invalid!");
			else {
				System.out.println("Passed");
			}
			
			driver.quit();
		}
	
	
}
