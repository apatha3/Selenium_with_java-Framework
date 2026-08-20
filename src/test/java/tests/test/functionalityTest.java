package tests.test;

import Abstractcomponents.reuseablecode;
import pageObjectMethod.pageobjects.cartpage;
import pageObjectMethod.pageobjects.loginpage;
import pageObjectMethod.pageobjects.paymentpage;
import pageObjectMethod.pageobjects.productscatpage;
import tests.testcomponents.baseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static com.google.common.base.Ascii.equalsIgnoreCase;
import static pageObjectMethod.pageobjects.productscatpage.product;


public class functionalityTest extends baseTest  {
    @Test (dataProvider="getdata")
    public void firsttest(HashMap<String,String> input) throws IOException, InterruptedException {
        loginpage l= new loginpage(driver);
        l.Loginaction(input.get("email"),input.get("password"));
        productscatpage p= new productscatpage(driver);
        List<WebElement>products=p.prodlist();   //list of products in the catalogue page
        p.gettheproduct(products,"ZARA COAT 3");
        reuseablecode r=new reuseablecode(driver);
        r.waitsimp(By.id("toast-container"));
        p.gotocart();
        cartpage d= new cartpage(driver);
        d.gotopayment();
        paymentpage pa=new paymentpage(driver);
        pa.entercountry("Ind");
        r.waitsimp(By.cssSelector(".ta-results"));
        List<WebElement> dropdown= driver.findElements(By.xpath("//section/button"));
        pa.selectcountry(dropdown);
        pa.placement();
        r.waitsimp(By.cssSelector(".hero-primary"));

    }
    @DataProvider
    public Object[][] getdata() throws IOException {
        reuseablecode utils=new reuseablecode(driver);
         List<HashMap<String,String>> credentials= utils.readJson();
        return new  Object[][]{{credentials.get(0)},{credentials.get(1)}};

    }

    @Test
    public void ceratefileandwrite() throws IOException {

      String writingitem=  driver.findElement(By.xpath("//section/h1")).getText();
      File file= new File(System.getProperty("user.dir")+"\\src\\main\\java\\output.txt");
        BufferedWriter BufferedWriter=new BufferedWriter(new FileWriter(file));
        BufferedWriter.write(writingitem);
        BufferedWriter.flush();
        BufferedWriter.close();


    }

    @Test(groups = "Within products page")
    public void searchfiltertest(){
        loginpage log = new loginpage(driver);
        log.Loginaction("pathakakash006@gmail.com","Ap123456!");
        productscatpage p=new productscatpage(driver);
        p.enternameandsearch();
        String receivedprod=  driver.findElement(By.cssSelector("h5[style*='text-transform']")).getText();
        Assert.assertEquals(product,receivedprod);
    }

    @Test(groups = "Within products page")
    public void addproductandverify() throws InterruptedException {

        loginpage log = new loginpage(driver);
        log.Loginaction("pathakakash006@gmail.com","Ap123456!");
        productscatpage p1=new productscatpage(driver);
        p1.selectdesireditems();
        p1.waitsimp(By.cssSelector("h5 b"));
        p1.gotocart();
    }
        



}




