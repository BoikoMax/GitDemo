package main.java.MaxBoiko.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //above
        WebElement nameEditBox = driver.findElement(By.name("name"));

        String labelText = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();

        System.out.println(labelText);
        Assert.assertEquals(labelText, "Name");

        //left
        WebElement iceCreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

        //right
        WebElement rdb = driver.findElement(By.id("inlineRadio1"));
        String rdbText = driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText();
        System.out.println(rdbText);

        //below
        WebElement dateOfBirth = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();


    }
}
