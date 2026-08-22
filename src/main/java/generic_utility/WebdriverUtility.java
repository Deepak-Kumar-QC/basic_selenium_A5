package generic_utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	WebDriver driver;
	WebDriverWait wait;
	Actions act;

	public WebdriverUtility(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.act = new Actions(driver);
	}

	// window handling
	public void switchToWindowByTitle(String partialTitle) {

		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains(partialTitle)) {
				break;
			}
		}
	}

	public void switchToWindowByUrl(String partialUrl) {

		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains(partialUrl)) {
				break;
			}
		}
	}

	public void switchToParentWindow(String pid) {
		driver.switchTo().window(pid);
	}

	public void closeAllChildWindows(String parentWindowHandle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindowHandle)) {
				driver.switchTo().window(window);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandle);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void fullScreenWindow() {
		driver.manage().window().fullscreen();
	}

	// Implicit Wait command
	public void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	// Explicit wait commands
	public void waitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitAndClick(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void waitForElementInvisibility(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForTextInElement(WebElement element, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public void waitForTitleContains(String titlePart) {
		wait.until(ExpectedConditions.titleContains(titlePart));
	}

	public void waitForUrlContains(String urlFraction, int timeOutSeconds) {
		wait.until(ExpectedConditions.urlContains(urlFraction));
	}

	// Select Class
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void select(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void select(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	// Mouse Actions
	public void hover(WebElement element) {
		act.moveToElement(element).build().perform();
	}

	public void rightClick(WebElement element) {
		act.contextClick(element).build().perform();
	}

	public void doubleClick(WebElement element) {
		act.doubleClick(element).build().perform();
	}

	public void clickAndHold(WebElement element) {
		act.clickAndHold(element).build().perform();
	}

	public void dragAndDrop(WebElement source, WebElement target) {
		act.dragAndDrop(source, target).build().perform();
	}

	public void moveSliderByOffset(WebElement slider, int xOffset) {
		act.clickAndHold(slider).moveByOffset(xOffset, 0).build().perform();
	}
	public void scrollToElement(WebElement element) {
		act.scrollToElement(element).build().perform();
	}
	public void scrollByAmount(int x,int y) {
		act.scrollByAmount(x,y).build().perform();
	}
	// Scroll Methods
	public void scrollIntoView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollByOffset(int x, int y) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	// Basic Element
	public void clearText(WebElement element) {
		element.clear();
	}

	public void clearAndSendKeys(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void sendKeyboardKey(WebElement element, Keys key) {
		element.sendKeys(key);
	}

	// Browser Navigation
	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateForard() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	// Checkbox and Radio Button
	public void checkCheckbox(WebElement checkbox) {
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	public void uncheckCheckbox(WebElement checkbox) {
		if (checkbox.isSelected()) {
			checkbox.click();
		}
	}

	public boolean isCheckboxChecked(WebElement checkbox) {
		return checkbox.isSelected();
	}

	public void selectRadioButton(WebElement radioButton) {
		if (!radioButton.isSelected()) {
			radioButton.click();
		}
	}

	public boolean isRadioButtonSelected(WebElement radioButton) {
		return radioButton.isSelected();
	}

	// Keyboard ShortCuts
	public void pressEnter(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}

	public void pressEscape(WebElement element) {
		element.sendKeys(Keys.ESCAPE);
	}

	public void pressTab(WebElement element) {
		element.sendKeys(Keys.TAB);
	}

	public void pressCtrlA(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	}

	public void pressCtrlC(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "c"));
	}

	public void pressCtrlV(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}

	// Takes ScreenShot
	public void takesScreentShot(String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("./errorShots/" + screenshotName + Math.random() + ".png");
		FileHandler.copy(source, destination);
	}

	// Alert Handling
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	public void sendTextToAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	// JavaScript Executor Methods
	public void jsClick(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void jsSetValue(WebElement element, String text) {
		((JavascriptExecutor) driver).executeScript("arguments[0].value='" + text + "'", element);
	}

	public void jsScrollToBottom() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

	public void jsScrollToTop() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,-document.body.scrollHeight);");
	}
	// window and tab handling

}