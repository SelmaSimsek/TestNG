package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.Driver;

public class ZeroWebappsecurityPage {

    public ZeroWebappsecurityPage() {
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath="//button[@id='signin_button']")
    public WebElement signinButton;

    @FindBy(xpath="//input[@id='user_login']")
    public WebElement loginTextBox;

    @FindBy(xpath="//input[@id='user_password']")
    public WebElement passwordTextBox;

    @FindBy(xpath="//input[@type='submit']")
    public WebElement signInButton2;

    @FindBy(xpath="//li[@id='onlineBankingMenu']")
    public WebElement onlineBankingMenu;

    @FindBy(xpath="//span[@id='pay_bills_link']")
    public WebElement payBillsMenu;

    @FindBy(xpath="//a[.='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrency;

    @FindBy(xpath="//select[@id='pc_currency']")
    public WebElement currencyDdm;










}


