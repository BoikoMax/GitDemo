package main.java.MaxBoiko.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class WebTableSortingWithJavaStreams {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //click on the column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //capture all the webelemnts into the list
        List<WebElement> originList = driver.findElements(By.xpath("//tr/td[1]"));

        //capture the text of all the elements into the new list
        List<String> observedList = originList.stream().map(s->s.getText()).collect(Collectors.toList());

        //sort the original list
        List<String> expectedList = observedList.stream().sorted().collect(Collectors.toList());

        //compare original list with expected (sorted) list
        Assert.assertTrue(observedList.equals(expectedList));
        //Assert.assertEquals(observedList, expectedList);
        List<String> price;
        //scan the column, find the element Rice and print the price for it
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice"))
                    .map(s -> getPriceForItem(s)).collect(Collectors.toList());
            price.forEach(s -> System.out.println("Price is: " + s));

            //pagination
            if (price.size() < 1) {
                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
            }
        } while (price.size() < 1);

    }

    private static String getPriceForItem(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}
