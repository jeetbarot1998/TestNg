import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderExample {

    @Test(dataProvider = "login")
    public void testLogin(String email, String name){
        System.out.println("Email is : " + email + " & name is : " + name);
    }

    @DataProvider(name = "login")
    public Object[][] getData(){
        return new Object[][]{{"emailId", "name"}, {"emailId2", "name2"}, {"emailId3", "name3"}};
    }
}




