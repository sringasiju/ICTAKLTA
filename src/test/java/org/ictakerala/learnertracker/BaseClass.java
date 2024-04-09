package org.ictakerala.learnertracker;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
WebDriver driver;
@BeforeClass
	public void init()
	{
	driver = new ChromeDriver();
	driver.get("https://learnertracker.netlify.app/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		

	}
@AfterClass
public void End()
{
	System.out.println("All Test Caeses are Executed");
}
}
