import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utility.XLUtility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

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

    @Test(dataProvider = "XLSXProvider")
    public void Test1(String name, String rollno, String address, String myClass){
        System.out.println(name + " " + rollno + " " + address + " " + myClass);
    }


    @DataProvider(name = "XLSXProvider")
    public Object[][] dataProviderXlsx() throws IOException {
        String path = System.getProperty("user.dir") + "\\datasource\\student.xlsx";
        XLUtility xlUtility = new XLUtility(path);
        int totalRows = xlUtility.getRowCount("Student Info");
        int totalColumns = xlUtility.getCellCount("Student Info", 1);
        String [][] userData  = new String[totalRows][totalColumns];
        for (int row = 0 ; row < totalRows; row++){
            for (int col = 0 ; col < totalColumns; col++){
                userData[row][col] = xlUtility.getCellData("Student Info", row, col);
//                System.out.print(" Values is : " + userData[row][col]);
            }
//            System.out.println();
        }
        return userData;

    }


    @Test(dataProvider = "JsonProvider")
    public void TestJson(Object[] arr){
        System.out.println(Arrays.toString(arr));
    }

    @DataProvider(name = "JsonProvider")
    public Object[][] JsonParser() throws IOException {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try{
            String path = System.getProperty("user.dir") + "\\datasource\\userdetails.json";
            FileReader fileReader = new FileReader(path);
            obj = parser.parse(fileReader);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject) obj;
        Object userDetails = jsonObject.get("userdetails");
        JSONArray jsonArray = (JSONArray) userDetails;
        String userLogin[] = new String[jsonArray.size()];
        for(int i=0; i< jsonArray.size(); i++){
            Object o = jsonArray.get(i);
            JSONObject jsonObject1 = (JSONObject) o;
            String username = (String) jsonObject1.get("user");
            String password = (String) jsonObject1.get("password");
            System.out.println("user "  + username);
            System.out.println("password "  + password);
            userLogin[i] = username + " " + password;
        }
        return new Object[][]{userLogin};
    }

    @AfterMethod
    public void cleanUp(){
        if(d != null){
            d.close();
        }
    }
}