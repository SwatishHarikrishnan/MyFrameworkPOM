package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecifiMethods;

public class DuplicateLeadPage extends ProjectSpecifiMethods{

	public DuplicateLeadPage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public ViewCreateLeadPage clickSubmitafterDuplicate()
	{
		driver.findElement(By.name("submitButton")).click();
		return new ViewCreateLeadPage(driver);
	}
		
	
	
}
