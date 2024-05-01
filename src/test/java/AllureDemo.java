import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseClass;

import static org.junit.Assert.fail;

public class AllureDemo extends BaseClass {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        super.setup();
        System.out.println("Setting up");
    }

    @Test(priority = 3)
    public void t1(){
        System.out.println("t1");
    }

    @Test(priority = 2)
    public void t2(){
        System.out.println("t2");
    }

    @Test(priority = 1)
    public void t3(){
        System.out.println("t3");
    }

    @Test(priority = 1)
    public void Skipper(){
        throw new SkipException("Skipping");
    }

    @Test(priority = 0)
    public void Failure(){
        fail();
    }

    @AfterMethod
    public void tearDown(){
        super.tearDown();
    }

}
