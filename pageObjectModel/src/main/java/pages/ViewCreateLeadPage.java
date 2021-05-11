package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecifiMethods;

public class ViewCreateLeadPage extends ProjectSpecifiMethods{
	
	public ViewCreateLeadPage (ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void createdleadornot()
	{
		String title = driver.findElement(By.xpath("//div[text()='View Lead']")).getText();
		if(title.equalsIgnoreCase("View Lead"))
				{
			System.out.println("The lead is created successfully");
				}
	}
	
	public EditLeadPage clickEditFirstLeadButton()
	{
		driver.findElement(By.linkText("Edit")).click();
		return new EditLeadPage(driver);
	}
	
	public DuplicateLeadPage clickDuplicateLead()
	{
		driver.findElement(By.linkText("Duplicate Lead")).click();
		return new DuplicateLeadPage(driver);
	}

	public ViewFindLeadPage clickDeleteButton()
	{
		driver.findElement(By.linkText("Delete")).click();
		return new ViewFindLeadPage(driver);
	}
	
}
