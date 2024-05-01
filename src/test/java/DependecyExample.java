import org.testng.Assert;
import org.testng.annotations.Test;

public class DependecyExample {

    @Test(dependsOnMethods = {"findRightMatchForBridgeGroom","BookBanquetHallForMarraige"})
    public void PrintWeddingInvitation(){
        System.out.println("Print Invitation Card");
    }

    @Test(dependsOnMethods = {"findRightMatchForBridgeGroom"})
    public void BookBanquetHallForMarraige(){
        System.out.println("Book Banquet Hall For Marraige");
    }

    @Test
    public void findRightMatchForBridgeGroom(){
        System.out.println("Found the right match");
        Assert.fail();
    }

    @Test(dependsOnMethods = {"findRightMatchForBridgeGroom","BookBanquetHallForMarraige","PrintWeddingInvitation"},
    alwaysRun = true)
    public void MarraigeDone(){
        System.out.println("Marriage Done");
    }
}
