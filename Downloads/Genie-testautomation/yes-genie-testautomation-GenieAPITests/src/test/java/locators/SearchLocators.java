package locators;

import info.seleniumcucumber.userStepDefintions.UserStepDefinitions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchLocators extends UserStepDefinitions {

    public SearchLocators() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//tr[@class='_2j273KfcopuPfnUH86Gf88']/td[1]")
    public static WebElement heading_MDMID;

    @FindBy(how = How.XPATH, using = "//tr[@class='_2j273KfcopuPfnUH86Gf88']/td[2]")
    public static WebElement heading_CUSTID;

    @FindBy(how = How.XPATH, using = "//tr[@class='_2j273KfcopuPfnUH86Gf88']/td[3]")
    public static WebElement heading_CustomerName;

    @FindBy(how = How.XPATH, using = "//tr[@class='_2j273KfcopuPfnUH86Gf88']/td[4]")
    public static WebElement heading_DOB;

    @FindBy(how = How.XPATH, using = "//tr[@class='_2j273KfcopuPfnUH86Gf88']/td[5]")
    public static WebElement heading_AddressCity;

    @FindBy(how = How.XPATH, using = "//tr[@class='_2j273KfcopuPfnUH86Gf88']/td[6]")
    public static WebElement heading_AddressArea;

    @FindBy(how = How.XPATH, using = "//tr[@class='_2j273KfcopuPfnUH86Gf88']/td[7]")
    public static WebElement heading_HomeBranch;

    @FindBy(how = How.XPATH, using = "//tr[@class='_2j273KfcopuPfnUH86Gf88']/td[8]")
    public static WebElement heading_AssetRM;

    @FindBy(how = How.XPATH, using = "//tr[@class='_2j273KfcopuPfnUH86Gf88']/td[9]")
    public static WebElement heading_LiabilityRM;

    @FindBy(how = How.XPATH, using = "//tr[@class='_2j273KfcopuPfnUH86Gf88']/td[10]")
    public static WebElement heading_GroupID;

    @FindBy(how = How.XPATH, using = "//tr[@class='_2j273KfcopuPfnUH86Gf88']/td[11]")
    public static WebElement heading_BusinessSegment;

    @FindBy(how = How.XPATH, using = "//tr[@class='_2j273KfcopuPfnUH86Gf88']/td[12]")
    public static WebElement heading_PartnerSegment;

    @FindBy(how = How.XPATH, using = "//tr[@class='_2j273KfcopuPfnUH86Gf88']/td[13]")
    public static WebElement heading_CustOpenDate;

    @FindBy(how = How.XPATH, using = "//div[@class='_3EDtrwq_7VF1ryjpZ5V5pi']")
    public static WebElement heading_NoSearchResult;

    @FindBy(how = How.XPATH, using = "//div[@class='_2Z0W6Iozj-mZSQZGQiNQRg']")
    public static WebElement heading_ToolTipCustID;

}
