package org.ictakerala.learnertracker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	private By home = By.xpath("//p[text()='ICTAK - Learner Tracker']");
	private By login = By.xpath("//button[text()='Login']");
	private By Logo = By.xpath("//img[@class='App-logo mb-2']");
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	public String getTextHome()
	{
		return driver.findElement(home).getText();
		
		}
	public String getTextLogin()
	{
		return driver.findElement(login).getText();
	}
	public boolean getLogo()
	{
		return driver.findElement(Logo).isDisplayed();
	}
}
