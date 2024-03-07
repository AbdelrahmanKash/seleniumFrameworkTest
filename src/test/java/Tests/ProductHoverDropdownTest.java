package Tests;

import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductHoverDropdownTest extends TestBase{
    HomePage homeObject;

    @Test
    public void UserCanSelectSubCategoryInComputerDropdown(){
        homeObject = new HomePage(driver);
        homeObject.selectNotebooksInComputerDropdown();

        Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));

    }
}
