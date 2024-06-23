package pageTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageObject.Flight;
import pageObject.GmailPage;
import pageObject.MainPage;
import pageObject.OpenMail;
import pageObject.Seats;
import pageObject.SharedPage;
import pageObject.Begs;
import pageObject.Extras;

public class LogInTest4 extends BaseTest {

	SharedPage sp;
	OpenMail om;
	MainPage mp;
	Flight fl;
	Seats st;
	Begs bg;
	Extras ex;
	GmailPage gp;

	@Test(description = "log in")
	public void tc_01() {
	
		WebDriver driver = new ChromeDriver();
		driver.get("http://stackoverflow.com/questions/25363023/mouse-scroll-down-using-selenium-webdriver-2-0-java");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

	@Test(description = "go to gmail")
	public void tc_02() {

	}

}
