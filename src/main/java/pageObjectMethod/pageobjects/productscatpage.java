package pageObjectMethod.pageobjects;

import Abstractcomponents.reuseablecode;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class productscatpage extends reuseablecode {
    WebDriver driver;

    public productscatpage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> prodincart;

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement cartbutton;


    By products1 = By.cssSelector(".mb-3");

    public List<WebElement> prodlist() {
        waitsimp(products1);
        return prodincart;
    }

    public void gettheproduct(List<WebElement> a, String name) {
        for (int i = 0; i < a.size(); i++) {
            String s = a.get(i).getText();
            if (s.contains(name)) {
                driver.findElements(By.xpath("//button[@class='btn w-10 rounded']")).get(i).click();
            }
        }
    }


    public void gotocart() {
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

    //driver.findElement(By.xpath("(//input[@name='search'])[2]")).sendKeys(product,k);
    public static String product = "IPHONE 13 PRO";
    @FindBy(xpath = "(//input[@name='search'])[2]")
    WebElement searchbar;

    // String product="IPHONE 13 PRO";
    public void enternameandsearch() {
        waitsimp(By.xpath("(//input[@name='search'])[2]"));
        searchbar.sendKeys(product);
        searchbar.sendKeys(Keys.ENTER);
        //Reuseablecode r= new Reuseablecode(driver);
        //        r.waitsimp(By.cssSelector("h5[style*='text-transform']"));
        waitsimp(By.cssSelector("h5[style*='text-transform']"));
    }


    /*List<WebElement> products=driver.findElements(By.cssSelector(".col-lg-4"));
        for (WebElement finalproduct:products){
         String productstobechoosed=  finalproduct.findElement(By.cssSelector("h5 b")).getText();
         if (productstobechoosed.equalsIgnoreCase("ZARA COAT 3") || productstobechoosed.equalsIgnoreCase("IPHONE 13 PRO")){
             finalproduct.findElement(By.cssSelector(".fa-shopping-cart")).click();
         }
        }*/

    @FindBy(css = ".col-lg-4")
    List<WebElement> products;

    public void selectdesireditems() {
        for (WebElement finalproduct : products) {
            String productstobechoosed = finalproduct.findElement(By.cssSelector("h5 b")).getText();
            if (productstobechoosed.equalsIgnoreCase("ZARA COAT 3")
                    || productstobechoosed.equalsIgnoreCase("IPHONE 13 PRO")) {
                finalproduct.findElement(By.cssSelector(".fa-shopping-cart")).click();
            }


        }
    }
}





