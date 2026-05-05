package learning_locators;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Practice_SwagLabs {

    public static void main(String[] args) {

    	ChromeOptions options = new ChromeOptions();

    	// ✅ BEST FIX
    	options.addArguments("--incognito");

    	// OR use this for permanent fix
    	options.addArguments("--user-data-dir=C:\\temp\\fresh-profile");

    	Map<String, Object> prefs = new HashMap<>();
    	prefs.put("credentials_enable_service", false);
    	prefs.put("profile.password_manager_enabled", false);

    	options.setExperimentalOption("prefs", prefs);

    	options.addArguments("--disable-features=PasswordLeakDetection");
    	options.addArguments("--disable-notifications");
    	options.addArguments("--disable-infobars");

    	WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String itemAddedName=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
        String itemAddedPrice=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']")).getText();
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Deepak");
        driver.findElement(By.id("last-name")).sendKeys("Kumar");
        driver.findElement(By.id("postal-code")).sendKeys("110096");
        driver.findElement(By.id("continue")).click();
       String s= driver.findElement(By.xpath("//span[@class='title']")).getText();
       String ExpectedR="Checkout: Overview" ;
       if(s.contains(ExpectedR)) {
    	   System.out.println("CheckOut Page open successfully");
       }
       else {
    	   System.out.println("Checkout Page not opened");
       }
       String ExpectedAddedItemName= driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
       String ExpectedAddedItemPrice= driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
       if(itemAddedName.equals(ExpectedAddedItemName)) {
    	   System.out.println("Item Name matched on cart page");
       }
       else {
    	   System.out.println("Item Name not matched on cart page");
       }
       if(itemAddedPrice.equals(ExpectedAddedItemPrice)) {
    	   System.out.println("Item Price matched on cart page");
       }
       else {
    	   System.out.println("Item Price not matched on cart page");
       }
       driver.findElement(By.id("finish")).click();
       String success=driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
       System.out.println(success);
       
       driver.quit();
    }
}