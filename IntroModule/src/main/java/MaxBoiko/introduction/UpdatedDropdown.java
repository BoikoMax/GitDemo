package main.java.MaxBoiko.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        Assert.assertFalse(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());
        //select the checkbox
        driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).click();
        //System.out.println(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());

        //radiobuttons
        //System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        //System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
            System.out.println("It's enabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

        //find the total number of checkboxes
        System.out.println("The total number of the checkboxes is: " + driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        //updated dropdown
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        /*
        int i = 1;
        while (i < 5){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }*/
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        //System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

    }
}
