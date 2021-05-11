package testcases;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiMethods;
import pages.CreateLeadPage;
import pages.LoginPage;

public class DuplicateLeadCase extends ProjectSpecifiMethods {

	@BeforeTest
	public void setexcelfilename()
	{
		filename="Duplicatelead";
	}
	
	@Test(dataProvider = "senddata")
	public void DuplicateleadCase(String username, String password, String phonenumber) throws InterruptedException, IOException
	{
		new LoginPage(driver).enterUsername(username)
		.enterPassword(password).
		clickLoginbutton().
		clickHomepagebutton().createLead().clickFindLead().clickPhoneMenu().PassPhoneNumber(phonenumber).
		clickFindLeadButton().clickFirstDisplayLead().clickDuplicateLead().clickSubmitafterDuplicate();
	}
}
