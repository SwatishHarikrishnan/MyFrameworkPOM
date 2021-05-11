package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiMethods;
import pages.LoginPage;

public class LoginValidData extends ProjectSpecifiMethods {

	@BeforeTest
	public void setexcelfilename()
	{
		filename="Login";
		testName="LoginValidData";
		testDescription="Verify login for valid Data";
		testCategory="functional";
		testAuthor="Swatish";
	}
	
	@Test(dataProvider ="senddata")
	public void login(String username, String password) throws InterruptedException, IOException
	{
		new LoginPage(driver).enterUsername(username).enterPassword(password).clickLoginbutton();
	}
	
}
