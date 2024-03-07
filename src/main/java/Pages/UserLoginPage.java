package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLoginPage extends PageBase {
    public UserLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    WebElement email_TxtBox;

    @FindBy(id = "Password")
    WebElement password_TxtBox;

    @FindBy(css = "body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div.page-body " +
            "> div.customer-blocks > div.returning-wrapper.fieldset > form > div.buttons > button")
    WebElement login_Btn;


    public void userLogin(String email, String password){
        sendKeys_to_TxtBox(email_TxtBox,email);
        sendKeys_to_TxtBox(password_TxtBox,password);
        clickButton(login_Btn);
    }
}
