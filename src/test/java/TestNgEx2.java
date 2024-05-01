import org.testng.annotations.Test;

public class TestNgEx2 {

    @Test
    public void c(){
        System.out.println("TestNg2 C");
    }

    @Test(priority = 15)
    public void a(){
        System.out.println("TestNg2 A");
    }

    @Test(priority = 10)
    public void b(){
        System.out.println("TestNg2 B");
    }

}
