package pageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Flight extends Begs {

	public Flight(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = ".journeys-wrapper>div:nth-child(1) ul>li")
	private List<WebElement> priceDPTList;

	@FindBy(css = ".journeys-wrapper>div:nth-child(2) ul>li")
	private List<WebElement> priceRTNList;

	@FindBy(css = ".fare-table-spinner.grid.grid-cols-4.ry-spinner--large.ry-spinner--cover .fare-card ")
	private List<WebElement> extrasList;

	@FindBy(css = ".dropdown__menu-items .dropdown-item__link")
	private List<WebElement> genderList;

	@FindBy(css = ".flight-card-summary__select-btn")
	private WebElement SelectDptBtn;

	@FindBy(css = ".flight-card-summary__select-btn")
	private WebElement SelectRTNBtn;

	@FindBy(css = ".ry-button--full.login-touchpoint__login-button")
	private WebElement logInBtn;

	@FindBy(css = ".dialog.signup-dialog .close__icon")
	private WebElement closelogInBtn;

	@FindBy(css = ".login-touchpoint__expansion-bar>.login-touchpoint__chevron-container")
	private WebElement logInLaterBtn;

	@FindBy(css = ".dropdown.body-l-lg.body-l-sm>.dropdown__toggle")
	private WebElement genderBtn;

	@FindBy(css = "#form\\.passengers\\.ADT-0\\.name")
	private WebElement passengerFirstName;

	@FindBy(css = "#form\\.passengers\\.ADT-0\\.surname")
	private WebElement passengerLastName;

	@FindBy(css = "div > div > span > button")
	private WebElement continueBtn;

	// choose the cheapest depart flight
	public void cheapestDPTFlt() {
		waiting(5000);

		int minDPTPrice = Integer.MAX_VALUE;
		WebElement minDPTWeb = null;
		waiting(2000);
		for (WebElement el : priceDPTList) {
			waiting(700);
			WebElement integerPriceDPT;
			boolean isDisplay = true;
			try {
				waiting(200);
				integerPriceDPT = el.findElement(By.cssSelector(".price__integers"));
				isDisplay = integerPriceDPT.isDisplayed();
				waiting(200);

			}

			catch (org.openqa.selenium.NoSuchElementException exeption) {

				waiting(200);
				System.out.println("the element not exist");
				isDisplay = false;
				waiting(200);
				continue;

			}
			if (isDisplay) {
				waiting(200);
				System.out.println("I can see number");
				String priceDPTNumSTR = getText(integerPriceDPT);
				System.out.println(" the price is " + priceDPTNumSTR);
				int priceDPTNumINT = Integer.parseInt(priceDPTNumSTR);
				if (priceDPTNumINT < minDPTPrice) {
					minDPTPrice = priceDPTNumINT;
					minDPTWeb = integerPriceDPT;
				}
				waiting(200);
			} else {
				waiting(200);
				System.out.println("I can not see number");
				continue;
			}

		}

		waitUntil(5, minDPTWeb);
		System.out.println("The smallest number is: " + minDPTPrice);
		waitUntil(5, SelectDptBtn);

	}

	// choose the cheapest return flight
	public void cheapestRTNFlt() {
		waiting(3000);

		int minRTNPrice = Integer.MAX_VALUE;
		WebElement minRTNWeb = null;
		waiting(1000);
		for (WebElement el : priceRTNList) {
			WebElement integerPriceRTN;
			boolean isDisplay = true;
			try {
				waiting(200);
				integerPriceRTN = el.findElement(By.cssSelector(".price__integers"));
				isDisplay = integerPriceRTN.isDisplayed();
				waiting(200);

			}

			catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.JavascriptException e) {
				waiting(200);
				System.out.println("the element not exist");
				isDisplay = false;
				waiting(200);
				continue;

			}
			if (isDisplay) {
				waiting(200);
				System.out.println("I can see number");
				String priceRTNNumSTR = getText(integerPriceRTN);
				System.out.println(" the price is " + priceRTNNumSTR);
				int priceRTNNumINT = Integer.parseInt(priceRTNNumSTR);
				if (priceRTNNumINT < minRTNPrice) {
					minRTNPrice = priceRTNNumINT;
					minRTNWeb = integerPriceRTN;
				}
				waiting(200);
			} else {
				waiting(200);
				System.out.println("I can not see number");
				continue;
			}

		}

		waitUntil(5, minRTNWeb);
		System.out.println("The smallest number is: " + minRTNPrice);
		waitUntil(5, SelectRTNBtn);

	}

	// choose extra s
	public void extras(String extraName) {

		waiting(500);
		for (WebElement el : extrasList) {
			WebElement extraTitle = el.findElement(By.cssSelector(".fare-card__title.title-l-lg.title-l-sm"));
			waiting(500);
			if (getText(extraTitle).contains(extraName)) {
				waitUntil(5, extraTitle);
				break;
			}
		}
	}

	// log in later to continue

	public void logInLater() {

		try {
			waiting(5000);
			click(logInLaterBtn);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			click(logInBtn);
			click(closelogInBtn);

		}

	}

	// choose the gender of passenger
	public void gender(String gender) {

		waitUntil(5, genderBtn);
		waiting(500);
		for (WebElement el : genderList) {
			WebElement genderTitle = el
					.findElement(By.cssSelector(".dropdown__menu-items .dropdown-item__link .dropdown-item__content"));
			waiting(500);
			if (getText(genderTitle).contains(gender)) {
				waitUntil(5, genderTitle);
				break;
			}
		}

	}
	// fill details of passenger

	public void detailsPassenger(String firstName, String lastName) {

		fillText(passengerFirstName, firstName);
		fillText(passengerLastName, lastName);

	}
	// continue

	public void continueBtn() {
		waitUntil(5, continueBtn);

	}

}