package testcases;

import base.Baseclass;
import pages.LoginPage;
import pages.CampaignPage;
import utils.ConfigReader;

import java.io.File;

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
	    public void testCampaignCreation() throws InterruptedException {
	        CampaignPage campaign = new CampaignPage(driver);

	        String campaignTitle = ConfigReader.get("campaignTitle");
	        String filePath =ConfigReader.get("filePath");
	        File file = new File(filePath);
	        if (!file.exists()) {
	            throw new RuntimeException("File not found at: " + filePath);
	        }
	        String SMSMassage=ConfigReader.get("SMSMassage");
	        
		campaign.createCampaign(campaignTitle, file.getAbsolutePath(),SMSMassage);
			
	    }
}
