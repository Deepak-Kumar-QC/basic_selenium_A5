package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {

	public RecruitmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[normalize-space()='Add']")
	private WebElement add;
	public WebElement getAdd() {
		return add;
	}
	@FindBy(name="firstName")
	private WebElement fname;
	public WebElement getFirstname() {
		return fname;
	}
	@FindBy(name="lastName")
	private WebElement lname;
	public WebElement getLastname() {
		return lname;
	}
	@FindBy(xpath="//div[contains(text(),'-- Select --')]")
	private WebElement jobVacancy;
	public WebElement getJobVacancy() {
		return jobVacancy;
	}
	@FindBy(xpath="//span[normalize-space()='Payroll Administrator']")
	private WebElement payroll;
	public WebElement getPayroll() {
		return payroll;
	}
	@FindBy(xpath="(//input[@placeholder='Type here'])[1]")
	private WebElement email;
	public WebElement getEmail() {
		return email;
	}
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	public WebElement getSubmit() {
		return submit;
	}
	@FindBy(xpath="//button[normalize-space()='Shortlist']")
	private WebElement shortList;
	public WebElement getshortList() {
		return shortList;
	}
	@FindBy(xpath="//button[normalize-space()='Save']")
	private WebElement save;
	public WebElement getSave() {
		return save;
	}
	
	@FindBy(xpath="//button[normalize-space()='Schedule Interview']")
	private WebElement schedule;
	public WebElement getschedule() {
		return schedule;
	}
	
	@FindBy(xpath="//label[text()='Interview Title']/following::input[1]")
	private WebElement interviewTitle;
	public WebElement getinterviewTitle() {
		return interviewTitle;
	}
	
	@FindBy(xpath="//div[contains(@class,'oxd-toast--success')]")
	private WebElement success;
	public WebElement getSuccess() {
		return success;
	}
	@FindBy(xpath="//label[text()='Interviewer']/following::input[1]")
	private WebElement interviewer;
	public WebElement getinterviewer() {
		return interviewer;
	}
	@FindBy(xpath="//div[@role='listbox']")
	private WebElement drop;
	public WebElement getDrop() {
		return drop;
	}
	@FindBy(xpath="//label[text()='Date']/following::input[1]")
	private WebElement date;
	public WebElement getDate() {
		return date;
	}
	@FindBy(xpath="//label[text()='Time']/following::input[1]")
	private WebElement time;
	public WebElement getTime() {
		return time;
	}
	
	@FindBy(xpath="//button[normalize-space()='Mark Interview Passed']")
	private WebElement MarkInterview;
	public WebElement getMarkInterview() {
		return MarkInterview;
	}

	@FindBy(xpath="//button[normalize-space()='Offer Job']")
	private WebElement jobOffer;
	public WebElement getjobOffer() {
		return jobOffer;
	}
	@FindBy(xpath="//button[normalize-space()='Hire']")
	private WebElement hire;
	public WebElement getHire() {
		return hire;
	}
	@FindBy(xpath="//p[normalize-space()='Status: Hired']")
	private WebElement hireStatus;
	public WebElement gethireStatus() {
		return hireStatus;
	}
}
