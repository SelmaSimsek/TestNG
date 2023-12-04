package techproed.tests.day22_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_PropertiesTest {
    @Test
    public void test01() {
        String amazonUrl = ConfigReader.getProperty("amazonUrl");
        System.out.println("amazonUrl = " + amazonUrl);
        Driver.getDriver().get(amazonUrl);
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

    }

    @Test
    public void test02()throws InterruptedException {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("openSourceUrl"));

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        //kullanici=Admin
        //kullaniciSifre=admin123
        OpenSourcePage openSourcePage = new OpenSourcePage();
        openSourcePage.username.sendKeys(ConfigReader.getProperty("openSourceUsername"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("openSourcePassword"));
        openSourcePage.loginButton.click();

        Thread.sleep(2000);

        //Login Testinin basarili oldugunu test edelim
        Assert.assertTrue(openSourcePage.dashboard.isDisplayed());

        //sayfayı kapatalim
        Driver.closeDriver();
    }

    //Resuable Methods Kullanimi
    @Test
    public void test03()throws InterruptedException {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("openSourceUrl"));

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        //kullanici=Admin
        //kullaniciSifre=admin123
        OpenSourcePage openSourcePage = new OpenSourcePage();
        openSourcePage.username.sendKeys(ConfigReader.getProperty("openSourceUsername"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("openSourcePassword"));
        openSourcePage.loginButton.click();

        ReusableMethods.bekle(1);
        ReusableMethods.visibleWait(openSourcePage.dashboard,15);


        //Login Testinin basarili oldugunu test edelim
        Assert.assertTrue(openSourcePage.dashboard.isDisplayed());
        ReusableMethods.screenShot("OpenSourse");
        ReusableMethods.screenShotOfWebElement(openSourcePage.dashboard);

        //sayfayı kapatalim
        Driver.closeDriver();
    }
}
