import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionDemo {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void t1(){
        System.out.println("t1");
        softAssert.assertTrue(false);
        System.out.println("abc");
        softAssert.assertAll();
    }

    @Test
    public void t2(){
        System.out.println("t2");
        softAssert.assertTrue(false);
        System.out.println("cde");
    }

}
