package orange_crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Array2D {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		

		String arr[][] = new String[3][2];
		arr[0][0] = "admin";
		arr[0][1] = "times@123";
		arr[1][0] = "admin1";
		arr[1][1] = "times@1234";
		arr[2][0] = "admin";
		arr[2][1] = "times@12345";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.println(arr[i][j]);
			}
		}
	}

}
