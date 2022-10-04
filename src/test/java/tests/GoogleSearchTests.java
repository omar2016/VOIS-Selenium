package tests;

import com.relevantcodes.extentreports.LogStatus;
import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;


public class GoogleSearchTests extends TestBase {

    String type = LoadProperties.userData.getProperty("types");
    String assertiondata = LoadProperties.userData.getProperty("assertionData");
    String secondpageassertions = LoadProperties.userData.getProperty("secondpageassertion");
    GoogleSearchPage googlesearchobject;

    @Test(priority = 1, alwaysRun = true,testName = "user enter data started")
    public void user_enter_data_to_googlesearchtext() {
        try {
            test.log(LogStatus.INFO, "user enter data");
            googlesearchobject = new GoogleSearchPage(driver);
            googlesearchobject.fill_text_box(type);
            Thread.sleep(2000);
            googlesearchobject.goToTheNextGoogleSearchPage();
            Thread.sleep(1000);
            googlesearchobject.counthenumberofresultsdisplayed();
            Thread.sleep(1000);
            googlesearchobject.redirecttonextpage();
            Thread.sleep(2000);
            test.log(LogStatus.PASS,"user enter data" );
        } catch (Exception e) {
            e.printStackTrace();
            test.log(LogStatus.FAIL, test.addScreenCapture(getScreenshot("user enter data Failed")));

        }

    }
        @Test(priority = 2, alwaysRun = true , testName = "next page count")
        public void nextPagecount () {
            try {
                test.log(LogStatus.INFO, "next page count started");
                googlesearchobject.counthenumberofresultsintheextpagedisplayed();
                googlesearchobject.redirecttonextpage();
                Assert.assertEquals(secondpageassertions, googlesearchobject.secondpage.getText());
                googlesearchobject.pageThree();
                Thread.sleep(2000);
                test.log(LogStatus.PASS,"next page count" );
            } catch (Exception e) {
                e.printStackTrace();
                test.log(LogStatus.FAIL, test.addScreenCapture(getScreenshot("next page count Failed")));
            }
        }
            @Test(priority = 3, alwaysRun = true, testName = "validate pg two equal pg three")
            public void Validate_page_two_is_equal_page_three (){
                try{
                     test.log(LogStatus.INFO, "validate pg two equal pg three startred");
                     int itemspgtwo = googlesearchobject.counthenumberofresultsintheextpagedisplayed();
                     int itemspgthree = googlesearchobject.pageThree();
                     Assert.assertEquals(itemspgtwo, itemspgthree) ;
                     //Assert.assertEquals(assertiondata, itemspgthree);
                     test.log(LogStatus.PASS,"validate pg two equal pg three" );

                } catch(Exception e){
                    test.log(LogStatus.FAIL, test.addScreenCapture(getScreenshot("validate pg two equal pg three Failed")));
                    e.printStackTrace();

                }

}


}
