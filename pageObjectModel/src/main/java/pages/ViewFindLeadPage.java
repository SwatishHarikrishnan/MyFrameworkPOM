package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecifiMethods;

public class ViewFindLeadPage extends ProjectSpecifiMethods {

	static String leadID;
	
	public ViewFindLeadPage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	public ViewFindLeadPage clickPhoneMenu()
	{
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		return this;
	}
	
	public ViewFindLeadPage PassPhoneNumber(String phonenumber)
	{
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phonenumber);
		return this;
	}
	
	public ViewFindLeadPage clickFindLeadButton() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		return this;
	}
	
	public ViewCreateLeadPage clickFirstDisplayLead() 
	{
	    leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		String titleofcurrentpage=driver.findElement(By.xpath("//div[text()='View Lead']")).getText();
		if(titleofcurrentpage.equalsIgnoreCase("view lead"))
			{
			System.out.println("It is confirmed successfully we are in view lead of first lead in find leads page");
			}
		else
			{
			System.out.println("We are not in View lead page");
			}
		return new ViewCreateLeadPage(driver);
	}
	
	public ViewFindLeadPage forDeleteFindLead()
	{
		driver.findElement(By.linkText("Find Leads")).click();
		return this;
	}
	
		public ViewFindLeadPage checkWhehterLeadDeletedornot()
		{
			driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			String text = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
			if (text.contains("No records")) {
				System.out.println("Lead is deleted successfully");
			} else {
				System.out.println("Text not matched");
			}
			return this;
		}
	
	

	
}
