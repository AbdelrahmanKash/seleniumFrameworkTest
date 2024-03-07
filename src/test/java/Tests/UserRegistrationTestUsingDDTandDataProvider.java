package Tests;

import Pages.HomePage;
import Pages.UserLoginPage;
import Pages.UserRegistrationPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserRegistrationTestUsingDDTandDataProvider extends TestBase {
    HomePage homeObject;
    UserRegistrationPage userRegisterObject;
    UserLoginPage userLoginObject;


    @DataProvider(name = "UserData_dataProvider")
    public static Object[][] userData(){
        return new Object[][]{
                        {"ahmed","tarek","test1@test.com","123456"}
                ,{"mhmd","ahmed","test2@test.com","12345678"}};
    }




    @Test(priority = 1)
    public void UserRegisterSuccessfully(String fname, String lname, String password, String email) {
        homeObject = new HomePage(driver);
        userRegisterObject = new UserRegistrationPage(driver);


        homeObject.OpenRegisteration();
        userRegisterObject.UserRegisteration(fname, lname, password, email);
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
