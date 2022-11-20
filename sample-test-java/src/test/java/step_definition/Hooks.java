package step_definition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Hooks {
  public static WebDriver driver;
  public static Map<String, Object> testData;

  @Before
  public void testSetUp(Scenario scenario) throws FileNotFoundException {
    // Driver Setup
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    driver = new ChromeDriver(options);
    driver.get("http://127.0.0.1:8080/sample-login.html");

    // Test Data Setup
    Yaml yaml = new Yaml();
    Collection<String> tags = scenario.getSourceTagNames();
    String tagname = tags.stream().filter(x -> x.startsWith("@testdata")).findFirst().orElse(null);
    if (tagname != null) {
      InputStream io =
          new FileInputStream("src/test/java/resources/test_data/" + tagname.split("=")[1]);
      testData = yaml.load(io);
    }
  }

  @After
  public void tearDown(Scenario scenario) {
    byte[] ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    scenario.attach(ss, "image/png", scenario.getName());
    driver.quit();
  }
}
