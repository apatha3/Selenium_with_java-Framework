package Akashpathak.test;

import Akashpathak.testcomponents.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static Akashpathak.testcomponents.BaseTest.driver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Signup extends BaseTest {
    @Test (dependsOnMethods = "firsttest")
            public void Signupp() {
        driver.findElement(By.linkText("Register here")).click();
        driver.findElement(By.id("firstName")).sendKeys("Brijesh");
        driver.findElement(By.id("lastName")).sendKeys("Pathak");
        driver.findElement(By.id("userEmail")).sendKeys("Brijeshpathak2012@gmail.com");
        driver.findElement(By.cssSelector("input[id=userMobile]")).sendKeys("8454844145");
        WebElement drop = driver.findElement(By.cssSelector(".custom-select"));
        Select a = new Select(drop);
        a.selectByIndex(2);
        // String value= driver.findElement(By.cssSelector(".custom-select")).getText();
        //Assert.assertEquals(value,"Student");
        WebElement option = driver.findElement(By.xpath("//span[text()='Male']"));
        driver.findElement(with(By.tagName("input")).above(option)).click();
    }

}
