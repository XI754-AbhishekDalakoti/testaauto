package pages;

import java.util.List;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CalendarPage extends PageObject {

	@FindBy(xpath = "//div[starts-with(@class,'mat-input-infix')]/input")
	private WebElementFacade txtSerachBox;
	@FindBy(xpath = "//input[starts-with(@id,'mat-input')]")
	private WebElementFacade txtChatBox;
	@FindBy(xpath = "//button[@type='submit']/span[@class='mat-button-wrapper']")
	private WebElementFacade btnSend;
	@FindBy(xpath = "//button[starts-with(@class,'search-btn send')]/span[@class='mat-button-wrapper']")
	private WebElementFacade btnChatSend;
	@FindBy(xpath = "//button[@class='confirm-btn']")
	private WebElementFacade btnYes;
	@FindBy(xpath = "//button[starts-with(@class,'cancel-btn')]")
	private WebElementFacade btnNo;
	@FindBy(xpath = "//button[@class='menu-item']/img[@class='user-avatar']")
	private WebElementFacade btnUserMenu;
	@FindBy(xpath = "//button[text()='Logout']")
	private WebElementFacade btnLogout;
	@FindBy(xpath = "//div[@class='passenger-name']//preceding-sibling::div[@class='passenger-image me']")
	private WebElementFacade btnCoTraveller;
	@FindBy(xpath = "//div[@class='chat-conv-box']")
	private WebElementFacade lblchatBox;
	@FindBy(xpath = "//span[@class='build-experience-link']")
	private WebElementFacade lnkOwnExp;


	public void enterChat(String Message) {
		lblchatBox.waitUntilVisible();
		txtChatBox.type(Message);
		btnChatSend.waitUntilClickable();
		btnChatSend.click();
	}

	public void searchText(String Message) {
		txtSerachBox.waitUntilVisible();
		txtSerachBox.type(Message);
		waitForTextToDisappear("Please wait, while we curate some custom experience especially for you");
		btnSend.click();
	}

	public boolean verifyChatResponse(String Message) {
		waitForAllTextToAppear(Message);
		List<WebElement> chatResponses = getDriver().findElements(By.xpath("//div[@class='text-wrapper animated fadeIn']"));
		for (WebElement response : chatResponses) {
			if (response.getText().toLowerCase().contains(Message.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	public void selectResponse(String response) {
		btnYes.waitUntilClickable();
		if (response.equalsIgnoreCase("Yes")) {
			btnYes.click();
		} else {
			btnNo.click();
		}
	}

	public void logOut() {
		btnCoTraveller.waitUntilClickable();
		btnUserMenu.waitUntilClickable();
		btnUserMenu.click();
		btnLogout.waitUntilClickable();
		btnLogout.click();

	}

}
