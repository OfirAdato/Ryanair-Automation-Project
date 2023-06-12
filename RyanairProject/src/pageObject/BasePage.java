package pageObject;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	private JavascriptExecutor js;
	String originalStyle;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void newTab(String newWebSite) {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to(newWebSite);
	}

	public void closeNewTab() {
		driver.close();
	}

	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)", "");

	}

	public void scrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-300)", "");
	}

	public void back() {
		driver.navigate().back();
	}

	public void switchNewTab(String main) {
		driver.switchTo().window(main);
	}

	public void alert() {
		driver.switchTo().alert().accept();
	}

	public void isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("element not found");
			;
		}
	}

	public void fillText(WebElement el, String text) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background-color:yellow;','border: 1px solid blue;');",
				el);
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},300);", el);
		waiting(200);
		clear(el);
		el.sendKeys(text);
	}

	public void clear(WebElement el) {
		el.clear();

	}

	public void click(WebElement el) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background-color:yellow;','border: 1px solid blue;');",
				el);
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},300);", el);
		waiting(200);
		el.click();
	}

	public String getText(WebElement el) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background-color:red;','border: 1px solid black;');", el);
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},300);", el);
		waiting(50);
		return el.getText();

	}

	// Select
	public void selectByValue(WebElement el, String text) {
		Select s = new Select(el);
		s.selectByValue(text);
	} 

	public void waiting(long mill) {
		try {
			Thread.sleep(mill);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}

	public void waitUntil(long sec, WebElement el) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background-color:yellow;','border: 1px solid blue;');",
				el);
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},300);", el);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(el));
		click(el);
	}

	public void quit() {
		driver.quit();
	}
}
