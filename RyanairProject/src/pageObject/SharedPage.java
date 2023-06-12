package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SharedPage extends BasePage {

	public SharedPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = "[aria-label='Log In'] .header-menu-item__title.ng-star-inserted")
	private WebElement logInBtn;

	@FindBy(css = ".cookie-popup-with-overlay__button")
	private WebElement acceptCookies;

	@FindBy(css = "[name='email'].b2.date-placeholder")
	private WebElement emailField;

	@FindBy(css = "[type='password']")
	private WebElement passField;

	@FindBy(css = ".auth-submit__button.ry-button--full")
	private WebElement connectBtn;

	@FindBy(css = "form > ry-auth-code > ry-input-d > div > input")
	private WebElement verifyField;

	@FindBy(css = "table:nth-child(4) > tbody > tr > td > table > tbody > tr > td:nth-child(2) > center > table > tbody > tr > td > table:nth-child(5) > tbody > tr > td")
	private WebElement codeNum;

	@FindBy(css = ".form__submit")
	private WebElement verifyBtn;

	// accept cookies
	public void cookies() {
		waiting(800);
		click(acceptCookies);
	}

	// log in
	public void logIn(String mail, String pass) {
		waiting(1000);
		click(logInBtn);
		waiting(800);
		fillText(emailField, mail);
		waiting(800);
		fillText(passField, pass);
		waitUntil(5, connectBtn);

	}

	// copy the verify code
	public void copyCode() {
		waiting(3000);
		codeNumber = getText(codeNum);
		System.out.println(codeNumber);

	}

	String codeNumber;

	// insert the verify code
	public void verifyCode() {
		waiting(5000);
		fillText(verifyField, codeNumber);
		waiting(700);
		click(verifyBtn);
	}

}
