package Listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.BaseClass;

public class AllureListener extends BaseClass  implements ITestListener {

    @Attachment
    public byte[] saveScreenShot(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}" , type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Failed Test : " + result.getName());
        saveScreenShot(getDriver());
        saveTextLog(result.getMethod().getConstructorOrMethod().getName() + " failed");
    }

}
