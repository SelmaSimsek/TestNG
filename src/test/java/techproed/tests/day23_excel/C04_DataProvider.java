package techproed.tests.day23_excel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class C04_DataProvider {


    @DataProvider
    public static Object[][] araclar(){
        return new Object[][] {
                {"mercedes"},
                {"volvo"},
                {"tofas"},
                {"honda"}
        };
    }


    @Test(dataProvider = "araclar")
    public void test01(String data) {
        System.out.println(data);
    }
}
