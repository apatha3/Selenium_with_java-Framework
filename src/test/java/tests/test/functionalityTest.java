package tests.test;

import Abstractcomponents.Reuseablecode;
import pageObjectMethod.pageobjects.cartpage;
import pageObjectMethod.pageobjects.loginpage;
import pageObjectMethod.pageobjects.paymentpage;
import pageObjectMethod.pageobjects.productscatpage;
import tests.testcomponents.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static pageObjectMethod.pageobjects.productscatpage.product;

public class functionalityTest extends baseTest {
    @Test(dataProvider = "getdata")
    public void firsttest(HashMap<String, String> input) throws IOException, InterruptedException {
        loginpage login = new loginpage(driver);
        login.Loginaction(input.get("email"), input.get("password"));
        productscatpage products = new productscatpage(driver);
        List<WebElement> productList = products.prodlist();
        products.gettheproduct(productList, "ZARA COAT 3");
        Reuseablecode reusable = new Reuseablecode(driver);
        reusable.waitsimp(By.id("toast-container"));
        products.gotocart();
        new cartpage(driver).gotopayment();
        paymentpage payment = new paymentpage(driver);
        payment.entercountry("Ind");
        reusable.waitsimp(By.cssSelector(".ta-results"));
        payment.selectcountry(driver.findElements(By.xpath("//section/button")));
        payment.placement();
        reusable.waitsimp(By.cssSelector(".hero-primary"));
    }

    @DataProvider
    public Object[][] getdata() throws IOException {
        List<HashMap<String, String>> credentials = new Reuseablecode(driver).readJson();
        return new Object[][]{{credentials.get(0)}, {credentials.get(1)}};
    }

    @Test
    public void ceratefileandwrite() throws IOException {
        String heading = driver.findElement(By.xpath("//section/h1")).getText();
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\output.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(heading);
        }
    }

    @Test(groups = "Within products page")
    public void searchfiltertest() {
        new loginpage(driver).Loginaction("pathakakash006@gmail.com", "Ap123456!");
        productscatpage products = new productscatpage(driver);
        products.enternameandsearch();
        String receivedProduct = driver.findElement(By.cssSelector("h5[style*='text-transform']")).getText();
        Assert.assertEquals(product, receivedProduct);
    }

    @Test(groups = "Within products page")
    public void addproductandverify() throws InterruptedException {
        new loginpage(driver).Loginaction("pathakakash006@gmail.com", "Ap123456!");
        productscatpage products = new productscatpage(driver);
        products.selectdesireditems();
        products.waitsimp(By.cssSelector("h5 b"));
        products.gotocart();
    }
}