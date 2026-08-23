package Abstractcomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class Reuseablecode {
    WebDriver driver;

    public Reuseablecode(WebDriver driver) {
        this.driver = driver;
    }

    public void waitsimp(By elements) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elements));
    }

    public void Actiontomovetoelement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public List<HashMap<String, String>> readJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream json = getClass().getClassLoader().getResourceAsStream("jsonD.json")) {
            if (json == null) {
                throw new IOException("Could not find jsonD.json on the classpath");
            }
            return objectMapper.readValue(json, new TypeReference<List<HashMap<String, String>>>() {
            });
        }
    }
}