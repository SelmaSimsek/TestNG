package techproed.tests.day23_excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;

public class C03_BlueRentalCarExcelTest {

    BlueRentalPage blueRentalPage;
    @Test
    public void test01() {
        //BlueRentalCar sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //Excel dosyasindaki tum email ve passwordler ile login olalim ve login oldugumuzu dogrulayalim
        blueRentalPage = new BlueRentalPage();
        String dosyaYolu ="src\\test\\java\\techproed\\resources\\mysmoketestdata.xlsx";
        String sayfaIsmi="customer_info";
        ExcelReader excelReader = new ExcelReader(dosyaYolu,sayfaIsmi);

        for (int i = 1; i <= 7; i++) {
            String email = excelReader.getCellData(i,0);
            String password = excelReader.getCellData(i,1);

            blueRentalPage.loginButton.click();
            blueRentalPage.email.sendKeys(email);
            blueRentalPage.password.sendKeys(password, Keys.ENTER);
            blueRentalPage.loginVerify.click();
            Assert.assertTrue(blueRentalPage.profile.isDisplayed());
            blueRentalPage.logoutButton.click();
            blueRentalPage.okButton.click();
            break;

        }

        //sayfayi kapatalim
        Driver.closeDriver();
    }
}
