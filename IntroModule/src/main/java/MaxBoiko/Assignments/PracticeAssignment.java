package main.java.MaxBoiko.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PracticeAssignment {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        WebElement selectedArea = driver.findElement(By.cssSelector("label[for='benz']"));
        selectedArea.findElement(By.tagName("input")).click();
        String selectedName = selectedArea.getText();

        WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText(selectedName);

        driver.findElement(By.id("name")).sendKeys(selectedName);
        driver.findElement(By.id("alertbtn")).click();

        String alertText = driver.switchTo().alert().getText();
        String[] alertTextSplitted = alertText.split(",");
        String[] alertTextUsed = alertTextSplitted[0].split(" ");
        String alretName = alertTextUsed[1];
        Assert.assertEquals(alretName, selectedName);

    }
}
