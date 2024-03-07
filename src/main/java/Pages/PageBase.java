package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

    protected WebDriver driver;
    protected Actions actions;
    protected Select select;

    //Create Constructor To Use driver
    public PageBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected static void clickButton(WebElement button){
        button.click();
    }
    protected static void sendKeys_to_TxtBox(WebElement TextBox, String value){
        TextBox.sendKeys(value);
    }
}
