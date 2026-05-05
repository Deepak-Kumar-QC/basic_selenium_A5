package initial_days;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class First_Line_of_Code {

	public static void main(String[] args) throws MalformedURLException {
//		ChromeDriver cd = new ChromeDriver();
//		EdgeDriver ed = new EdgeDriver();
//		FirefoxDriver ffd = new FirefoxDriver();

//		which will create random memory space, in heap area
//		1. Launch the empty chrome browser
//		2. start the server
//		3. Load, reg. and re-initialize the non static members

//		upcasting
//		WebDriver driver = new ChromeDriver();
//		WebDriver driver2 = new EdgeDriver();
//		WebDriver driver3 = new FirefoxDriver();

//		poly-morphism(runtime)
		WebDriver driver = new ChromeDriver();
		Window wr = driver.manage().window();
		wr.maximize();
		driver.get("https://www.facebook.com");

		String expected = "Facebook";
		String actual = driver.getTitle();
		if (actual.contains(expected))
			System.out.println("Title is matched");

		String expected1 = "facebook";
		String actual1 = driver.getCurrentUrl();
		if (actual1.contains(expected1))
			System.out.println("Url is matched");
		String s = driver.getPageSource();
		System.out.println(s);
		Dimension d=wr.getSize();
		System.out.println(d);
		System.out.println(d.getHeight());
		System.out.println(d.getWidth());
		wr.setSize(new Dimension(900,800));
		
		Point p=wr.getPosition();
		System.out.println(p);
		System.out.println(p.getX());
		System.out.println(p.getY());
		wr.setPosition(new Point(200,100));
		
		Navigation nav=driver.navigate();
		nav.to("https://www.google.com");
		nav.to(new URL("https://www.x.com/"));
		nav.back();
		nav.forward();
		nav.refresh();
		driver.quit();
	}

}
