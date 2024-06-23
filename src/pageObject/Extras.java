package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Extras extends BasePage {

	public Extras(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = ".booking-content__section--continue-flow .ry-button--gradient-yellow")
	private WebElement continueBtn;

	@FindBy(css = "div:nth-child(1) > div.insurance-card__card-subtitle.body-l-lg.ng-star-inserted > div.insurance-card__option-card-actions.ng-star-inserted > button")
	private WebElement addStandardInsurance;

	@FindBy(css = "div:nth-child(2) > div.insurance-card__card-subtitle.body-l-lg.ng-star-inserted > div.insurance-card__option-card-actions.ng-star-inserted > button")
	private WebElement addInsurancePlus;

	@FindBy(css = ".ry-button--large")
	private WebElement continueToLastPageBtn;

	// continue to the next page.
	public void continueToNextPage() {
		waiting(10000);
		click(continueBtn);

	}

	// if you want add standard insurance.
	public void standardInsurance() {
		waiting(10000);
		click(addStandardInsurance);

	}

	// if you want add insurance plus.
	public void insurancePlus() {
		waiting(10000);
		click(addInsurancePlus);

	}

	// continue to the last page.
	public void continueToLastPage() {
		waiting(10000);
		click(continueToLastPageBtn);

	}

}
