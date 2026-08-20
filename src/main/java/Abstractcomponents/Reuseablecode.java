package Abstractcomponents;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class reuseablecode {
    WebDriver driver;
    public reuseablecode(WebDriver driver){
      this.driver=driver;

    }
    public void waitsimp(By Byelements){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Byelements));
    }

    public void Actiontomovetoelement(WebElement act){
        Actions a= new Actions(driver);
        a.moveToElement(act).build().perform();
    }

        public List<HashMap<String,String>> readJson() throws IOException {
        ObjectMapper objectMapper= new ObjectMapper();
        try (InputStream json = getClass().getClassLoader().getResourceAsStream("jsonD.json")) {
            if (json == null) {
                throw new IOException("Could not find jsonD.json on the classpath");
            }
            return objectMapper.readValue(json, new TypeReference<List<HashMap<String, String>>>() {
            });
        }
    }




}
