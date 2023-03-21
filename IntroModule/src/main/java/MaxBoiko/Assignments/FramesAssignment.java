package main.java.MaxBoiko.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FramesAssignment {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame(0);
        driver.switchTo().frame(1);
        System.out.println((driver.findElement(By.cssSelector("div#content")).getText()));

    }
}
