package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Change password")
    WebElement changePasswordPage;

    @FindBy(id = "OldPassword")
    WebElement oldPasswordTxtBox;

    @FindBy(id = "NewPassword")
    WebElement newPasswordTxtBox;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmPasswordTxtBox;

    @FindBy(css = "body > div.master-wrapper-page " +
            "> div.master-wrapper-content > div > div.center-2 > div > div.page-body > form > div.buttons > button")
    WebElement changePasswordBtn;

    public void UserChangePassword(String oldPassword, String newPassword, String confirmPassword) {
        clickButton(changePasswordPage);
        sendKeys_to_TxtBox(oldPasswordTxtBox, oldPassword);
        sendKeys_to_TxtBox(newPasswordTxtBox, newPassword);
        sendKeys_to_TxtBox(confirmPasswordTxtBox, confirmPassword);
        clickButton(changePasswordBtn);
    }
}
