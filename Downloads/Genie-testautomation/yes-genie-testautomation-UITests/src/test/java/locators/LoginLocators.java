package locators;

import info.seleniumcucumber.userStepDefintions.UserStepDefinitions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginLocators extends UserStepDefinitions {

    public LoginLocators() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "buttonRipple")
    public static WebElement Login_button;

    @FindBy(how = How.ID, using = "username")
    public static WebElement textBox_Username;

    @FindBy(how = How.ID, using = "password")
    public static WebElement textBox_Password;

    @FindBy(how = How.XPATH, using = "//div[@class='_3BIeaRQGSZXeruo1s-1Pa6']")
    public static WebElement display_LastLogin;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Ravindra Singh')]")
    public static WebElement display_Name;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Collector')]")
    public static WebElement display_Role;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Manager')]")
    public static WebElement display_Designation;

    @FindBy(how = How.XPATH, using = "//span[@class='_1HWu9-VMmg-bQcnoV5fSo-']")
    public static WebElement display_Parameters;

    @FindBy(how = How.XPATH, using = "//img[@class='_3fWXu3xqpHxPGTycDx3vir']")
    public static WebElement dropDown;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Logout')]")
    public static WebElement Logout_button;



}
