 package orange_crm;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic_utility.FileUtility;
import generic_utility.WebdriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.RecruitmentPage;

public class Recruiment_test {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		LoginPage login=new LoginPage(driver);
		HomePage home=new HomePage(driver);
		RecruitmentPage rpage=new RecruitmentPage(driver);
		WebdriverUtility driverutil=new WebdriverUtility(driver);
		FileUtility futil=new FileUtility();
		
		driverutil.maximizeWindow();
		driverutil.waitForPageLoad();
		String url=futil.getDataFromPropertiesFile("url");
		String username=futil.getDataFromPropertiesFile("un");
		String password=futil.getDataFromPropertiesFile("pass");
		driver.get(url);
		login.getUsername().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.getSubmit().click();
		System.out.println("Successfully LoggedIn");
		home.getRecruitment().click();
		rpage.getAdd().click();
		System.out.println("Start Adding candidate Details-----");
		String name=futil.getDataFromExcel("getDataFromExcel", 1, 0);
		String lname=futil.getDataFromExcel("getDataFromExcel", 1, 1);
		rpage.getFirstname().sendKeys(name);
		rpage.getLastname().sendKeys(lname);
		rpage.getJobVacancy().click();
		rpage.getPayroll().click();
		String email=futil.getDataFromExcel("getDataFromExcel", 1, 2);
		String interviewtitle=futil.getDataFromExcel("getDataFromExcel", 1, 3);
		String iname=futil.getDataFromExcel("getDataFromExcel", 1, 4);
		String date=futil.getDataFromExcel("getDataFromExcel", 1, 5);
		String time=futil.getDataFromExcel("getDataFromExcel", 1, 6);
		rpage.getEmail().sendKeys(email);
		rpage.getSubmit().click();
		By successToast = By.xpath("//div[contains(@class,'oxd-toast--success')]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		boolean status = wait.until(ExpectedConditions.visibilityOfElementLocated(successToast)).isDisplayed();
		System.out.println("Candidate Added Successfully : " + status);
		driverutil.waitForElementVisible(rpage.getshortList());
		rpage.getshortList().click();
		System.out.println("Candidate shortlisted Successfully!");
		driverutil.waitForElementVisible(rpage.getSave());
		rpage.getSave().click();
		System.out.println("Shortlisted candidate Saved Successfully!");
		driverutil.waitForElementVisible(rpage.getschedule());
		rpage.getschedule().click();
		System.out.println("Candidate shortlisted for Scheduled Interview!");
		rpage.getinterviewTitle().sendKeys(interviewtitle);
		rpage.getinterviewer().sendKeys(iname);
		Thread.sleep(3000);
		driverutil.waitForElementClickable(rpage.getDrop());
		rpage.getDrop().click();
		rpage.getDate().sendKeys(date);
		rpage.getTime().sendKeys(time);
		driverutil.scrollByAmount(0, 200);
		rpage.getSave().click();
		System.out.println("Interview Scheduled Successfully for added Condidate!");
		driverutil.waitForElementClickable(rpage.getMarkInterview());
		rpage.getMarkInterview().click();
		System.out.println("Marked Interview Passed!");
		driverutil.waitForElementClickable(rpage.getSave());
		rpage.getSave().click();
		System.out.println("Application Stage Page....");
		driverutil.waitForElementClickable(rpage.getjobOffer());
		rpage.getjobOffer().click();
		System.out.println("JOB offered Successfully....");
		driverutil.waitForElementClickable(rpage.getSave());
		rpage.getSave().click();
		System.out.println("Hiring Candidate...");
		driverutil.waitForElementClickable(rpage.getHire());
		rpage.getHire().click();
		driverutil.waitForElementClickable(rpage.getSave());
		rpage.getSave().click();
		Thread.sleep(3000);
		String hired="Status: Hired";
		String hireStatus=rpage.gethireStatus().getText();
		if(hireStatus.equals(hired)) {
			System.out.println("Candiadate Hired Successfully....");
		}
		else {
		System.out.println("Candiadate Not Hired Successfully....");
		}
		home.getProfile().click();
		home.getLogout().click();
		System.out.println("Successfully Logged Out!");
		driver.quit();
		}

}
