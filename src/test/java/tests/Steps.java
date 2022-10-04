package tests;

import data.LoadProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.GoogleSearchPage;

public class Steps extends TestBase {

    String type = LoadProperties.userData.getProperty("types");
    String assertiondata = LoadProperties.userData.getProperty("assertionData");
    String secondpageassertions = LoadProperties.userData.getProperty("secondpageassertion");

    GoogleSearchPage googlesearchobject;

    @Given("the user in google  enter data")
    public void user_enter_data_to_googlesearchtext() {
        googlesearchobject = new GoogleSearchPage(driver);
        googlesearchobject.fill_text_box(type);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        googlesearchobject.goToTheNextGoogleSearchPage();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        googlesearchobject.counthenumberofresultsdisplayed();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        googlesearchobject.redirecttonextpage();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @When("redirect to next page count the result")
    public void nextPagecount () {
        googlesearchobject.counthenumberofresultsintheextpagedisplayed();
        googlesearchobject.redirecttonextpage();
        Assert.assertEquals(secondpageassertions,googlesearchobject.secondpage.getText());
        googlesearchobject.pageThree();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("validate the second page with third page")
    public void validateTheSecondPageWithThirdPage() {
        int itemspgtwo = googlesearchobject.counthenumberofresultsintheextpagedisplayed();
        int itemspgthree = googlesearchobject.pageThree();
        Assert.assertEquals(itemspgtwo, itemspgthree);
        // Assert.assertEquals(assertiondata, itemspgthree);
    }
}
