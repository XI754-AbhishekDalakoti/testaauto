package pageObjects;

import env.Constant;
import locators.SearchLocators;
import org.junit.Assert;

public class SearchPage extends SearchLocators {

    public SearchPage(){
        super();
    }

    public void searchParameters() {
        String ID = heading_MDMID.getText();
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
        Assert.assertEquals(Constant.CustOpenDate,OpenDate);
    }

    public void noSearchResultDisplay(){
        String noSearchResult = heading_NoSearchResult.getText();
        Assert.assertEquals("No result found",noSearchResult);
    }

    public void toolTipMessageDisplayCustID(){
        String toolTipResult = heading_ToolTipCustID.getText();
        Assert.assertEquals(Constant.CustIDToolTip,toolTipResult);
    }
}
