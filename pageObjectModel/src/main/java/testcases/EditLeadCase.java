package testcases;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiMethods;
import pages.CreateLeadPage;
import pages.LoginPage;

public class EditLeadCase extends ProjectSpecifiMethods {

	@BeforeTest
	public void setexcelfilename()
	{
		filename="EditLead";
	}
	
	@Test(dataProvider = "senddata")
	public void EditleadCase(String username, String password, String phonenumber, String companyname) throws InterruptedException, IOException
	{
		new LoginPage(driver).enterUsername(username)
		.enterPassword(password).
		clickLoginbutton().
		clickHomepagebutton().createLead().clickFindLead().clickPhoneMenu().PassPhoneNumber(phonenumber).
		clickFindLeadButton().clickFirstDisplayLead().clickEditFirstLeadButton().updateCompanyName(companyname).
		clickSubmitafterEdit();
	}
}
