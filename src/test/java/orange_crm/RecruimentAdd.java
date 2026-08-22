package orange_crm;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import object_repository.LoginPage;

public class RecruimentAdd {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		LoginPage login=new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Successfully LoggedIn");
		
		driver.findElement(By.xpath("//span[text()='Recruitment']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		System.out.println("Start Adding candidate Details-----");
		driver.findElement(By.name("firstName")).sendKeys("Deepak");
		driver.findElement(By.name("lastName")).sendKeys("Kumar");
		WebElement jobVacancy = driver.findElement(By.xpath("//div[contains(text(),'-- Select --')]"));
		jobVacancy.click();
		driver.findElement(By.xpath("//span[normalize-space()='Payroll Administrator']")).click();

		driver.findElement(By.xpath("(//input[@placeholder='Type here'])[1]")).sendKeys("testmb@gmail.com");
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		Actions act = new Actions(driver);
		act.scrollToElement(submit).build().perform();
		submit.click();

		By successToast = By.xpath("//div[contains(@class,'oxd-toast--success')]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		boolean status = wait.until(ExpectedConditions.visibilityOfElementLocated(successToast)).isDisplayed();
		System.out.println("Candidate Added Successfully : " + status);
		
		WebElement shortList=driver.findElement(By.xpath("//button[normalize-space()='Shortlist']"));
		wait.until(ExpectedConditions.elementToBeClickable(shortList)).click();
		System.out.println("Candidate shortlisted Successfully!");
		WebElement save=driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(save)).click();
		System.out.println("Shortlisted candidate Saved Successfully!");
		Thread.sleep(4000);
		WebElement schedule=driver.findElement(By.xpath("//button[normalize-space()='Schedule Interview']"));
		wait.until(ExpectedConditions.elementToBeClickable(schedule)).click();
		System.out.println("Candidate shortlisted for Scheduled Interview!");
		WebElement interviewTitle=driver.findElement(By.xpath("//label[text()='Interview Title']/following::input[1]"));
		wait.until(ExpectedConditions.visibilityOf(interviewTitle)).sendKeys("Automation Testing");
		WebElement interviewer=driver.findElement(By.xpath("//label[text()='Interviewer']/following::input[1]"));
		wait.until(ExpectedConditions.visibilityOf(interviewer)).sendKeys("Ranga  Akunuri");
		Thread.sleep(3000);
		WebElement drop=driver.findElement(By.xpath("//div[@role='listbox']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(drop)).click();
		WebElement date=driver.findElement(By.xpath("//label[text()='Date']/following::input[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(date)).sendKeys("Thursday, 18-Jun-2026");
		driver.findElement(By.xpath("//label[text()='Time']/following::input[1]")).sendKeys("01:00 PM");


		act.scrollByAmount(0, 200).perform();
		Thread.sleep(3000);
		WebElement save1=driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		wait.until(ExpectedConditions.elementToBeClickable(save1)).click();
		System.out.println("Interview Scheduled Successfully for added Condidate!");
		WebElement MarkInterview=driver.findElement(By.xpath("//button[normalize-space()='Mark Interview Passed']"));
		wait.until(ExpectedConditions.elementToBeClickable(MarkInterview)).click();
		System.out.println("Marked Interview Passed!");
		WebElement save2=driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		wait.until(ExpectedConditions.elementToBeClickable(save2)).click();
		System.out.println("Application Stage Page....");
		WebElement jobOffer=driver.findElement(By.xpath("//button[normalize-space()='Offer Job']"));
		wait.until(ExpectedConditions.elementToBeClickable(jobOffer)).click();
		System.out.println("JOB offered Successfully....");
		WebElement save3=driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		wait.until(ExpectedConditions.elementToBeClickable(save3)).click();
		System.out.println("Hiring Candidate...");
		WebElement hire=driver.findElement(By.xpath("//button[normalize-space()='Hire']"));
		wait.until(ExpectedConditions.elementToBeClickable(hire)).click();
		WebElement save4=driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		wait.until(ExpectedConditions.elementToBeClickable(save4)).click();
		Thread.sleep(3000);
		String hired="Status: Hired";
		String hireStatus=driver.findElement(By.xpath("//p[normalize-space()='Status: Hired']")).getText();
		if(hireStatus.equals(hired)) {
			System.out.println("Candiadate Hired Successfully....");
		}
		else {
		System.out.println("Candiadate Not Hired Successfully....");
		}
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("./errorShots/Recrutment"+Math.random()+".png");
		FileHandler.copy(source, destination);
		
		driver.findElement(By.cssSelector("p[class='oxd-userdropdown-name']")).click();
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Successfully Logged Out!");
		driver.quit();
		Thread.sleep(3000);
		driver.quit();
	}

}
