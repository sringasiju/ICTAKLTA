package org.ictakerala.learnertracker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adminlogin {
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement Username;
	@FindBy(xpath="//input[@name='password']")
	private WebElement Password;
	@FindBy(xpath="//button[text()='Login']")
	private WebElement login;
	@FindBy(xpath="//div[text()='Login Failed!!']")
	private WebElement LoginFailed;
	
	public Adminlogin(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void TC_ADMIN_11_1(String username, String password)
	{
		driver.navigate().refresh();
		Username.sendKeys(username);
		Password.sendKeys(password);
		login.click();
	}
	public boolean Allert_msg()
	{
		return LoginFailed.getText().toString().contains("Login Failed!!");
	}
}
