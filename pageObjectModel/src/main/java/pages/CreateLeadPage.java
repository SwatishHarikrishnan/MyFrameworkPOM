package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecifiMethods;

public class CreateLeadPage extends ProjectSpecifiMethods {

	public CreateLeadPage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	public CreateLeadPage companyname(String companyname) 
	{
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyname);
		return this;
	}
	public CreateLeadPage firstName(String firstname) 
	{
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
		return this;
	}
	public CreateLeadPage lastName(String Lastname) 
	{
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(Lastname);
		return this;
	}
	public ViewCreateLeadPage clickSubmitCreateLead()
	{
		driver.findElement(By.name("submitButton")).click();
		return new ViewCreateLeadPage(driver);
	}
	
	public ViewFindLeadPage clickFindLead()
	{
		driver.findElement(By.linkText("Find Leads")).click();
		return new ViewFindLeadPage(driver);
	}
}
