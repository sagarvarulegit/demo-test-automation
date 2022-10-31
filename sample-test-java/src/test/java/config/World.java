package config;

import org.openqa.selenium.WebDriver;
import pageobjects.SampleWebsiteLoginPO;
import step_definition.Hooks;

import java.util.Map;

public class World {
    private WebDriver driver;
    private SampleWebsiteLoginPO loginPO;
    private Map<String, Object> testData;

    public World() {
        this.driver = Hooks.driver;
        this.testData = Hooks.testData;
        this.loginPO = new SampleWebsiteLoginPO(this.driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public SampleWebsiteLoginPO getLoginPO() {
        return loginPO;
    }
    public Map<String, Object> getTestData() {
        return testData;
    }

}
