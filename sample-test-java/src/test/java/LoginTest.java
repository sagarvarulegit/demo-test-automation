import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginTest {
    static WebDriver driver;

    @Test
    public void TestVerifyLoginTest() throws IOException {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
        driver.get("http://localhost:1234/sample-login.html");
        driver.findElement(By.id("input_username")).clear();
        driver.findElement(By.id("input_username")).sendKeys("Sagar");

        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f, new File(System.getProperty("user.dir") + "//screenshot.png"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
