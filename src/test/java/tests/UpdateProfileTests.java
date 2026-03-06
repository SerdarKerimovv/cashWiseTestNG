package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UpdateProfilePage;
import utils.BaseUI;
import utils.ConfigurationReader;
import utils.Driver;

public class UpdateProfileTests extends BaseUI {

    WebDriver driver = Driver.getDriver();
    UpdateProfilePage updateProfilePage = new UpdateProfilePage();
    LoginPage loginPage = new LoginPage();

    @Test(priority = 1, groups = {"regression"})
    public void updateProfile() {

        loginPage.login(
                ConfigurationReader.getProperty("username"),
                ConfigurationReader.getProperty("password")
        );

        updateProfilePage.updateProfile();

        waitForUrlContains("profile");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("profile"),
                "Profile update failed"
        );
    }
}