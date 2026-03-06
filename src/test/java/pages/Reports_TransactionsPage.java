package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.BaseUI;
import utils.Driver;

public class Reports_TransactionsPage extends BaseUI {

    WebDriver driver;

    public Reports_TransactionsPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add income')]")
    WebElement addIncomeBtn;

    @FindBy(xpath = "//div[contains(., 'Payment date')]//button[contains(@aria-label, 'Choose date')]")
    WebElement calendarIcon;

    @FindBy(xpath = "//button[@aria-label='Mar 17, 2026']")
    WebElement dateSelection;

    @FindBy(xpath = "//input[@placeholder='File title']")
    WebElement fileTitleInput;

    @FindBy(xpath = "//input[@type='file']")
    WebElement selectFile;

    @FindBy(xpath = "//input[@id='name_of_payment_input_text']")
    WebElement titleInput;

    @FindBy(xpath = "//div[@id='mui-component-select-category_id']")
    WebElement categoryDropDown;


    @FindBy(xpath = "//li[text()='Word documents']")
    public WebElement wordDocumentsButton;


    @FindBy(id = "category_title_input_text")
    WebElement newCategoryTitle;

    @FindBy(id = "category_description_input_text")
    WebElement newCategoryDescription;


    @FindBy(xpath = "//button[text()='Save']")
    WebElement newCategorySaveBtn;


    @FindBy(xpath = "//div[@id='mui-component-select-type_of_pay']")
    WebElement paymentMethodDropdown;

    @FindBy(xpath = "//li[@role='option' and text()='Bank']")
    WebElement paymentMethodSelection;

    @FindBy(xpath = "//div[@id='mui-component-select-bank_account']")
    WebElement toWhichCheck;

    @FindBy(xpath = "//button[text()='Create new invoice']")
    WebElement createNewInvoice;

    @FindBy(xpath = "//input[@id='bank_account_name_input_text']")
    WebElement invoiceFormTitle;

    @FindBy(xpath = "//input[@id='balance_input_text']")
    WebElement invoiceFormBalance;

    @FindBy(xpath = "//input[@id='description_input_text']")
    WebElement invoiceFormDescription;

    @FindBy(xpath = "//button[@form='createPayment']")
    WebElement invoiceFormSaveBtn;

    @FindBy(xpath = "//input[@id='amount_of_money_input_text']")
    WebElement inputForSum;

    @FindBy(xpath = "//button[text()='Accept']")
    WebElement acceptBtn;

    @FindBy(xpath = "//li[contains(., 'Sun')]")
    public WebElement businessCat;

    @FindBy(xpath = "//li[text()='Ramadan Mubarak']")
    public WebElement paymentOptionRamadanMubarak;


    public void clickAddIncome() {
        addIncomeBtn.click();
        calendarIcon.click();
        dateSelection.click();
        selectFile.sendKeys("/Users/gulnuru/Downloads/ElectricityJan.pdf");


        clearAndSendKeys(titleInput, "John Doe");
        categoryDropDown.click();
        waitAndClick(wordDocumentsButton);

//        newCategory.click();
//        clearAndSendKeys(newCategoryTitle, "project");
//        clearAndSendKeys(newCategoryDescription, "for tomorrow");
//        newCategorySaveBtn.click();
        paymentMethodDropdown.click();
        paymentMethodSelection.click();
        toWhichCheck.click();
        waitAndClick(paymentOptionRamadanMubarak);

//        createNewInvoice.click();
//        clearAndSendKeys(invoiceFormTitle, "Ramadan Mubarak");
//        clearAndSendKeys(invoiceFormBalance, "5000");
//        clearAndSendKeys(invoiceFormDescription, "Ramadan celebration for the community");
//       waitAndClick(invoiceFormSaveBtn);
        inputForSum.sendKeys("3000");
        acceptBtn.click();
    }

//    public void clickAddExpense() {
//        addExpenseBtn.click();
//    }

}

