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

public class FlightWithLOGIN extends BaseTest {

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
		sp.switchNewTab(main);
		sp.verifyCode();
	}

	@Test(description = "choose countrys")
	public void tc_03() {
		mp = new MainPage(driver);
		mp.returnFlight();
		mp.departure("Israel", "Tel Aviv");
		mp.destintion("Hungary", "Budapest");

	}

	@Test(description = " choose dates")
	public void tc_04() {
		mp.departDate("May", "21");
		mp.returnDate("May", "25");

	}

	@Test(description = " search flight")
	public void tc_05() {
		mp.search();

	}

	@Test(description = " search cheapest flight")
	public void tc_06() {
		fl = new Flight(driver);
		fl.cheapestDPTFlt();
		fl.cheapestRTNFlt();

	}

	@Test(description = " add extras")
	public void tc_07() {
		fl.extras("Regular");
		fl.logInLater();
	}

	@Test(description = " fill details")
	public void tc_08() {
		fl.gender("Mr");
		fl.detailsPassenger("Ofir", "Adato");
		fl.continueBtn();

	}

	@Test(description = " choose seat")
	public void tc_09() {
		st = new Seats(driver);
		st.chooseDPTSeat("25");
		st.chooseRTNSeat("25");
		st.fastTrack();

	}

	@Test(description = " add begs")
	public void tc_10() {
		bg = new Begs(driver);
		bg.continueToNextPage();

	}

	@Test(description = " add extras")
	public void tc_11() {
		ex = new Extras(driver);
		ex.continueToNextPage();
		ex.continueToLastPage();

	}

}
