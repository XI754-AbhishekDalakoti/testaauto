package pageObjects;

import env.Constant;
import locators.LoginLocators;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


public class LoginPage extends LoginLocators {

    public LoginPage(){
        super();
    }

    public void checkDisableButton() {
        Assert.assertFalse(Login_button.isEnabled());
    }

    public void enterCredentials(String Username, String Password){
        textBox_Username.sendKeys(Username);
        textBox_Password.sendKeys(Password);
    }

    public void displayLoginDateTimeBasicInfo() {
        String Date = "January 19, 1970, 1:31 AM";
        String LastLogin = display_LastLogin.getText();
        LastLogin = LastLogin.replaceAll("Last Login: ","");
        System.out.println(LastLogin);
        Assert.assertEquals(Date,LastLogin);

        dropDown.click();
        String UserDesignation = display_Designation.getText();
        String UserRole = display_Role.getText();
        System.out.println(UserDesignation);
        System.out.println(UserRole);
        Assert.assertEquals(Constant.designation,UserDesignation);
        Assert.assertEquals(Constant.role,UserRole);
    }

    public void staticSearchParameters() {
        String parameters = display_Parameters.getText();
        Assert.assertEquals(parameters, Constant.SearchParameters);
    }

    public void logOut() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        dropDown.click();
        Logout_button.click();
//        String currentUrl = driver.getCurrentUrl();
//        Assert.assertEquals(Constant.URL,currentUrl);
    }
}
