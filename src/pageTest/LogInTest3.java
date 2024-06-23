package pageTest;

import org.testng.annotations.Test;
import pageObject.Flight;
import pageObject.GmailPage;
import pageObject.MainPage;
import pageObject.OpenMail;
import pageObject.Seats;
import pageObject.SharedPage;
import pageObject.Begs;
import pageObject.Extras;

public class LogInTest3 extends BaseTest {

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
		sp = new SharedPage(driver);
		sp.cookies();
		sp.logIn("projectmail791@gmail.com", "Ao161198");

	}

	@Test(description = "go to gmail")
	public void tc_02() {
		gp = new GmailPage(driver);
		String main = driver.getWindowHandle();
		sp.newTab("https://mail.google.com/mail/?authuser=0");
		gp.fieldMail("projectmail791@gmail.com");
		gp.nextToPassword();
		gp.fieldPassword("projectmail16");
		gp.nextToHome();
		gp.chooseMail();
		sp.copyCode();
		gp.deleteMail(main);
		sp.closeNewTab();
		sp.switchNewTab(main);
		sp.verifyCode();

	}

}
