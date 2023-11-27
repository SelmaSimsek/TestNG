package techproed.test.day21_POM;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.utilities.Driver;

import java.awt.image.Kernel;
import java.security.Key;
import java.util.AbstractMap;

public class C02_PageKullanimi {
    @Test
    public void test01() {
        //amazon sayfasina gidelim
        Driver.getDriver().get("https://amazon.com");


        //arama kutusuna iphone yazalim
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.searchBox.sendKeys("iphone", Keys.ENTER);

    }
}
