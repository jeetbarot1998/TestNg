import org.testng.annotations.Test;

public class Grouping {
    @Test(groups = {"smoke"})
    public void t1(){
        System.out.println("Smoke t1");
    }

    @Test(groups = {"smoke"})
    public void t2(){
        System.out.println("Smoke t2");
    }

    @Test(groups = {"smoke","regression"})
    public void tsr(){
        System.out.println("Smoke & regression tsr");
    }

    @Test(groups = {"regression"})
    public void t3(){
        System.out.println("regression t3");
    }

}
