package Abstractcomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Reuseablecode {
    WebDriver driver;
    public Reuseablecode(WebDriver driver){
      this.driver=driver;

    }
    public void waitsimp(By Byelements){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Byelements));
    }

    public void Actiontomovetoelement(WebElement act){
        Actions a= new Actions(driver);
        a.moveToElement(act).build().perform();
    }

    //toast-container
    //



}
