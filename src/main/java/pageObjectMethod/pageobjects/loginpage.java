package pageObjectMethod.pageobjects;

import Abstractcomponents.reuseablecode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage extends reuseablecode {

    WebDriver driver;

    public loginpage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(id="userEmail")
    WebElement email;

    @FindBy(id="userPassword")
    WebElement password;

    @FindBy(id="login")
    WebElement login;

    public void Loginaction(String mail, String pass){
        email.sendKeys(mail);
        password.sendKeys(pass);
        login.click();

    }

    public void gotourl() {
        driver.get("https://rahulshettyacademy.com/client");
    }

}

