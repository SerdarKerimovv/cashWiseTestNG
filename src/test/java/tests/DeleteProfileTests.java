package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeleteProfilePage;
import pages.LoginPage;
import utils.BaseUI;
import utils.ConfigurationReader;
import utils.Driver;

public class DeleteProfileTests extends BaseUI {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    DeleteProfilePage deleteProfilePage = new DeleteProfilePage();

    @Test(priority = 1, groups = {"regression"})
    public void deleteProfile() {

        loginPage.login(
                ConfigurationReader.getProperty("username"),
                ConfigurationReader.getProperty("password")
        );

        deleteProfilePage.deleteProfile();

        waitForUrlContains("main");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("main"),
                "Profile was not deleted successfully"
        );
    }
}