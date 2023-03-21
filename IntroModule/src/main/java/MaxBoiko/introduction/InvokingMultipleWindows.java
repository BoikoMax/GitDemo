package main.java.MaxBoiko.introduction;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class InvokingMultipleWindows {
    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parendID = it.next();
        String childID = it.next();

        driver.switchTo().window(childID);
        driver.get("https://rahulshettyacademy.com/");

        js.executeScript("window.scrollBy(0,1000)");

        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();

        driver.switchTo().window(parendID);
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(courseName);

        //screenshot
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("/Users/mboyko/Desktop/someScreenshot.png"));

        //Get Height and Width
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());

    }
}
