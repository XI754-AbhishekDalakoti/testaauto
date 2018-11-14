package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;

public class NeoLoginPage extends PageObject {

	LoginPage loginPage;

	@FindBy(xpath = "//div[starts-with(@class,'neo-form-field username')]/input")
	private WebElementFacade txtUserName;
	@FindBy(xpath = "//input[@type='password']")
	private WebElementFacade txtPassword;
	@FindBy(xpath = "//span[text()='Sign-In']")
	private WebElementFacade btnLogin;

	public void enterHomeUrl() {
		loginPage.open();
	}

	public void logIn(String userName, String password) {
		txtUserName.clear();
		txtUserName.type(userName);
		txtPassword.clear();
		txtPassword.type(password);
		btnLogin.click();
	}

}
