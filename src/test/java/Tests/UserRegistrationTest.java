package Tests;

import Pages.HomePage;
import Pages.UserLoginPage;
import Pages.UserRegistrationPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserRegistrationTest extends TestBase {
    HomePage homeObject;
    UserRegistrationPage userRegisterObject;
    UserLoginPage userLoginObject;


    @Test(priority = 1)
    public void UserRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        userRegisterObject = new UserRegistrationPage(driver);


        homeObject.OpenRegisteration();
        userRegisterObject.UserRegisteration("ahmed", "tarek", "12345678", "ahmed13@Test.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(userRegisterObject.successMessage.getText().contains("Your registration completed"));

        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOf(homeObject.loginLink));
    }

    @Test(dependsOnMethods = "UserRegisterSuccessfully")
    public void UserCanLoginSuccessfully() {
        userLoginObject = new UserLoginPage(driver);
        homeObject.openLoginPage();
        userLoginObject.userLogin("ahmed13@Test.com", "12345678");

        Assert.assertTrue(homeObject.logoutLink.getText().contains("Log out"));
    }


    @Test(dependsOnMethods = "UserCanLoginSuccessfully")
    public void UserCanLogoutSuccessfully() {
        homeObject.logoutOfAccount();
    }


}
