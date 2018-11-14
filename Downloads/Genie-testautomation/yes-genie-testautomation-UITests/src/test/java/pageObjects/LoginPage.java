package pageObjects;

import env.Constant;
import locators.LoginLocators;
import org.junit.Assert;
<<<<<<< HEAD
import org.openqa.selenium.By;

=======

import java.text.ParseException;
import java.text.SimpleDateFormat;
>>>>>>>  Test added for Refined Search
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
<<<<<<< HEAD
        String Date = "January 19, 1970, 1:31 AM";
        String LastLogin = display_LastLogin.getText();
        LastLogin = LastLogin.replaceAll("Last Login: ","");
        System.out.println(LastLogin);
        Assert.assertEquals(Date,LastLogin);

=======
>>>>>>>  Test added for Refined Search
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

<<<<<<< HEAD
    public void logOut() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        dropDown.click();
        Logout_button.click();
//        String currentUrl = driver.getCurrentUrl();
//        Assert.assertEquals(Constant.URL,currentUrl);
=======
    public boolean logOut() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        dropDown.click();
        Logout_button.click();
        String title = sp.getpageTitle().trim();
        if(title.equalsIgnoreCase("Log in to YBL")) {
            return true;
        }
        return false;
    }

    public void validateFormat() throws ParseException {
        String strDate = display_LastLogin.getText();
        strDate = strDate.replaceAll("Last Login: ", "");
        SimpleDateFormat sdfrmt = new SimpleDateFormat("MMMM dd, yyyy, hh:mm a");
        sdfrmt.setLenient(false);
        sdfrmt.parse(strDate);
//        System.out.println(strDate + " is valid date format");
>>>>>>>  Test added for Refined Search
    }
}
