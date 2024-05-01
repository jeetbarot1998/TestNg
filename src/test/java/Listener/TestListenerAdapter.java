package Listener;

import org.testng.ITestResult;

public class TestListenerAdapter extends org.testng.TestListenerAdapter {

    public TestListenerAdapter() {
        super();
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult tr) {
        super.onTestFailedWithTimeout(tr);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
        super.onTestFailedButWithinSuccessPercentage(tr);
    }
}
