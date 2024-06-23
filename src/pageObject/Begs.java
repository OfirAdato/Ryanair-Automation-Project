package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Begs extends BasePage {

	public Begs(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = ".booking-content__section--continue-flow button")
	private WebElement continueBtn;

	@FindBy(css = ".product-selector__container .content-plus-tag__button-text")
	private WebElement addSmallBegs;

	@FindBy(css = ".counter .counter__button-wrapper--enabled")
	private WebElement addLargeBegs;

	@FindBy(css = "")
	private WebElement passField;

	@FindBy(css = "")
	private WebElement connectBtn;

	@FindBy(css = "")
	private WebElement loveBtn;

	@FindBy(css = "")
	private WebElement logoutBtn;

	//continue to the next page.
	public void continueToNextPage() {
		waiting(10000);
		click(continueBtn);

	}

	//if you want add one more 10k begs.
	public void addSmallBegs() {
		waitUntil(10, addSmallBegs);

	}
	//if you want add one more 20k begs.
	public void addLargeBegs() {
		waitUntil(10, addLargeBegs);

	}

}
