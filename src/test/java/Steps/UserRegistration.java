package Steps;

import Pages.HomePage;
import Pages.UserLoginPage;
import Pages.UserRegistrationPage;
import Runner.TestRunner;
import Tests.TestBase;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserRegistration extends TestRunner {
    HomePage homeObject;
    UserRegistrationPage userRegistrationObject;
    UserLoginPage userLoginObject;
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String secondName = faker.name().lastName();
    long password = faker.number().randomNumber(8, true);
    String email = faker.internet().safeEmailAddress();


    @Given("the user in the home page")
    public void the_user_in_the_home_page() throws AssertionError{
        homeObject = new HomePage(driver);
        userRegistrationObject = new UserRegistrationPage(driver);
        Assert.assertTrue(driver.getCurrentUrl().contentEquals("https://demo.nopcommerce.com/"));

        //  throw new io.cucumber.java.PendingException();
    }

    @When("the user clicks on register")
    public void the_user_clicks_on_register() {
        homeObject.OpenRegisteration();

        Assert.assertTrue(driver.getCurrentUrl().contains("register"));

        //   throw new io.cucumber.java.PendingException();
    }

//    @When("enters valid credentials")
//    public void enters_valid_credentials() {
//
//        userRegistrationObject.UserRegisteration(firstName, secondName, String.valueOf(password), email);
//        //   throw new io.cucumber.java.PendingException();
//    }

    @When("enters {string}, {string}, {string}, {string}")
    public void enters(String firstName, String secondName, String password, String email) {

        userRegistrationObject.UserRegisteration(firstName, secondName, password, email);
        Assert.assertFalse(userRegistrationObject.alertMsg_failureToRegister.isDisplayed());
    }

//    @Then("user registers successfully and logins with")
//    public void user_registers_successfully() {
//        userLoginObject = new UserLoginPage(driver);
//        homeObject.openLoginPage();
//        userLoginObject.userLogin(email, String.valueOf(password));
//        homeObject.logoutOfAccount();
//
//         throw new io.cucumber.java.PendingException();
//    }
    @Then("user registers successfully and Logins with {string}, {string}")
    public void user_registers_successfully_and_logins_with(String email, String password) {
        userLoginObject = new UserLoginPage(driver);
        homeObject.openLoginPage();
        userLoginObject.userLogin(email, password);
        homeObject.logoutOfAccount();
    }

}
