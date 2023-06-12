package pageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Seats extends Begs {

	public Seats(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".seatmap__seats")
	private List<WebElement> rowDPTSeat;

	@FindBy(css = ".seatmap__seats")
	private List<WebElement> rowRTNSeat;

	@FindBy(css = "")
	private List<WebElement> seatNumList;

	@FindBy(css = ".enhanced-takeover-beta__product-actions .enhanced-takeover-beta__product-dismiss-cta.ry-button--anchor-blue.ry-button--anchor")
	private WebElement deleteFastTrack;

	@FindBy(css = ".seats-action__button.ry-button--flat-blue")
	private WebElement nextBtn;

	@FindBy(css = ".seatmap__seat.seatmap__seat--standard.ng-star-inserted")
	private WebElement seatAvailable;

	// choose row to seat in the depart flight.
	public void chooseDPTSeat(String ROW) {
		waiting(3000);
		for (WebElement el : rowDPTSeat) {
			WebElement rowNum;
			boolean isDisplay = true;
			try {
				rowNum = el.findElement(By.cssSelector(".seatmap__seat.seatmap__seat--aisle.b2.ng-star-inserted"));
				isDisplay = rowNum.isDisplayed();
				waiting(300);
			} catch (org.openqa.selenium.NoSuchElementException exeption) {
				waiting(300);
				System.out.println("the element not exist");
				isDisplay = false;
				waiting(300);
				continue;
			}
			if (isDisplay) {
				waiting(300);
				System.out.println("I can see number " + getText(rowNum));
				if (getText(rowNum).contains(ROW)) {
					WebElement seatNum;
					boolean isEnabled = true;

					try {
						seatNum = el
								.findElement(By.cssSelector(".seatmap__seat.seatmap__seat--standard.ng-star-inserted"));
						isEnabled = seatNum.isEnabled();

					} catch (org.openqa.selenium.NoSuchElementException e) {
						waiting(700);
						System.out.println("there is no seat available");
						isDisplay = false;
						waiting(700);
						continue;
					}
					if (isEnabled) {
						waiting(300);
						System.out.println("I can see seat");
						waitUntil(5, seatNum);
						waiting(2000);
						click(nextBtn);
						break;

					}
				}
			}
		}

	}

	public void chooseRTNSeat(String ROW) {
		waiting(3000);
		for (WebElement el : rowRTNSeat) {
			WebElement rowNum;
			boolean isDisplay = true;
			try {
				rowNum = el.findElement(By.cssSelector(".seatmap__seat.seatmap__seat--aisle.b2.ng-star-inserted"));
				isDisplay = rowNum.isDisplayed();
				waiting(300);
			} catch (org.openqa.selenium.NoSuchElementException exeption) {
				waiting(300);
				System.out.println("the element not exist");
				isDisplay = false;
				waiting(300);
				continue;
			}
			if (isDisplay) {
				waiting(300);
				System.out.println("I can see number " + getText(rowNum));
				if (getText(rowNum).contains(ROW)) {
					WebElement seatNum;
					boolean isEnabled = true;

					try {
						seatNum = el
								.findElement(By.cssSelector(".seatmap__seat.seatmap__seat--standard.ng-star-inserted"));
						isEnabled = seatNum.isEnabled();

					} catch (org.openqa.selenium.NoSuchElementException e) {
						waiting(700);
						System.out.println("there is no seat available");
						isDisplay = false;
						waiting(700);
						continue;
					}
					try {
						if (isEnabled) {
							waiting(300);
							System.out.println("I can see seat");
							waitUntil(5, seatNum);
							waiting(2000);
							click(nextBtn);
							break;
						}

					} catch (org.openqa.selenium.NoSuchElementException e) {
						waiting(300);
						System.out.println("I can not see number");
						continue;
					}

				}

			}

		}

	}

	public void fastTrack() {
		waiting(5000);
		click(deleteFastTrack);
	}
}
