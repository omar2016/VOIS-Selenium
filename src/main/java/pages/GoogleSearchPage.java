package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleSearchPage extends PageBase {


    public GoogleSearchPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    @FindBy(name="q")
    WebElement searchbox;

    @FindBy(xpath ="//*[@id=\"botstuff\"]/div/div[2]/table/tbody/tr/td[3]")
    public  WebElement secondpage;

    @FindBy (tagName= "a")
    List <WebElement> listResult2;

    @FindBy (className= "yuRUbf")
    List <WebElement> listResult3;

    @FindBy (css= ".yuRUbf a")
    List <WebElement> listResult;

    @FindBy (className= "yuRUbf")
    List <WebElement> listResult4;

    @FindBy (className= "yuRUbf")
    List <WebElement> listResult5;

    @FindBy(xpath = "//*[@id=\"pnnext\"]/span[2]")
    WebElement next;

    public void fill_text_box (String searchwords) {
        setElementText(searchbox, searchwords);
        scrolldown("scrollBy(0,50)");



    }

    public void goToTheNextGoogleSearchPage() {
        elementSubmit(searchbox);

    }

    //WebElement q;
   // public void countThenumberOfResultDisplay(){

            //for (int v=0 ; v < listResult.size() ; v++){
             //   q=listResult.get(v);
             //   System.out.println(q.getAttribute("href"));
             //   System.out.println(q.getText());

            //}        System.out.println(listResult.size());


   // }
    WebElement p ;
    public void counthenumberofresultsdisplayed  (){
        scrolldown("scrollBy(0,3500)");
        for (int x = 0 ; x<listResult3.size(); x++) {
            p= listResult3.get(x);
            System.out.println(p.getAttribute("href"));
            System.out.println(p.getText());
            }
            System.out.println(listResult3.size());


    }
    public void redirecttonextpage(){
        clickButton(next);

    }
    WebElement o ;
    public int counthenumberofresultsintheextpagedisplayed  (){
        //scrolldown("scrollBy(0,3500)");
        for (int x = 0 ; x<listResult4.size(); x++) {
            o= listResult4.get(x);
            System.out.println(o.getAttribute("href"));
            System.out.println(o.getText());
        }
        System.out.println(listResult4.size());
        int itemspagetwo = listResult4.size();
        return itemspagetwo;

    }
    WebElement u;
    public int pageThree  (){
        //scrolldown("scrollBy(0,3500)");
        for (int x = 0 ; x<listResult5.size(); x++) {
            u = listResult5.get(x);
            System.out.println(u.getAttribute("href"));
            System.out.println(u.getText());
        }
        System.out.println(listResult5.size());
        int itemspagethree =listResult5.size();
        return itemspagethree;
    }

}
