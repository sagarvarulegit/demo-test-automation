package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SampleWebsiteLoginPO extends BasePageObject {

    @FindBy(id = "input_username")
    private WebElement txt_username;
    @FindBy(id = "input_password")
    private WebElement txt_password;
    @FindBy(id = "button_login")
    private WebElement btn_Login;
    @FindBy(id = "message_span")
    private WebElement span_msg;

    public SampleWebsiteLoginPO(WebDriver driver) {
        super(driver);
    }

    public void loginToApp(String username, String password){
        enterText(txt_username,username);
        enterText(txt_password,password);
        click(btn_Login);
    }

    public String getMessage(){
        return getText(span_msg);
    }


}
