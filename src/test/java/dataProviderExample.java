import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class dataProviderExample {

    private static WebDriver d;

    @BeforeMethod
    public void init(){
        WebDriverManager.chromedriver().setup();
        d = new ChromeDriver();
    }

    @Test(dataProvider = "login")
    public void testLogin(String email, String name){
        System.out.println("Email is : " + email + " & name is : " + name);
    }

    @DataProvider(name = "login")
    public Object[][] getData(){
        return new Object[][]{{"emailId", "name"}, {"emailId2", "name2"}, {"emailId3", "name3"}};
    }

    @Test(dataProvider = "loginData")
    public void t1(String name, String password ,String isValid){
            d.get("https://www.saucedemo.com/");
            WebElement uname = d.findElement(By.xpath("//*[@id=\"user-name\"]"));
            uname.clear();
            uname.sendKeys(name);
            WebElement upassword = d.findElement(By.xpath("//*[@id=\"password\"]"));
            upassword.clear();
            upassword.sendKeys(password);
            WebElement loginButton = d.findElement(By.xpath("//*[@id=\"login-button\"]"));
            loginButton.click();
            String expectedUrl = "https://www.saucedemo.com/inventory.html";
            String actualUrl = d.getCurrentUrl();
            if(isValid.equalsIgnoreCase("Valid")){
                Assert.assertTrue(expectedUrl.equalsIgnoreCase(actualUrl));
            }
            else if(isValid.equalsIgnoreCase("InValid")){
                Assert.assertFalse(expectedUrl.equalsIgnoreCase(actualUrl));
            }
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData(){
        String loginData [][] = {
                {"standard_user", "secret_sauce", "Valid"},
                {"Invalid_user", "invalid_password", "InValid"},
        };
        return loginData;
    }


    @AfterMethod
    public void cleanUp(){
        if(d != null){
            d.close();
        }
    }
}




