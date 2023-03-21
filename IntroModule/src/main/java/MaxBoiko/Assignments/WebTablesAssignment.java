package main.java.MaxBoiko.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTablesAssignment {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        //Step 1
        List<WebElement> rowsNumber = driver.findElements(By.cssSelector(".left-align tr"));
        int rowsSum = rowsNumber.size();
        System.out.println("Number of rows is: " + rowsSum);

        //Step 2
        List<WebElement> columnsNumber = driver.findElements(By.cssSelector(".left-align tr th"));
        int columnsSum = columnsNumber.size();
        System.out.println("Number of columns is: " + columnsSum);

        //Step 3
        List<WebElement> secondRowText = driver.findElements(By.cssSelector(".left-align tr:nth-child(3)"));
        for (int i = 0; i < secondRowText.size(); i++) {
            System.out.println(secondRowText.get(i).getText());
        }

    }
}
