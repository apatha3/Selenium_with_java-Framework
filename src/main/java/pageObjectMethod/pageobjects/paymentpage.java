package pageObjectMethod.pageobjects;

import Abstractcomponents.Reuseablecode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class paymentpage extends Reuseablecode {
    WebDriver driver;

    public paymentpage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[contains(@placeholder,'Country')]")
    WebElement Country;

    public void entercountry(String name){
        Country.sendKeys(name);
    }

    public void selectcountry(List<WebElement> d) {
        for (WebElement country : d) {
            if (country.getText().equals("India")) {
                country.click();
                break;  // Exit after selecting India
            }
        }
    }

    @FindBy(linkText = "PLACE ORDER")
    WebElement placeorderbtn;

    public void placement(){
        placeorderbtn.click();
    }


}
