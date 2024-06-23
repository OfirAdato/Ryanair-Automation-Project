package pageTest;

import org.testng.annotations.Test;
import pageObject.Flight;
import pageObject.MainPage;
import pageObject.OpenMail;
import pageObject.Seats;
import pageObject.SharedPage;
import pageObject.Begs;
import pageObject.Extras;

public class FlightWithOutLOGIN extends BaseTest {

	SharedPage sp;
	OpenMail om;
	MainPage mp;
	Flight fl;
	Seats st;
	Begs bg;
	Extras ex;

	@Test(description = "accepet coockies")
	public void tc_01() {
		sp = new SharedPage(driver);
		sp.cookies();
	}

	@Test(description = "choose countrys")
	public void tc_02() {
		mp = new MainPage(driver);
		mp.returnFlight();
		mp.departure("Israel", "Tel Aviv");
		mp.destintion("Greece", "Corfu");

	}

	@Test(description = " choose dates")
	public void tc_03() {
		mp.departDate("Spt", "30");
		mp.returnDate("Oct", "7");

	}

	@Test(description = " search flight")
	public void tc_04() {
		mp.search();

	}

	@Test(description = " search cheapest flight")
	public void tc_05() {
		fl = new Flight(driver);
		fl.cheapestDPTFlt();
		fl.cheapestRTNFlt();

	}

	@Test(description = " add extras")
	public void tc_06() {
		fl.extras("Regular");
		fl.logInLater();
	}

	@Test(description = " fill details")
	public void tc_07() {
		fl.gender("Mr");
		fl.detailsPassenger("Ofir", "Adato");
		fl.continueBtn();

	}

	@Test(description = " choose seat")
	public void tc_08() {
		st = new Seats(driver);
		st.chooseDPTSeat("26");
		st.chooseRTNSeat("26");
		st.fastTrack();

	}

	@Test(description = " add begs")
	public void tc_9() {
		bg = new Begs(driver);
		bg.continueToNextPage();

	}

	@Test(description = " add extras")
	public void tc_10() {
		ex = new Extras(driver);
		ex.continueToNextPage();
		ex.continueToLastPage();

	}

}
