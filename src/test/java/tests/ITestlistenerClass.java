package tests;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestlistenerClass extends TestBase implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName());
        getScreenshot(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName()+ ".png");
    }
}
