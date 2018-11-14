package pageObjects;

import env.Constant;
import locators.SearchLocators;
import org.junit.Assert;
<<<<<<< HEAD
=======
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
>>>>>>>  Test added for Refined Search

public class SearchPage extends SearchLocators {

    public SearchPage(){
        super();
    }

    public void searchParameters() {
<<<<<<< HEAD
        String ID = heading_MDMID.getText();
=======

/*        String ID = heading_MDMID.getText();
>>>>>>>  Test added for Refined Search
        String Cust = heading_CUSTID.getText();
        String CustName = heading_CustomerName.getText();
        String DateOfBirth = heading_DOB.getText();
        String City = heading_AddressCity.getText();
        String Area = heading_AddressArea.getText();
        String HBranch = heading_HomeBranch.getText();
        String ARM = heading_AssetRM.getText();
        String LRM = heading_LiabilityRM.getText();
        String GID = heading_GroupID.getText();
        String BusinessSeg = heading_BusinessSegment.getText();
        String PartnerSeg = heading_PartnerSegment.getText();
        String OpenDate = heading_CustOpenDate.getText();
        Assert.assertEquals(Constant.MDMID,ID);
        Assert.assertEquals(Constant.CUSTID,Cust);
        Assert.assertEquals(Constant.CustomerName,CustName);
        Assert.assertEquals(Constant.DOB,DateOfBirth);
        Assert.assertEquals(Constant.AdressCity,City);
        Assert.assertEquals(Constant.AdressArea,Area);
        Assert.assertEquals(Constant.HomeBranch,HBranch);
        Assert.assertEquals(Constant.AssetRM,ARM);
        Assert.assertEquals(Constant.LiabilityRM,LRM);
        Assert.assertEquals(Constant.GroupID,GID);
        Assert.assertEquals(Constant.BusinessSegment,BusinessSeg);
        Assert.assertEquals(Constant.PartnerSegment,PartnerSeg);
<<<<<<< HEAD
        Assert.assertEquals(Constant.CustOpenDate,OpenDate);
=======
        Assert.assertEquals(Constant.CustOpenDate,OpenDate);*/
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[3]/div[3]/table/tbody/tr"));
        int count = elements.size();
        System.out.println("count: "+count);
        Assert.assertTrue(count <= Constant.threshold);
        String rowCount = count + " Results";
        System.out.println(rowCount);

        String text = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/p/span")).getText();
        System.out.println(text);
        String str = text;
/*        int length = str.length();
        System.out.println(length);
        char res = str.charAt(length-12);
        System.out.println("result : "+res);
        String result = res + " Results";
        System.out.println(result);*/
        String strg = str.substring(17, 26);
        System.out.println(strg);
        Assert.assertEquals(rowCount,);

>>>>>>>  Test added for Refined Search
    }

    public void noSearchResultDisplay(){
        String noSearchResult = heading_NoSearchResult.getText();
        Assert.assertEquals("No result found",noSearchResult);
    }

    public void toolTipMessageDisplayCustID(){
        String toolTipResult = heading_ToolTipCustID.getText();
        Assert.assertEquals(Constant.CustIDToolTip,toolTipResult);
    }
<<<<<<< HEAD
=======

    public String getpageTitle(){
        String title = driver.getTitle();
        System.out.println("Title is : "+title);
        return title;
    }

    public void searchCriteria() {
        String searchText = SearchResultsFor.getText();
        Assert.assertEquals(Constant.SearchParameters,searchText);
    }

    public void refineMessage() {
        String msg = refinementMessage.getText();
        Assert.assertEquals("Search returned too many results. Please refine", msg);
    }
>>>>>>>  Test added for Refined Search
}
