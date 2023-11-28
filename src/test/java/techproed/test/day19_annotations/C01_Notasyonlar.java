package techproed.test.day19_annotations;

import org.testng.annotations.*;

public class C01_Notasyonlar {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Herseyden önce BeforeSuite notaasyonuna sahip olan method 1 kez calisir");

    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Herseyden sonra AfterSuite notaasyonuna sahip olan method 1 kez calisir");

    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Testlerden önce BeforeTest notaasyonuna sahip olan method 1 kez calisir");

    }

    @AfterTest
    public void afterTest() {
        System.out.println("Testlerden sonra AfterTest notaasyonuna sahip olan method 1 kez calisir");

    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Her class tan önce BeforeClass notaasyonuna sahip olan method 1 kez calisir");
        System.out.println("**************************************************");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Her class tan sonra AfterClass notaasyonuna sahip olan method 1 kez calisir");
        System.out.println("*************************************************");
    }
    @BeforeMethod
    public void setUp() {
        System.out.println("BeforeMethod notaasyonuna sahip olan method test methodundan önce 1 kez calisir");
    }
    @AfterMethod
    public void tearDown() {
        System.out.println("AfterMethod notaasyonuna sahip olan method test methodundan sonra 1 kez calisir");
    }

    @Test
    public void test01() {
        System.out.println("test01 methodu calisti");
    }
    @Test
    public void test02() {
        System.out.println("test02 methodu calisti");
    }
    @Test
    public void test03() {
        System.out.println("test03 methodu calisti");
    }
    //Junit te @BeforeClass ve @After Class notasyonuna sahip methodlar statik olmak zorundaydi
    // TestNG bu zorunlulugu kaldirdi

}