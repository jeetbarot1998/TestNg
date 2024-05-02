package Listener;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseClass;

//@Listeners(ListenerDemo.class)
public class TestListener3 extends BaseClass {

    @BeforeMethod
    public void init() {
        super.setup();
    }

    @Test
    public void t1() {
        System.out.println("t1");
        super.getDriver().get("https://www.bbc.com/");
        Assert.assertEquals("A", "a");
    }

    @Test
    public void t2() {
        System.out.println("t2");
        getDriver().get("https://www.bbc.com/");
        Assert.assertEquals("A", "A");
    }


    @Test(enabled = false)
    public void t3() {
        System.out.println("t3");
        throw new SkipException("Skipping test case 3");
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

}
