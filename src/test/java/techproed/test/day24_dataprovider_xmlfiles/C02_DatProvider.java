package techproed.test.day24_dataprovider_xmlfiles;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_DatProvider {
/*
    1) Bir data provideri birden fazla test methodu icin kullanmak mumkundür

    2) Bir data provideri belli methodlara özel olarak specificlesitirebiliriz
    Bunu yapmak icin @DataProvider(name = "googleurunler") seklinde parantez icinde name parametresi tanimlariz
    bu sekilde vermis olduguumz isim dataproviderin kendi ismini gecersiz kilar yani artik bu isim gecerli olur
    böylece bu dataprovider sadece bu isme sahip olan test methoduna data provide eder
     */


    @DataProvider(name = "googleurunler")
    public static Object[][] urunler() {
        return new Object[][]{
                {"laptop"},{"iphone"},{"mouse"}
        };
    }


    @Test(dataProvider = "googleurunler")
    public void test01(String data) {

        //Google sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //DataProvider ile istediğimiz arac isimlerini aratalım
        new GooglePage().searchBox.sendKeys(data, Keys.ENTER);

        //sayfayı kapatalım
        Driver.closeDriver();

    }



    @DataProvider
    public static Object[][] amazonurunler() {
        return new Object[][]{
                {"laptop"},{"iphone"},{"mouse"}
        };
    }


    @Test(dataProvider = "amazonurunler")
    public void test02(String data) {

        //amazon sayfasına gidelim,
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ReusableMethods.bekle(2);
        Driver.getDriver().navigate().refresh();

        //aramakutusunda dataprovider'dan gelen verileri aratalım
        new AmazonPage().searchBox.sendKeys(data,Keys.ENTER);

        //sayfayı kapatınız
        Driver.closeDriver();

    }
}
