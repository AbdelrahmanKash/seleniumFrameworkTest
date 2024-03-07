package Pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    @FindBy(className = "ico-register")
    WebElement registerLink;

    @FindBy(className = "ico-login")
    public WebElement loginLink;

    @FindBy(className = "ico-logout")
    public WebElement logoutLink;

    @FindBy(className = "ico-account")
    WebElement myAccountLink;

    @FindBy(className = "close")
    public WebElement closePassChangedAlert;

    @FindBy(css = "body > div.master-wrapper-page > div.header-menu > ul.top-menu.notmobile > li:nth-child(1) > a")
    WebElement computersDropdown;

    @FindBy(css = "body > div.master-wrapper-page > div.header-menu" +
            " > ul.top-menu.notmobile > li:nth-child(1) > ul > li:nth-child(2) > a")
    WebElement notebooksInDropdown;

    public void OpenRegisteration() {
        clickButton(registerLink);
    }

    public void openLoginPage() {
        clickButton(loginLink);
    }

    public void logoutOfAccount() {
        clickButton(logoutLink);
    }

    public void OpenMyAccount() {
        clickButton(myAccountLink);
    }

    public void closePassChangedAlert(){
        clickButton(closePassChangedAlert);
    }

    public void selectNotebooksInComputerDropdown(){
        actions
                .moveToElement(computersDropdown)
                .moveToElement(notebooksInDropdown)
                .click()
                .build()
                .perform();
    }
}
