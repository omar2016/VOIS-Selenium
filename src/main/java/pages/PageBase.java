package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	protected WebDriver driver; 
    public static  JavascriptExecutor js;
    public static WebDriverWait wait ;
    		
   


	
	public PageBase (WebDriver driver) {
		
		PageFactory.initElements(driver, this);

	}
	
	
	public static void clickButton(WebElement button) {
		
		button.click();
	}

	public static void elementSubmit(WebElement element) {

		element.submit();
	}

	public static void setElementText (WebElement settxtElement , String txt) {
		
		settxtElement.sendKeys(txt);
	}
	
	public static void scrolldown(String distance) {
		js.executeScript(distance);
		
	}
	public static void waiting(WebElement button) {
		wait.until(ExpectedConditions.elementToBeClickable(button));
	}
	public static void waitingScroll() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Search Results")));
	}
}
