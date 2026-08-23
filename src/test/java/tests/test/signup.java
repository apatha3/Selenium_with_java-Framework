package tests.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import tests.testcomponents.baseTest;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
import static tests.testcomponents.baseTest.driver;

public class signup extends baseTest {
    @Test
    public void Signupp() {
        driver.findElement(By.linkText("Register here")).click();
        driver.findElement(By.id("firstName")).sendKeys("Brijesh");
        driver.findElement(By.id("lastName")).sendKeys("Pathak");
        driver.findElement(By.id("userEmail")).sendKeys("Brijeshpathak2012@gmail.com");
        driver.findElement(By.cssSelector("input[id=userMobile]")).sendKeys("8454844145");
        new Select(driver.findElement(By.cssSelector(".custom-select"))).selectByIndex(2);
        WebElement option = driver.findElement(By.xpath("//span[text()='Male']"));
        driver.findElement(with(By.tagName("input")).above(option)).click();
    }
}