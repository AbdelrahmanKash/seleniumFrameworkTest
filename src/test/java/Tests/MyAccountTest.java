package Tests;

import Pages.HomePage;
import Pages.MyAccountPage;
import Pages.UserLoginPage;
import Pages.UserRegistrationPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyAccountTest extends TestBase {
    HomePage homeObject;
    MyAccountPage myAccountObject;
    UserRegistrationPage userRegisterObject;
    UserLoginPage userLoginObject;
    String firstname = "ahmed";
    String lastname = "tarek";
    String password = "12345678";
    String newpass = "123456";
    String email = "ahmed24@test.com";

    @Test(priority = 1)
    public void UserRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        userRegisterObject = new UserRegistrationPage(driver);


        homeObject.OpenRegisteration();
        userRegisterObject.UserRegisteration(firstname, lastname, password, email);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        Assert.assertTrue(userRegisterObject.successMessage.getText().contains("Your registration completed"));

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(homeObject.loginLink));
    }

    @Test(dependsOnMethods = "UserRegisterSuccessfully")
    public void UserCanLoginSuccessfully() {
        userLoginObject = new UserLoginPage(driver);
        homeObject.openLoginPage();
        userLoginObject.userLogin(email, password);

        Assert.assertTrue(homeObject.logoutLink.getText().contains("Log out"));
    }

    @Test(dependsOnMethods = "UserCanLoginSuccessfully")
    public void UserCanChangePassSuccessfully() {
        myAccountObject = new MyAccountPage(driver);
        homeObject.OpenMyAccount();
        myAccountObject.UserChangePassword(password, newpass, newpass);
        homeObject.closePassChangedAlert();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.invisibilityOf(homeObject.closePassChangedAlert));

        homeObject.logoutOfAccount();
        homeObject.openLoginPage();
        userLoginObject.userLogin(email, newpass);

        Assert.assertTrue(homeObject.logoutLink.getText().contains("Log out"));
    }


}
