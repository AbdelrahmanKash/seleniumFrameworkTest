package Tests;

import Utilities.Helper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class TestBase extends AbstractTestNGCucumberTests {
    public static WebDriver driver;


    @BeforeSuite
    @Parameters({"browser"})
    public void openDriver(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }


        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");

        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.titleContains("nopCommerce demo store"));


    }

    @AfterSuite
    public void closeDriver() {
        driver.quit();
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Method failure...");
            System.out.println("Taking screenShot");
            Helper.CaptureScreenshot(driver, result.getName());
        }

    }

}

