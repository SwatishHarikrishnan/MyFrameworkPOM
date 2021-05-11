package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecifiMethods;

public class MyHomepage extends ProjectSpecifiMethods{

	public MyHomepage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	public CreateLeadPage createLead()
	{
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLeadPage(driver);
	}
	
}
