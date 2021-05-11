package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecifiMethods;

public class LoginPage extends ProjectSpecifiMethods {

	public LoginPage(ChromeDriver driver){
		this.driver=driver;}
	
	public LoginPage enterUsername(String username) throws InterruptedException, IOException
	{try {
			driver.findElement(By.id(prop.getProperty("LoginPage.Username.ID"))).sendKeys(username);
			reportStep("username is entered successfully", "pass");
		} catch (Exception e) {
			reportStep("username is not entered successfully", "fail");}
		return this;}
	
	public LoginPage enterPassword(String password) throws IOException{
		try {
			driver.findElement(By.id(prop.getProperty("LoginPage.Password.ID"))).sendKeys(password);
			reportStep("password is entered successfully", "pass");
		} catch (Exception e) {
			reportStep("password is not entered successfully", "fail");} 
		return this;}
	
	public Homepage clickLoginbutton()
	{
		driver.findElement(By.className(prop.getProperty("LoginPage.LoginButton.ClassName"))).click();
		return new Homepage(driver);
	}}
