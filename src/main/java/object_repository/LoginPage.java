package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
		
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="username")
	private WebElement un;
	
	public WebElement getUsername() {
		return un;
	}
	@FindBy(name="password")
	private WebElement pass;
	
	public WebElement getPassword() {
		return pass;
	}
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	
	public WebElement getSubmit() {
		return submit;
	}
}
