package tests;



import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.SignupPage;
import utils.BaseUI;
import utils.ConfigurationReader;
import utils.Driver;

public class SignupTests extends BaseUI {
    WebDriver driver = Driver.getDriver();
    SignupPage signupPage = new SignupPage();

    @Test
    public void signupTest() {
        signupPage.signup(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"),
                ConfigurationReader.getProperty("firstName"), ConfigurationReader.getProperty("lastName"),
                ConfigurationReader.getProperty("companyName"), ConfigurationReader.getProperty("address"));

        waitForUrlContains("dashboard");
        Assertions.assertTrue(driver.getCurrentUrl().contains("dashboard"));

    }
}