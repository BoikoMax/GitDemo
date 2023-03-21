package main.java.MaxBoiko.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calendar {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companion/");

        // Scroll the Page

        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("window.scrollBy(0,800)");

        // Click on the Date field

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).click();

        while(!driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText().contains("April")) {
            driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
        }

        //driver.findElement(By.id("form-field-travel_comp_date")).click();
        List<WebElement> dates = driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));

        for (int i = 0; i < dates.size(); i++) {
            String text = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();
            if (text.equalsIgnoreCase("23")){
                driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
                break;
            }
        }

    }
}
