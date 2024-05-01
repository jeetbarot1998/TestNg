import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertionDemo {

    @BeforeClass
    public void Setup(){
        System.out.println("Setting up");
    }

    @Test
    public void T1(){
        System.out.println("T1");
    }

    @Test
    public void T2(){
        System.out.println("T2");
    }

    @AfterClass
    public void cleanUpTask(){
        System.out.println("Cleaning Up");
    }
}
