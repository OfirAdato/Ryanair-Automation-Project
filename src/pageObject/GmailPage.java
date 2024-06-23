package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPage extends BasePage {

	public GmailPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = "[type='email']")
	private WebElement emailField;

	@FindBy(css = "#identifierNext")
	private WebElement nextToPass;

	@FindBy(css = "[type='password']")
	private WebElement passField;

	@FindBy(css = "#passwordNext")
	private WebElement nextToMail;

	@FindBy(css = ".F.cf.zt")
	private WebElement mailRow;

	@FindBy(css = "div:nth-child(2) > div.T-I.J-J5-Ji.nX.T-I-ax7.T-I-Js-Gs.mA.T-I-KL")
	private WebElement deleteBox;

	// what is your mail
	public void fieldMail(String email) {
		waiting(1000);
		fillText(emailField, email);

	}

	// click to pass page
	public void nextToPassword() {
		waiting(3000);
		waitUntil(5, nextToPass);
	}

	// what is your password
	public void fieldPassword(String password) {
		waiting(3000);
		fillText(passField, password);
		;
	}

	// next to home page
	public void nextToHome() {
		waiting(1000);
		waitUntil(5, nextToMail);
	}

	// insert to mail
	public void chooseMail() {
		waiting(1500);
		waitUntil(5, mailRow);
	}

	// delete the last mail
	public void deleteMail(String main) {
		waiting(12000);
		try {
			click(deleteBox);
		} catch (org.openqa.selenium.NoSuchElementException exeption) {
			switchNewTab(main);
		}
	}

}
