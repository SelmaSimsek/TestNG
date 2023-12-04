package techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    //WebDriver tipinde bir ThreadLocal objecti olusturduk
    //ThreadLocal ile her thread icin ayri bir WebDriver objesi olusturuyoruz
    //Bu sayede paralel test yaparken her threadin kendi webdriver objectine sahip olmasini sagladik
    //ve böylece pralel olarak calisan farkli threadler birbirlerinin webdriverlerini etkileyemezler

    private static ThreadLocal<WebDriver>driverPoll = new ThreadLocal<>();


   // static WebDriver driver;

    public static WebDriver getDriver(){

        if(driverPoll.get()==null){
            // WebDriver i thread bazında oluşturuyoruz.
            switch (ConfigReader.getProperty("browser")) {
                case "chrome" :
                    driverPoll.set(new ChromeDriver());
                    break;

                case "edge" :
                    driverPoll.set(new EdgeDriver());
                    break;

                case "safari" :
                    driverPoll.set(new SafariDriver());
                    break;

                case "firefox" :
                    driverPoll.set(new FirefoxDriver());
                    break;

                default:
                    driverPoll.set(new ChromeDriver());

                    // Oluşturulan WebDriveri yapılandırıyoruz

            }
            driverPoll.get().manage().window().maximize();
            driverPoll.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        // Thread'a özgü WebDriver objecti return ediyoruz.
        return driverPoll.get();
    }

    private Driver() {
        /*
        POM de Driver classindan object olusturarak getDriver methodu kullanimini engellemeliyiz
        Bu nedenle singleton pattern kullanimi benimsenmistir
        Singleton Pattern : Bir classin farkli classlardan object olusturarak kullanilmasini engellemek icin kullanilir
        bu yüzden constructor i private yaptik
         */
    }

    /*
    Driver i her cagirdigimizda yeni bir pencere acmammasi icin bir if bloğu ile ayarlama yaptik
     if(driver==null) ile eger driver a deger atanmamis ise driver i baslat dedik, driver acik iken tekrar cagrilirsa
     driver a deger atanmis oldugu icin if block calismayacak ve dolayisiyla bu method mevcut driver i tekar return edecek
     Böylece ayni driver uzerinden test senaryolarimiza devam edebileceğiz
     */

    /*
    Page Object Model de driver icin TestBase classina extends yaparak kullanmak yerine Driver classi olusturularak bu classtan
    static method araciligi ile driver olusturup kullanmak tercih edilir
     */

    public static void closeDriver(){
        // Açık olan WebDriver örneğini kapatıyoruz.
        if(driverPoll.get()!=null){
            driverPoll.get().quit();
            driverPoll.remove();
           // ThreadLocal'daki referansı temizliyoruz.
        }
    }






}