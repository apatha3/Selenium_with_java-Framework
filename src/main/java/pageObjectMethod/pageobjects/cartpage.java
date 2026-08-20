package pageObjectMethod.pageobjects;

import Abstractcomponents.reuseablecode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartpage extends reuseablecode {
    WebDriver driver;
    public cartpage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "(//button[@type='button'])[2]")
    WebElement checkout;

    public void gotopayment(){
        checkout.click();

    }
}
