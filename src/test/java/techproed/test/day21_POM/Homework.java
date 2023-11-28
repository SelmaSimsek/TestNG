package techproed.test.day21_POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.ZeroWebappsecurityPage;
import techproed.utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;



public class Homework {
    @Test
    public void test01() throws InterruptedException {

        //1."http://zero.webappsecurity.com/" Adresine gidin başlığın Personal içerdiğini test edin
        Driver.getDriver().get("http://zero.webappsecurity.com/");
        String zeroTitle = Driver.getDriver().getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(zeroTitle.contains("Personal"), "Title Personal icermiyor");


        //2. Sign in butonuna basin
        ZeroWebappsecurityPage zeroWebappsecurityPage = new ZeroWebappsecurityPage();
        zeroWebappsecurityPage.signinButton.click();


        //3. Login kutusuna "username" yazin
        //4. Password kutusuna "password" yazin
        //5. Sign in tusuna basin
        zeroWebappsecurityPage.loginTextBox.sendKeys("username");
        zeroWebappsecurityPage.passwordTextBox.sendKeys("password");
        zeroWebappsecurityPage.signInButton2.click();
        Driver.getDriver().navigate().back();


        //6. Online banking menusu icinde Pay Bills sayfasina gidin başlığın Zero içerdiğini test edin
        zeroWebappsecurityPage.onlineBankingMenu.click();
        zeroWebappsecurityPage.payBillsMenu.click();
        String payBillsTitle = Driver.getDriver().getTitle();
        softAssert.assertTrue(payBillsTitle.contains("Zero"), "Pay Bills sayfa basligi Zero icermiyor");


        //7. "Purchase Foreign Currency" tusuna basin
        zeroWebappsecurityPage.purchaseForeignCurrency.click();
        Thread.sleep(2000);

        //8. "Currency" drop down menusunden Eurozone'u secin
        Select selectCurrency = new Select(zeroWebappsecurityPage.currencyDdm);
        selectCurrency.selectByVisibleText("Eurozone (euro)");


        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        String selectedOption = selectCurrency.getFirstSelectedOption().getText();
        softAssert.assertTrue(selectedOption.contains("Eurozone (euro)"), "Eurozone (euro) secenegi secili degil");


        //10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
        //edin ("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
        //(franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
        //(pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
        //(krone)","New Zealand (dollar)","Sweden (krona)","Singapore
        //(dollar)","Thailand (baht)")


        String[] expectedCurrecyList= { "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
                "China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)",
                "Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
                "Singapore (dollar)","Thailand (baht)" };
        List<String> actualCurrencyList= new ArrayList<>();
        List<WebElement> currencyList = selectCurrency.getOptions();

        for (WebElement each: currencyList){
            actualCurrencyList.add(each.getText());
        }
        System.out.println("actualCurrencyList = " + actualCurrencyList);
        softAssert.assertTrue(actualCurrencyList.containsAll(Arrays.asList(expectedCurrecyList)), "Dropdow bu listenin hepsini icermiyor");
        softAssert.assertAll();
        Driver.closeDriver();

        }

    }
