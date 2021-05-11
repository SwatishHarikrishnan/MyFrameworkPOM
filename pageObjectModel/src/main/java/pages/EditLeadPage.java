package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecifiMethods;

public class EditLeadPage extends ProjectSpecifiMethods{

	public EditLeadPage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	public EditLeadPage updateCompanyName(String companyname)
	{
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyname);
		return this;
	}
	
	public ViewCreateLeadPage clickSubmitafterEdit()
	{
		driver.findElement(By.name("submitButton")).click();
		return new ViewCreateLeadPage(driver);
	}
	
	
		
	
}
