package working_with_webdriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class MethodOfWebDriver {
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");
		// fully qualified path => InvalidArgumentException

		String exTitle = "Facebook";
		String actTitle = driver.getTitle();
		if (actTitle.contains(exTitle))	
			System.out.println("title matched");

		String exUrl = "facebook";
		String actUrl = driver.getCurrentUrl();
		if (actUrl.contains(exUrl))	System.out.println("url matched");

//		String actSourceCode = driver.getPageSource();
//		System.out.println(actSourceCode);

		Window win = driver.manage().window();

//		modify size	
		Dimension dim = win.getSize();
		System.out.println(dim);
		System.out.println(dim.getWidth());
		System.out.println(dim.getHeight());

		Dimension dim2 = new Dimension(1000, 500);
		win.setSize(dim2);

//		modify position
		win.setPosition(new Point(300, 150));

		Point pt = win.getPosition();
		System.out.println(pt);
		System.out.println(pt.getX());
		System.out.println(pt.getY());

		Navigation nav = driver.navigate();

		nav.to("https://www.x.com/");
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		nav.to(new URL("https://www.instagram.com/"));

		Thread.sleep(2000);
		nav.back();

		Thread.sleep(2000);
		nav.forward();

		Thread.sleep(2000);
		nav.refresh();

//		driver.getWindowHandle();
//		driver.getWindowHandles();
//		driver.switchTo();

		Thread.sleep(3000);

		driver.quit();
//		driver.close(); NoSuchSessionException		
	}
}
