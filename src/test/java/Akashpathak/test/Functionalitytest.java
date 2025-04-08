package Akashpathak.test;

import Abstractcomponents.Reuseablecode;
import Akashpathak.testcomponents.BaseTest;
import Akashpathk.pageobjects.Cartpage;
import Akashpathk.pageobjects.Loginpage;
import Akashpathk.pageobjects.Paymentpage;
import Akashpathk.pageobjects.Productscatpage;
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

import static Akashpathk.pageobjects.Productscatpage.product;
import static com.google.common.base.Ascii.equalsIgnoreCase;

public class Functionalitytest extends BaseTest  {
    @Test (dataProvider="getdata")
    public void firsttest(HashMap<String,String> input) throws IOException, InterruptedException {
        Loginpage l= new Loginpage(driver);
        l.Loginaction(input.get("email"),input.get("password"));
        Productscatpage p= new Productscatpage(driver);
        List<WebElement>products=p.prodlist();   //list of products in the catalogue page
        p.gettheproduct(products,"ZARA COAT 3");
        Reuseablecode r=new Reuseablecode(driver);
        r.waitsimp(By.id("toast-container"));
        p.gotocart();
        Cartpage d= new Cartpage(driver);
        d.gotopayment();
        Paymentpage pa=new Paymentpage(driver);
        pa.entercountry("Ind");
        r.waitsimp(By.cssSelector(".ta-results"));
        List<WebElement> dropdown= driver.findElements(By.xpath("//section/button"));
        pa.selectcountry(dropdown);
        pa.placement();
        r.waitsimp(By.cssSelector(".hero-primary"));

    }
    @DataProvider
    public Object[][] getdata() throws IOException {

      //  return new Object[][]{{"Akash"},{"Password"}};

        //Below Given code is to pass multiple dataset
      //  HashMap<String,String> a= new HashMap<String,String>();
      //  a.put("email","pathakakash006@gmail.com");
      //  a.put("password","Ap123456!");
        //  HashMap<String,String> a1= new HashMap<String,String>();
      //    a1.put("email","Brijeshpathak2012@gmail.com");
      //  a1.put("password","Ap123456!");


        //Below given test is for converting JSON to string and then to HashMAP
         List<HashMap<String,String>> fin= jsonda();
        return new  Object[][]{{fin.get(0)},{fin.get(1)}};

    }

//C:\Users\Akash Pathak\IdeaProjects\TSTNGL\src\main\java\JsonD.json
    @Test
    public void ceratefileandwrite() throws IOException {

      String writingitem=  driver.findElement(By.xpath("//section/h1")).getText();
      File f= new File(System.getProperty("user.dir")+"\\src\\main\\java\\output.txt");
        BufferedWriter b=new BufferedWriter(new FileWriter(f));
        b.write(writingitem);
        b.flush();
        b.close();


    }
@Test(groups = "Within products page")
    public void searchfiltertest(){
        Loginpage log = new Loginpage(driver);
        log.Loginaction("pathakakash006@gmail.com","Ap123456!");
        Productscatpage p=new Productscatpage(driver);
        p.enternameandsearch();
        String receivedprod=  driver.findElement(By.cssSelector("h5[style*='text-transform']")).getText();
        Assert.assertEquals(product,receivedprod);
    }

@Test(groups = "Within products page")
    public void addproductandverify() throws InterruptedException {

        Loginpage log = new Loginpage(driver);
        log.Loginaction("pathakakash006@gmail.com","Ap123456!");
        Productscatpage p1=new Productscatpage(driver);
        p1.selectdesireditems();
        p1.waitsimp(By.cssSelector("h5 b"));
        p1.gotocart();
        



}


}



