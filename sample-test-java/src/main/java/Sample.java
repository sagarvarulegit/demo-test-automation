import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.TakesScreenshot;

public class Sample {
    public static void main(String[] args) throws IOException {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        // options.addArguments("--no-sandbox"); // Bypass OS security model
        // options.addArguments("--ignore-ssl-errors=yes");
        // options.addArguments("--ignore-certificate-errors");
       
         WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
        // WebDriverManager.chromedriver().setup();
        // WebDriver driver = new ChromeDriver();

        
         driver.get("http://192.168.0.183:1234/sample-login.html");
        // driver.get("http://www.google.com");
         driver.findElement(By.id("input_username")).sendKeys("sdsdsfdfsff");

         File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            System.out.println(screenshotFile.getAbsolutePath());
            FileUtils.copyFile(screenshotFile , new File("C:\\SagarV\\screenshot.png"));
         };
    }

