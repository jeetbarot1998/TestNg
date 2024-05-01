package Listener;

import lombok.SneakyThrows;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.BaseClass;

import static utils.BaseClass.takeSnapShot;

public class ListenerDemo extends BaseClass implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        System.out.println("started executing test batch " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Finishing executing test batch " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("On test starting " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("On test Succeeding " + result.getName());
    }

    @Override
    @SneakyThrows
    public void onTestFailure(ITestResult result){
        String path = System.getProperty("user.dir") + "\\" + result.getMethod().getMethodName() + ".jpg";
        System.out.println(path);

        takeSnapShot(getDriver(),path);
        System.out.println("On failure " + result.getName() );
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("On test Skipped " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("on Test Failed But Within Success Percentage " + result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("on Test Failed With Timeout " + result.getName());
    }

}
