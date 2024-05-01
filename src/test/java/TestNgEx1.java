import org.testng.Assert;
import org.testng.annotations.*;

public class TestNgEx1 {

    @BeforeTest
    public void BeforeTest(){
        System.out.println("Only once");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("Only once");
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("BeforeMethod");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("AfterMethod");
    }


    @Test
    public void c(){
        System.out.println("C");
    }

    @Test
    public void a(){
        System.out.println("A");
        Assert.assertEquals(2,3);
    }

    @Test
    public void b(){
        System.out.println("B");
    }

}
