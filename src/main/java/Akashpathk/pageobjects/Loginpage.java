package Akashpathk.pageobjects;

import Abstractcomponents.Reuseablecode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends Reuseablecode {

    WebDriver driver;

    public Loginpage(WebDriver driver){
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

