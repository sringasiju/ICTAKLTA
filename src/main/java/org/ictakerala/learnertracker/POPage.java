package org.ictakerala.learnertracker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement Username;
	@FindBy(xpath="//input[@name='password']")
	private WebElement Password;
	@FindBy(xpath="//button[@class='btn btn-success w-100']")
	private WebElement login;
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	private WebElement Dashboard;
	@FindBy(xpath="//small[text()='Please fill in all fields.']")
	private WebElement Warning_msg;
	@FindBy(xpath="//div[text()='User not found !!']")
	private WebElement Warning_msg1;
	@FindBy(xpath="//small[text()='Username is required.']")
	private WebElement Warning_msg2;
	@FindBy(xpath="//div[text()='Login Failed!!']")
	private WebElement Warning_msg3;
	@FindBy(xpath="//small[text()='Password is required.']")
	private WebElement Warning_msg4;
	
	@FindBy(xpath="//tbody/tr[2]//button[@class='btn btn-success btn btn-primary']")
	private WebElement Update_btn;
	@FindBy(xpath="//label[text()='Placement Status:']")
	private WebElement Placement_Status;
	@FindBy(xpath="//select[@class='form-select' and @name='pstatus']")
	private WebElement Select_PS;
	
	@FindBy(xpath="//option[text()='Placed']")
	private WebElement Placed;
	@FindBy(xpath="//option[text()='Job seeking']")
	private WebElement Job_Seeking;
	@FindBy(xpath="//option[text()='Not Interested']")
	private WebElement Not_Interested;
	@FindBy(xpath="//button[@class='btn btn-success']")
	private WebElement Submit;
	@FindBy(xpath="//a[@id='basic-nav-dropdown']")
	private WebElement Officer;
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement Logout;
	@FindBy(xpath="//p[text()='ICTAK - Learner Tracker']")
	private WebElement Assertion_Home;
	
	public POPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void TC_PLOG_N_92()
	{
		Username.clear();
		Password.clear();
		login.click();
	}
	public boolean Assertion_Warning_msg()
	{
		return Warning_msg.getText().toString().contains("Please fill in all fields.");
		
	}
	public void TC_PLOG_N_93(String username2, String password2)
	{
		Username.clear();
		Username.sendKeys(username2);
		Password.clear();
		Password.sendKeys(password2);
		login.click();
	}
	public boolean Assertion_Warning_msg1()
	{
		return Warning_msg1.getText().toString().contains("User not found !!");
		
	}
	public void TC_PLOG_N_94(String password3)
	{
		driver.navigate().refresh();
		Username.clear();
		Password.clear();
		Password.sendKeys(password3);
		login.click();
	}
	public boolean Assertion_Warning_msg2()
	{
		return Warning_msg2.getText().toString().contains("Username is required.");
		
	}
	public void TC_PLOG_N_95(String username4,String password4)
	{
		Username.clear();
		Username.sendKeys(username4);
		Password.clear();
		Password.sendKeys(password4);
		login.click();
	}
	public boolean Assertion_Warning_msg3()
	{
		return Warning_msg3.getText().toString().contains("Login Failed!!");
		
	}
	public void TC_PLOG_N_96(String username4)
	{
		driver.navigate().refresh();
		Username.clear();
		Username.sendKeys(username4);
		Password.clear();
		login.click();
	}
	public boolean Assertion_Warning_msg4()
	{
		return Warning_msg4.getText().toString().contains("Password is required.");
		
	}
	
	public void TC_PLOG_P_82(String username1, String password1)
	{
		Username.clear();
		Username.sendKeys(username1);
		Password.clear();
		Password.sendKeys(password1);
		login.click();
	}
	public boolean Assertion_Dashboard()
	{
		return Dashboard.getText().toString().contains("LearnerTracker");
		
	}
	public void TC_PSU_10_2()
	{
		Update_btn.click();
	}
	public boolean Is_Placement_Status_available()
	{
		return Placement_Status.getText().toString().contains("Placement Status:");
	}
	public void TC_PSU_10_3()
	{
		Select_PS.click();
	}
	public boolean Is_Placed_available()
	{
		return Placed.getText().toString().contains("Placed");
	}
	public boolean Is_JobSeeking_available()
	{
		return Job_Seeking.getText().toString().contains("Job seeking");
	}
	public boolean Is_NotInterested_available()
	{
		return Not_Interested.getText().toString().contains("Not Interested");
	}
	public void select_Placement_status()
	{
		Job_Seeking.click();
	}
	public void TC_PSU_10_6()
	{
		Submit.click();
		
	}
	public void TC_PSU_10_8()
	{
		Officer.click();
		Logout.click();
	}
	public boolean Is_home_available()
	{
		return Assertion_Home.getText().toString().contains("ICTAK - Learner Tracker");
	}
}
