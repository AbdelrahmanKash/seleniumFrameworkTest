package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {
    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement genderMale_RadButton;

    @FindBy(id = "FirstName")
    WebElement firstName_TxtBox;

    @FindBy(id = "LastName")
    WebElement lastName_TxtBox;

    @FindBy(id = "Email")
    WebElement emailtxt_Box;

    @FindBy(id = "Password")
    WebElement password_TxtBox;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword_TxtBox;

    @FindBy(id = "register-button")
    WebElement register_Btn;

    @FindBy(className = "result")
    public WebElement successMessage;

    @FindBy(css = "body > div.master-wrapper-page > div.master-wrapper-content > div > div > div" +
            " > div.page-body > form > div.message-error.validation-summary-errors > ul > li")
    public WebElement alertMsg_failureToRegister;

    public void UserRegisteration(String firstname, String lastname, String password, String email) {
       clickButton(genderMale_RadButton);
       sendKeys_to_TxtBox(firstName_TxtBox,firstname);
       sendKeys_to_TxtBox(lastName_TxtBox, lastname);
       sendKeys_to_TxtBox(emailtxt_Box, email);
       sendKeys_to_TxtBox(password_TxtBox, password);
       sendKeys_to_TxtBox(confirmPassword_TxtBox, password);
       clickButton(register_Btn);
    }



}
