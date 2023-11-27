package techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    private Driver(){
        /*
        POM de Driver classindan object olusturarak getDriver methodu kullanimini engellemeliyiz
        Bu nedenle singleton pattern kullanimi benimsenmistir
        Singleton Pattern: Bir classin farkli klaslardan object olusturularak kullanilmasini engellemek icin kullanilir
        Bu yüzden Constroctur i private yaptik
         */

    }
    static WebDriver driver;

    public static WebDriver getDriver () {
        if(driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }
        return driver;
    }
    /*
    Driver i her actigimizda yeni bir pencere acmamasi icin bir if blogu ile ayarlama yaptik
    if(driver==null) ile eger driver a deger atanmamis ise driver i baslat dedik, driver acik iken tekrar cagrilirsa
    driver a deger atanmamis oldugu icin if block calismayacak ve dolayisiyla bu method mevcut driver i tekrar return edecek
    Böylece ayni driver üzerinden test senaryolarimiza devam edebilecegiz
     */
    /*
    Pege Object Modelde driver icin TestBase classina extends yaparak kullanmak yerine
    Driver classi olusturarak bu classtana static method araciligi ile driver olusturup kullanmak
    tercih edilir
     */

    public static void closeDriver(){
        if (driver!=null){
            driver.close();
            driver=null;
        }
    }
}
