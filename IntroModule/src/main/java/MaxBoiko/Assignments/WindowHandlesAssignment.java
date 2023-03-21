package main.java.MaxBoiko.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandlesAssignment {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        driver.findElement(By.cssSelector("a[target='_blank']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iter = windows.iterator();
        String parentID = iter.next();
        String childID = iter.next();

        driver.switchTo().window(childID);
        System.out.println(driver.findElement(By.className("example")).getText());

        driver.switchTo().window(parentID);
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());

    }
}
