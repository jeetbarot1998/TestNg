package Listener;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

//@Listeners(Listener.ListenerDemo.class)
public class TestListenerDemo {

    @Test
    public void t1(){
        System.out.println("t1");
        Assert.assertEquals("1","1");
    }

    @Test
    public void t2(){
        System.out.println("t2");
        Assert.assertEquals("1","2");
    }

    @Test
    public void t3(){
        System.out.println("t3");
        throw new SkipException("Skipping the test");
    }


}
