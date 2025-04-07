package Akashpathk.pageobjects;

import Abstractcomponents.Reuseablecode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Productscatpage extends Reuseablecode {
    WebDriver driver;

    public Productscatpage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css =".mb-3")
    List<WebElement> prodincart;

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement cartbutton;




    By products1=By.cssSelector(".mb-3");

    public List<WebElement> prodlist(){
        waitsimp(products1);
        return prodincart;
    }

    public void gettheproduct(List<WebElement>a,String name){
        for (int i=0;i<a.size();i++)
        {
            String s=a.get(i).getText();
            if (s.contains(name))
            {
                driver.findElements(By.xpath("//button[@class='btn w-10 rounded']")).get(i).click();
            }
        }
    }




    public void gotocart(){
        cartbutton.click();
    }



       @FindBy(xpath = "//section/button")
    List<WebElement> namesindd;

    public void selectcountry(List<WebElement> d) {
        for (WebElement country : d) {
            if (country.getText().equals("India")) {
                country.click();
                break;  // Exit after selecting India
            }
        }
    }



}

