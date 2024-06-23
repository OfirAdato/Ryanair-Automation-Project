package pageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Begs {

	@FindBy(css = ".trip-type__icon.trip-type__icon--selected")
	private WebElement fltreturnBtn;

	@FindBy(css = "body > hp-app-root > hp-home-container > hp-home > hp-search-widget-container > hp-search-widget > div > hp-flight-search-widget-container > fsw-flight-search-widget-container > fsw-flight-search-widget > fsw-trip-type-container > fsw-trip-type > fsw-trip-type-button:nth-child(2) > button > icon")
	private WebElement fltoneBtn;

	@FindBy(css = ".promo-code__label.body-l-lg.body-l-sm")
	private WebElement promoBtn;

	@FindBy(css = "#input-button__departure")
	private WebElement departureBtn;

	@FindBy(css = ".ng-trigger-datesFromTripTypeChange.input-button--connected-right .input-button__input.ng-star-inserted")
	private WebElement departDateBtn;

	@FindBy(css = "flight-widget-controls__control flight-widget-controls__control--airport ng-tns-c81-4 input-button--connected-right")
	private WebElement departDateBtnAcount;

	@FindBy(css = ".ng-trigger-smoothPickerAppear.input-button--connected-left.ng-star-inserted .input-button__input.ng-star-inserted")
	private WebElement returnDateBtn;

	@FindBy(css = ".flight-widget-controls__control--passengers.ng-tns-c79-4.ng-star-inserted")
	private WebElement passengerBtn;

	@FindBy(css = "ry-counter:nth-child(3) > div.counter > div.counter__button-wrapper--enabled")
	private WebElement passengernumBtn;

	@FindBy(css = ".passengers__confirm-button.ry-button--anchor-blue.ry-button--anchor")
	private WebElement passengerokBtn;

	@FindBy(css = ".flight-search-widget__start-search.ng-tns-c54-3")
	private WebElement searchBtn;

	@FindBy(css = ".countries__country.body-l-lg.body-l-sm.ng-star-inserted")
	private List<WebElement> countryList;

	@FindBy(css = ".list__airports-scrollable-container.small-height>.ng-star-inserted")
	private List<WebElement> cityList;

	@FindBy(css = ".list__airports-scrollable-container.large-height>.ng-star-inserted")
	private List<WebElement> cityDESList;

	@FindBy(css = ".m-toggle__scrollable-item.ng-star-inserted")
	private List<WebElement> monthList;

	@FindBy(css = ".calendar-body__cell-wrap.ng-star-inserted")
	private List<WebElement> dayList;

	public MainPage(WebDriver driver) {
		super(driver);

	}

	// if you want return flight
	public void returnFlight() {
		waitUntil(5, fltreturnBtn);

	}

	// if you want one way ticket
	public void oneWay() {
		waitUntil(5, fltoneBtn);

	}

	// if you have code
	public void applyPromoCode(String code) {
		waitUntil(5, promoBtn);
		waiting(1000);
		fillText(promoBtn, code);

	}

	// choose your departure
	public void departure(String countryName, String cityName) {
		waiting(3000);
		click(departureBtn);
		waiting(500); 
		for (WebElement el : countryList) {
			WebElement countryTitle = el.findElement(By.cssSelector(".countries__country-inner.ng-star-inserted"));
			waiting(500);
			if (getText(countryTitle).contains(countryName)) {
				waitUntil(5, countryTitle);
				break;
			}
		}
		waiting(500);
		for (WebElement el : cityList) {
			WebElement cityTitle = el.findElement(By.cssSelector(".body-l-lg.body-l-sm.airport-item"));
			if (getText(cityTitle).equalsIgnoreCase(cityName)) {
				waitUntil(5, cityTitle);
				break;
			}
		}

	}

	// choose your destination
	public void destintion(String countryName, String cityName) {
		waiting(1000);
		for (WebElement el : countryList) {
			WebElement countryTitle = el.findElement(By.cssSelector(".countries__country-inner.ng-star-inserted"));
			waiting(500);
			if (getText(countryTitle).contains(countryName)) {
				waitUntil(5, countryTitle);
				break;
			}
		}
		waiting(1000);
		for (WebElement el : cityDESList) {
			WebElement cityTitle = el.findElement(By.cssSelector(".body-l-lg.body-l-sm.airport-item"));
			if (getText(cityTitle).equalsIgnoreCase(cityName)) {
				waitUntil(5, cityTitle);
				break;
			}
		}

	}

	// choose your depart date(month and day)
	public void departDateAcount(String monthName, String day) {
		waiting(1000);
		waitUntil(5, departDateBtnAcount);
		waitUntil(5, departDateBtnAcount);
		waiting(500);
		for (WebElement el : monthList) {
			WebElement monthTitle = el.findElement(By.cssSelector(".m-toggle__month"));
			waiting(500);
			if (getText(monthTitle).contains(monthName)) {
				waitUntil(5, monthTitle);
				break;
			}
		}
		waiting(1000);
		for (WebElement el : dayList) {
			try {
				WebElement cityTitle = el.findElement(By.cssSelector(".calendar-body__cell"));
				if (getText(cityTitle).equalsIgnoreCase(day)) {
					waitUntil(5, cityTitle);
					break;
				}
			} catch (org.openqa.selenium.ElementClickInterceptedException exeption) {

				;
			}
		}

	}
	// choose your depart date(month and day)
	public void departDate(String monthName, String day) {
		waiting(1000);
		waitUntil(5, departDateBtn);
		waitUntil(5, departDateBtn);
		waiting(500);
		for (WebElement el : monthList) {
			WebElement monthTitle = el.findElement(By.cssSelector(".m-toggle__month"));
			waiting(500);
			if (getText(monthTitle).contains(monthName)) {
				waitUntil(5, monthTitle);
				break;
			}
		}
		waiting(1000);
		for (WebElement el : dayList) {
			try {
				WebElement cityTitle = el.findElement(By.cssSelector(".calendar-body__cell"));
				if (getText(cityTitle).equalsIgnoreCase(day)) {
					waitUntil(5, cityTitle);
					break;
				}
			} catch (org.openqa.selenium.ElementClickInterceptedException exeption) {
				
				continue;
			}
		}
		
	}

	// choose your return date(month and day)
	public void returnDate(String monthName, String day) {
		waiting(1000);
		waitUntil(5, returnDateBtn);
		waitUntil(5, returnDateBtn);
		waiting(500);
		for (WebElement el : monthList) {
			WebElement monthTitle = el.findElement(By.cssSelector(".m-toggle__month"));
			waiting(500);
			if (getText(monthTitle).contains(monthName)) {
				waitUntil(5, monthTitle);
				break;
			}
		}
		waiting(1000);
		for (WebElement el : dayList) {
			try {
				WebElement cityTitle = el.findElement(By.cssSelector(".calendar-body__cell"));
				if (getText(cityTitle).equalsIgnoreCase(day)) {
					waitUntil(5, cityTitle);
					break;
				}
			} catch (org.openqa.selenium.ElementClickInterceptedException exeption) {

				continue;
			}
		}

	}

	// choose adults number
	public void choosepassenger() {
		waiting(3000);
		waitUntil(5, passengerBtn);
		waitUntil(5, passengerBtn);
		waitUntil(5, passengernumBtn);
		waitUntil(5, passengerokBtn);

	}

	// search your next flight
	public void search() {
		waitUntil(5, searchBtn);

	}
}