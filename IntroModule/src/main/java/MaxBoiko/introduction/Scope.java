package main.java.MaxBoiko.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        //global level
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        int linksCounter = driver.findElements(By.tagName("a")).size();
        System.out.println(linksCounter);

        /*int footerLinksCounter = driver.findElements(By.cssSelector("div#gf-BIG a")).size();
        System.out.println(footerLinksCounter);*/

        //limited webdriver scope
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        int footerLinksCounter = footerDriver.findElements(By.tagName("a")).size();
        System.out.println(footerLinksCounter);
        
        //limited subwebdriver scope
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int columnLinksCounter = columnDriver.findElements(By.tagName("a")).size();
        System.out.println(columnLinksCounter);

        //click each link in the column and if the pages are opening
        for (int i = 1; i < columnLinksCounter; i++) {
            String clickOnLinkTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000);
        }
            Set<String> windows = driver.getWindowHandles();
            Iterator<String> it = windows.iterator();
            while (it.hasNext()){
                driver.switchTo().window(it.next());
                System.out.println(driver.getTitle());
                driver.switchTo().defaultContent();
            }

    }
}
