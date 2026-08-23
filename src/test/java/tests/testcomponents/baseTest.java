package tests.testcomponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class baseTest {
    public static WebDriver driver;


    @BeforeMethod
    public void setup()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void teardown(){
        if (driver != null) {
            driver.quit();
        }
    }

    public List<HashMap<String,String>> jsonda() throws IOException {
        File jsonFile = Paths.get("src", "main", "java", "JsonD.json").toFile();
        String jd= FileUtils.readFileToString(jsonFile, StandardCharsets.UTF_8);
        ObjectMapper ob= new ObjectMapper();
        List<HashMap<String,String>> s=ob.readValue(jd, new TypeReference<List<HashMap<String, String>>>() {
        });
        return s;
    }



}









