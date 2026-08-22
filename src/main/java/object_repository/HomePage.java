package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Recruitment']")
	private WebElement recruitment;
	
	public WebElement getRecruitment() {
		return recruitment;
	}
	@FindBy(css="p[class='oxd-userdropdown-name']")
	private WebElement profile;
	
	public WebElement getProfile() {
		return profile;
	}
	@FindBy(linkText="Logout")
	private WebElement logout;
	
	public WebElement getLogout() {
		return logout;
	}
}
