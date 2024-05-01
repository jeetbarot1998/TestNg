package parallelTest;

import org.testng.annotations.Test;

public class parallelTest1 {

    @Test
    public void t1(){
        System.out.println("t1");
        System.out.println(Thread.currentThread());
    }

    @Test
    public void t2(){
        System.out.println("t2");
        System.out.println(Thread.currentThread());
    }

}
