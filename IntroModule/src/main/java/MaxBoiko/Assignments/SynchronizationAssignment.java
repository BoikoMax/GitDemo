package main.java.MaxBoiko.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SynchronizationAssignment {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        String inputInfo = driver.findElement(By.xpath("//p[@class='text-center text-white']")).getText();
        String [] splittedData = inputInfo.split("is");
        String [] splittedName = splittedData[1].split("and");
        String [] splittedPassword = splittedData[2].split("\\)");
        String name = splittedName[0].trim();
        String password = splittedPassword[0].trim();
        driver.findElement(By.id("username")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//label[@class='customradio']/span[contains(text(), 'User')]/following-sibling::span[@class='checkmark']")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();
        WebElement staticDropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByValue("consult");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.my-4")));
        addItems(driver);
        driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();
    }

    public static void addItems(WebDriver driver) {
        List<WebElement> availableItemsList = driver.findElements(By.cssSelector(".card-footer"));
        for (int i = 0; i < availableItemsList.size(); i++) {
           availableItemsList.get(i).findElement(By.cssSelector(".btn-info")).click();
        }
    }
}
