package learning_testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_utility.BaseTest;


@Listeners(listeners_utility.Listener_Imp.class)

public class Program extends BaseTest{
	@Test
	public void demo() throws IOException{
	WebDriver driver;
	
	}

}
