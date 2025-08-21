package testcases;

import base.Baseclass;
import pages.LoginPage;
import pages.CampaignPage;
import utils.ConfigReader;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CampaignTest extends Baseclass {

  @BeforeClass
	    public void loginOnce() {
	        LoginPage login = new LoginPage(driver);
	        String loginUsername = ConfigReader.get("loginusername");
	        String loginPassword = ConfigReader.get("loginpassword");
	        login.LoginAccount(loginUsername, loginPassword);
	    }

	    @Test(priority = 1)
	    public void testCampaignCreation() {
	        CampaignPage campaign = new CampaignPage(driver);

	        String campaignTitle = ConfigReader.get("campaignTitle");
	        
		campaign.createCampaign(campaignTitle);
			
	    }
}
