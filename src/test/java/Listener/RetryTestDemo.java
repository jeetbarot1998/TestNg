package Listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//@Listeners(RetryAnnotationTransformer.class)
public class RetryTestDemo {
    static int count = 0;

//    @Test
    @Test(retryAnalyzer = Retry.class)
    public void t1(){
        count ++;
        System.out.println(count);
        Assert.assertEquals("ABC", "CDE");
    }

//    @Test
    @Test(retryAnalyzer = Retry.class)
    public void t2(){
        Assert.assertEquals("ABC", "CDE");
    }
}
