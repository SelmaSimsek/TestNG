package techproed.test.day20_annotations_softassert;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_DependsOnMethods {
    /*
    TestNG de DependsOnMethods özelligini kullanarak bazi testlerin bagimli oldugu
    diger testlerin basarili olmasi durumuna göre calistirabiliriz
    DependsOnMethods baglandigi testin sonucuna bakar, passed olursa calisir
    fail olursa hic calismaz
     */
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        //amazon sayfasina gidiniz
        driver.get("https;//amazon.com");

        //arama kutusunda iphone aratiniz
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone");
        searchBox.submit();
        //sonuc yazisinin iphone icerdigini test edelim
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        //sonuc yazisinin iphone icerdigini test edelim
       String sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner')[1]")).getText();
        Assert.assertTrue(sonucYazisi.contains("iphone"));
    }
    @AfterClass
    public void afterClass(){
        driver.close();
    }
}
