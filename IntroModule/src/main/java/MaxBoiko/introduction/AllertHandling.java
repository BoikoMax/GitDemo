package main.java.MaxBoiko.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class AllertHandling {
    public static void main(String[] args) throws InterruptedException {

        String text = "Max";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "/Users/mboyko/chromedriver_mac64/chromedriver");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        Assert.assertEquals(driver.switchTo().alert().getText(), "Hello " + text + ", share this practice page and share your knowledge");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        Assert.assertEquals(driver.switchTo().alert().getText(), "Hello " + text + ", Are you sure you want to confirm?");
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();

    }
}
