package Akashpathak.test;

import Akashpathak.testcomponents.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Criticaltest extends BaseTest {
    private static final String VALID_EMAIL = "pathakakash006@gmail.com";
    private static final String VALID_PASSWORD = "Ap123456!";

    @Test
    public void invalidLoginDisplaysError() {
        driver.findElement(By.id("userEmail")).sendKeys("invalid@example.com");
        driver.findElement(By.id("userPassword")).sendKeys("WrongPassword1!");
        driver.findElement(By.id("login")).click();

        String message = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-message")))
                .getText();
        Assert.assertEquals(message, "Incorrect email or password.");
    }

    @Test
    public void forgotPasswordOpensRecoveryPage() {
        driver.findElement(By.linkText("Forgot password?")).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("auth/password-new"));
        Assert.assertTrue(driver.findElement(By.id("userEmail")).isDisplayed());
    }

    @Test
    public void emptyRegistrationShowsRequiredValidation() {
        driver.findElement(By.linkText("Register here")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("auth/register"));
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("firstName")).getAttribute("validationMessage"),
                "Please fill out this field.");
    }

    @Test
    public void signedInUserCanOpenOrders() {
        driver.findElement(By.id("userEmail")).sendKeys(VALID_EMAIL);
        driver.findElement(By.id("userPassword")).sendKeys(VALID_PASSWORD);
        driver.findElement(By.id("login")).click();
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.urlContains("dashboard/dash"));

        driver.findElement(By.xpath("//button[contains(., 'ORDERS')]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("dashboard/myorders"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(normalize-space(), 'Your Orders')]")).isDisplayed());
    }
}