package main.java.MaxBoiko.introduction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "/Users/mboyko/chromedriver_mac64/chromedriver");
		

		//ChromeDriver driver = new ChromeDriver(); - will be implemented only for ChromeDriver
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ancestry.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		
		WebDriver driverSafari = new SafariDriver();
		driverSafari.get("https://www.ancestry.com/");
		System.out.println(driverSafari.getTitle());
		System.out.println(driverSafari.getCurrentUrl());
		driverSafari.close();
		
		//Firefox

		//System.setProperty("webdriver.gecko.driver", "/Users/__/Documents/geckodriver");
//
//		WebDriver driver1 = new FirefoxDriver();

		//Microsoft Edge

//		System.setProperty("webdriver.edge.driver", "/Users/__/Documents/msedgedriver");

	}

}
