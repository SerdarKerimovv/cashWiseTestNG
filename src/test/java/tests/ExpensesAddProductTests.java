package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.ExpensesAddProductPage;
import pages.LoginPage;
import utils.BaseUI;
import utils.ConfigurationReader;
import utils.Driver;

public class ExpensesAddProductTests extends BaseUI {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage=new LoginPage();
    ExpensesAddProductPage expensesAddProductPage = new ExpensesAddProductPage();
    CommonPage commonPage=new CommonPage();

    @Test (priority = 1, groups = {"expenses"})
    public void addProductAndServiceTest(){
        loginPage.login(
                ConfigurationReader.getProperty("username"),
                ConfigurationReader.getProperty("password"));
        commonPage.expenses.click();

        expensesAddProductPage.addProductsAndServices();

        waitForUrlContains("expenses");

        Assert.assertTrue(driver.getCurrentUrl().contains("expenses"));

    }
    @Test (priority = 2, dependsOnMethods = "addProductAndServiceTest",groups = {"expenses"})
    public void verifyExpensesPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("expenses"));
    }

}
