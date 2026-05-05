package learning_webelement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElement_Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://automationwithpiyush.vercel.app/signup.html");
		WebElement FirstName=driver.findElement(By.name("firstname"));
		//Actions methods
		FirstName.sendKeys("Times");
		FirstName.clear();
		FirstName.sendKeys("Deepak");
		WebElement SignUpCTA=driver.findElement(By.xpath("//button[@type='submit']"));
	
		
		//Getter Methods
		System.out.println("Tag Name of SignUp button is: "+SignUpCTA.getTagName());
		System.out.println("Text of SignUp button is: "+SignUpCTA.getText());
		System.out.println("Attribute of SignUp button is: "+SignUpCTA.getAttribute("class"));
		System.out.println("CssValue of SignUp button is: "+SignUpCTA.getCssValue("color"));
		
		Dimension st=SignUpCTA.getSize();
		System.out.println("Size is: "+st);
		Point pt=SignUpCTA.getLocation();
		System.out.println("Location is: "+pt);
		Rectangle r=SignUpCTA.getRect();
		int h=r.getHeight();
		System.out.println("Height is: "+h);
		int w=r.getWidth();
		System.out.println("Width is: "+w);
		Dimension d=r.getDimension();
		System.out.println("Dimension is: "+d);
		Point p=r.getPoint();
		System.out.println("Position is: "+p);
		int x=r.getX();
		System.out.println("x length: "+x);
		int y=r.getY();
		System.out.println("y length: "+y);
		
		//Boolean Methods
		WebElement FemaleRadio=driver.findElement(By.xpath("//label[contains(text(),'Female')]//input"));
		if(FemaleRadio.isDisplayed() && FemaleRadio.isEnabled()) 
		{
			FemaleRadio.click();
			if(FemaleRadio.isSelected()) {
				System.out.println("Female is selected");
			}
			else {
				System.out.println("Female is not selected");
			}
		}
		else {
			System.out.println("Female is not displayed or enabled");
		}
		driver.quit();
	}

}
