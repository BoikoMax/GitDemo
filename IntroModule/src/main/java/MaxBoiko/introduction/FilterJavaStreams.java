package main.java.MaxBoiko.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class FilterJavaStreams {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.id("search-field")).sendKeys("Rice");

        List<WebElement> listOfItems = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> filteredList = listOfItems.stream().filter(s->s.getText().contains("Rice"))
                .collect(Collectors.toList());

        Assert.assertTrue(listOfItems.equals(filteredList));
        Assert.assertEquals(listOfItems.size(), filteredList.size());
    }
}
