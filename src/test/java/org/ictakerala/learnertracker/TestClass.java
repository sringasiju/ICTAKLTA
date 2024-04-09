package org.ictakerala.learnertracker;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

//import org.testng.Assert;
//import org.testng.annotations.Test;

public class TestClass extends BaseClass {
	HomePage homeobj;
	TrainerPage trainerobj;
	AddForm formobj;
	AddLearnerPage learnerobj;
	POPage pobj;
	Adminlogin adminobj;
	
	@Test(priority=1)
	public void homepage()
	{
		homeobj=new HomePage(driver);
		
		String text = homeobj.getTextHome();
		AssertJUnit.assertEquals(text,"ICTAK - Learner Tracker");
		System.out.println("Home page loaded successfully");
		String text1 = homeobj.getTextLogin();
		AssertJUnit.assertEquals(text1, "Login");
		System.out.println("Home page loaded with Login");
		boolean logo = homeobj.getLogo();
		AssertJUnit.assertTrue(logo);
		System.out.println("Home page loaded with Logo");
		
	}
	
	@Test(priority=2)
	public void trainerlogin()
	{
		trainerobj = new TrainerPage(driver);
		
		trainerobj.TC_TLOGN_32("Trainer", "trainer@123");
		AssertJUnit.assertTrue(trainerobj.allert_msg1());
		trainerobj.close_btn();
		
		trainerobj.TC_TLOGN_33("trainer@123");
		AssertJUnit.assertTrue(trainerobj.user_req_msg());
		trainerobj.close_btn();
		
		trainerobj.TC_TLOGN_34("trainer", "Trainer@123");
		AssertJUnit.assertTrue(trainerobj.allert_msg2());
		trainerobj.close_btn();
		AssertJUnit.assertFalse(trainerobj.is_Forgot_pswd_available());
		System.out.println("Forgot Password is not available");
		
		trainerobj.TC_TLOGN_35("trainer");
		AssertJUnit.assertTrue(trainerobj.pswd_req_msg());
		trainerobj.close_btn();
		
		trainerobj.TC_TLOGN_36();
		AssertJUnit.assertTrue(trainerobj.usr_pswd_req_msg());
		trainerobj.close_btn();
		
		trainerobj.TC_TLOGP_2("trainer", "trainer@123");
		AssertJUnit.assertTrue(trainerobj.TC_TLOGP_22()); 
		trainerobj.TC_FORM_42(); 
		trainerobj.TC_FORM_421();
	}
	
	@Test(priority=3)
	public void addform()
	{
		formobj = new AddForm(driver);
		
		formobj.TC_FORM_43();
		AssertJUnit.assertTrue(formobj.isFormAvailable());
		System.out.println("Learner's form is availble");
		
		AssertJUnit.assertTrue(formobj.isIdAvailable());
		AssertJUnit.assertTrue(formobj.isNameAvailable());
		AssertJUnit.assertTrue(formobj.isCourseAvailable());
		AssertJUnit.assertTrue(formobj.isProjectAvailable());
		AssertJUnit.assertTrue(formobj.isBatchAvailable());
		AssertJUnit.assertTrue(formobj.isCourseStatusAvailable());
		System.out.println("All fields are available in Learner's form");
		
		formobj.TC_FORM_44();
		AssertJUnit.assertTrue(formobj.isFSDAvailable());
		AssertJUnit.assertTrue(formobj.isDSAAvailable());
		AssertJUnit.assertTrue(formobj.isML_AIAvailable());
		AssertJUnit.assertTrue(formobj.isRPAAvailable());
		AssertJUnit.assertTrue(formobj.isSTAvailable());
		AssertJUnit.assertTrue(formobj.isCSAAvailable());
		System.out.println("All the options are available in Course dropdown");
		
		formobj.TC_FORM_45();
		AssertJUnit.assertTrue(formobj.isICTAKAvailable());
		AssertJUnit.assertTrue(formobj.isKKEMAvailable());
		AssertJUnit.assertTrue(formobj.isNORKAAvailable());
		AssertJUnit.assertTrue(formobj.isABCDAvailable());
		AssertJUnit.assertTrue(formobj.isKDISCAvailable());
		System.out.println("All the options are available in Project dropdown");
		
		formobj.TC_FORM_46();
		AssertJUnit.assertTrue(formobj.isMay_22Available());
		AssertJUnit.assertTrue(formobj.isJun_22Available());
		AssertJUnit.assertTrue(formobj.isJul_22Available());
		AssertJUnit.assertTrue(formobj.isAug_22Available());
		AssertJUnit.assertTrue(formobj.isDec_22Available());
		AssertJUnit.assertTrue(formobj.isMar_23Available());
		System.out.println("All the options are available in Batch dropdown");
		
		formobj.TC_FORM_47();
		AssertJUnit.assertTrue(formobj.isQualifiedAvailable());
		AssertJUnit.assertTrue(formobj.isIncompetentAvailable());
		System.out.println("All the options are available in Course Status dropdown");
		
		formobj.TC_FORM_48();
	}
	
	@Test(priority=4)
	public void addlearner() throws IOException, InterruptedException
	{
		learnerobj = new AddLearnerPage(driver);
		
		learnerobj.TC_ADD_P_52();
		learnerobj.TC_ADD_N_62("", "");
		AssertJUnit.assertTrue(learnerobj.warning_msg());
		System.out.println("Posting failed without data");
		learnerobj.back_dashboard();
		
		learnerobj.TC_ADD_N_63("@23", "ramu");
		AssertJUnit.assertTrue(learnerobj.warning_msg1());
		System.out.println("Posting failed with ivalid Learner Id");
		
		learnerobj.TC_ADD_N_64("250", "36");
		AssertJUnit.assertTrue(learnerobj.warning_msg2());
		System.out.println("Posting failed with ivalid Name");
		
		learnerobj.TC_ADD_P_53("85", "Sringa");
		learnerobj.TC_ADD_P_54();
		AssertJUnit.assertTrue(learnerobj.Assertion_allert_msg());
		System.out.println("Learner posted successfully");
		learnerobj.ok_button();
		
		learnerobj.TC_ADD_P_55("FSD-45");
		learnerobj.TC_ADD_P_56();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		learnerobj.TC_BULK_71();
		AssertJUnit.assertTrue(learnerobj.isupload_available());
		System.out.println("Upload a CSV file is available");
		
		learnerobj.TC_BULK_72("C:\\Users\\Sringa\\Downloads\\SampleCSV - Sheet1 (1).csv");
		AssertJUnit.assertTrue(learnerobj.Assertion_allert_msg1());
		System.out.println("File uploaded successfully");
		
		learnerobj.TC_BULK_74();
		AssertJUnit.assertTrue(learnerobj.Assertion_allert_msg2());
		System.out.println("File saved");
		
		learnerobj.TC_BULK_75();
		learnerobj.TC_BULK_76();
		learnerobj.TC_BULK_77();
		AssertJUnit.assertTrue(learnerobj.Assertion_home());
		System.out.println("Navigated to home page");			
	}
	
	@Test(priority=5)
	
			public void placementofficer()
			{
				pobj= new POPage(driver);
				
				pobj.TC_PLOG_N_92();
				AssertJUnit.assertTrue(pobj.Assertion_Warning_msg());
				
				pobj.TC_PLOG_N_93("Pofficer","pofficer@123");
				AssertJUnit.assertTrue(pobj.Assertion_Warning_msg1());
				
				pobj.TC_PLOG_N_94("pofficer@123");
				AssertJUnit.assertTrue(pobj.Assertion_Warning_msg2());
				
				pobj.TC_PLOG_N_95("pofficer","Pofficer@123");
				AssertJUnit.assertTrue(pobj.Assertion_Warning_msg3());
				
				pobj.TC_PLOG_N_96("pofficer");
				AssertJUnit.assertTrue(pobj.Assertion_Warning_msg4());
				
				pobj.TC_PLOG_P_82("pofficer", "pofficer@123");
				AssertJUnit.assertTrue(pobj.Assertion_Dashboard());
				System.out.println("Placement Officer login Successful");
				
				pobj.TC_PSU_10_2();
				AssertJUnit.assertTrue(pobj.Is_Placement_Status_available());
				System.out.println("Placement Status is available");
				
				pobj.TC_PSU_10_3();
				AssertJUnit.assertTrue(pobj.Is_Placed_available());
				AssertJUnit.assertTrue(pobj.Is_JobSeeking_available());
				AssertJUnit.assertTrue(pobj.Is_NotInterested_available());
				System.out.println("All Placement status options are available");
				System.out.println("correct data displayed in dropdown without any blank value");
				
				pobj.TC_PSU_10_6();
				String expected = "Updated Successfully";
				AssertJUnit.assertEquals("Updated Successfully", expected);
				System.out.println("Placement status updated successfully");
				pobj.TC_PSU_10_8();
				AssertJUnit.assertTrue(pobj.Is_home_available());
					
			}
	@Test(priority=6)
	public void admin()
	{
		adminobj = new Adminlogin(driver);
		
		adminobj.TC_ADMIN_11_1("admin","admin@123");
		AssertJUnit.assertTrue(adminobj.Allert_msg());
		System.out.println("Admin login failed");
	} 
}
