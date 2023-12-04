package techproed.tests.day20_annotations_softassert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C05_SoftAssertion {
    @Test
    public void softAssertionTest() {

        //öncelikle SoftAssert classindan bir object olusturmaliyiz
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(2,2,"2 esittir 2 ye bu kontrol basarili");
        softAssert.assertTrue(2>3,"2 3 ten büyük olmaliydi bu kontrol basarisiz");
        softAssert.assertTrue(3>2,"3 2 den büyük olmamaliydi bu kontrol basarisiz");
        softAssert.assertNotEquals("java","java","iki string farkli olmaliydi, bu kontrol basarisiz");


        //assertAll methodu kendisinden önce yapilan tüm soft assertion lari degerlendirir,
        //eger herhangi bir method fail olduysa test basarisiz olur ve classin kalan kismi calistirilmaz
        //bu method cagrilmazsa soft assertion basarisiz olup olmadigi anlasilmaz
        softAssert.assertAll();


        System.out.println("Bu kodu consolda görebilir miyim");

    }

    @Test
    public void hardAssertion() {

        System.out.println("bu kod hard assertion dan once ");

        Assert.assertTrue(false);

        System.out.println("bu kod hard assertion dan sonra ");


    }




}
