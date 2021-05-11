package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecifiMethods;

public class Homepage extends ProjectSpecifiMethods{
	
	public Homepage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	public MyHomepage clickHomepagebutton() {
		driver.findElement(By.id(prop.getProperty("HomePage.Crmsfa.LinkText"))).click(); 
		return new MyHomepage(driver);
	}
	
	public LoginPage clicklogoutbutton()
	{
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		return new LoginPage(driver);
	}

}
