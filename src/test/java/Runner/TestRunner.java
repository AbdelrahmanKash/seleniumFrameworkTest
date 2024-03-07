package Runner;

import Tests.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Features"
        , glue = "Steps"
        , plugin = {"pretty", "html:target/cucumber-report/cucumber.html"})
public class TestRunner extends TestBase {

}
