package main.java.MaxBoiko.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutocompleteDropdownAssignment {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.id("autocomplete"))).click().sendKeys("ind").build().perform();
        Thread.sleep(2000);

        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN, Keys.ENTER);

        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));


        /*Thread.sleep(2000);
        while (!driver.findElement(By.id("autocomplete")).getText().contains("United States (USA)")){
            driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN, Keys.ENTER);
        }*/



    }
}
