package tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import data.LoadProperties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;



public class TestBase  {




	public static WebDriver driver ;
	static ExtentReports reports;
	static ExtentTest test;
	String url = LoadProperties.userData.getProperty("URL");


	@BeforeTest
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		reports = new ExtentReports("E:\\intellj project\\VodafoneautomationTask-master\\report.html",true);
		test =reports.startTest("Extent vodafone test");
	 	driver.manage().window().maximize();
	 	driver.manage().deleteAllCookies();
	 	driver.navigate().to(url);
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 	String actualUrl = driver.getCurrentUrl();
	 	String expectedUrl = url;
	 	Assert.assertEquals(actualUrl, expectedUrl, "URL is mismatched");

	}
	@AfterMethod
	public void screenshotCapture(	ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			getScreenshot(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName()+".jpg");
		}
	}
	public static String getScreenshot(String testName)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;

		File src=ts.getScreenshotAs(OutputType.FILE);

		String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+testName+".png";

		File destination=new File(path);

		try
		{
			FileUtils.copyFile(src, destination);
		} catch (IOException e)
		{
			System.out.println("Capture Failed "+e.getMessage());
		}

		return path;
	}
	 @AfterTest
	 public void stopDriver() throws IOException {

		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.quit();
		 reports.endTest(test);
		 reports.flush();

	 }
 
}
