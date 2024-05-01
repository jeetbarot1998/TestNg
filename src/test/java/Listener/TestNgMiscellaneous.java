package Listener;
import org.testng.annotations.Test;

public class TestNgMiscellaneous {

    @Test(invocationCount = 10)
    public void t1(){
        System.out.println("10 times");
    }

    @Test(timeOut = 2000)
//    if not responded or completed the test case within 2000ms,
//    then mark the test as failed.
    public void t2(){
        int i = 0;
        while (true)
            i++;
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void t3(){
        String s = "%90";
        System.out.println(Integer.parseInt(s));
    }

}
