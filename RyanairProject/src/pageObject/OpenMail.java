package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

public class OpenMail extends BasePage {

	public OpenMail(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = ".Xb9hP>input[id^='identifierId']")
	private WebElement filedMail;

	@FindBy(css = "#identifierNext > div > button > div.VfPpkd-RLmnJb")
	private WebElement okBtn;

	@FindBy(css = "[type='password']")
	private WebElement filedPass;

	@FindBy(css = "#passwordNext > div > button > div.VfPpkd-RLmnJb")
	private WebElement nextBtn;

	public void openGmail() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		// driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.google.com/mail");

	}

	public void mail(String email) {
		waitUntil(5, filedMail);
		fillText(filedMail, email);
		click(okBtn);
	}

	public void pass(String pass) {
		waiting(1000);
		fillText(filedPass, pass);
		click(nextBtn);

	}

}
