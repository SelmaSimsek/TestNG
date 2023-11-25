package techproed.test.day20_annotations_softassert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_Ignore {

    WebDriver driver;

    @BeforeMethod()
    public void SetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test @Ignore
    public void youtubeTest() {
        driver.get("https://youtube.com");
        /*
    @Ignore annotation i bu testin calistirilirken görmezden gelmek icin kullanilir,
    bu notasyona sahip test methodu calistirilmaz
     */
    }

    @Test(enabled = false)
    public void amazonTest() {
        driver.get("https://amazon.com");
        /*
           @Test(enabled = false) parametresi bu testin devre disi birakilmasin saglar
           bu yöntem kalici olarak devre disi birakmak icin kullanilir
         */
    }

    @Test
    public void facebookTest() {
        driver.get("https://facebook.com");
        boolean excelDosyaYolu=false;
        if(excelDosyaYolu){
            System.out.println("testleri calistir");
        }else {
            throw new SkipException("Excel dosyasi baglantisinda dosya bulunamadi");
        }

        /*
        Bu testte SkipException kullanarak testin calistirilmasini run time da dynamic olarak durdurabiliriz
        SkipException firlatildiginda test "Skipped" olarak isaretlenir
        dolayisiyla bu yöntem testin belirli kosullar altinda atlanmasi gerektiginde kullanilabilir
         */

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
