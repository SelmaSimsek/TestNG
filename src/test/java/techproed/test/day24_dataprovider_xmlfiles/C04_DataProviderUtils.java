package techproed.test.day24_dataprovider_xmlfiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.DataProviderPage;

import techproed.utilities.Driver;

public class C04_DataProviderUtils {
    @Test(dataProvider = "positiveTestData", dataProviderClass = C04_DataProviderUtils.class)
    public void test01(int age) {

        //https://dataprovider.netlify.app/ adresine gidelim
        Driver.getDriver().get("https://dataprovider.netlify.app/");


        //BlackBoxTesting techniques ile otomasyon test yapalim
        DataProviderPage dataProviderPage=new DataProviderPage();
        dataProviderPage.searcBox.sendKeys(String.valueOf(age), Keys.TAB,Keys.ENTER);

        Assert.assertTrue(dataProviderPage.positiveVerifyMessage.isDisplayed());
        //Driveri kapatalim
        Driver.closeDriver();




    }
}
