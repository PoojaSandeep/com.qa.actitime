package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	
	
	@Test
	public void testLoginFunctionValidUser()
	{
		logger=report.createTest("Login Functionality");
		
		loginpage.enterUsername("admin");
		logger.info("entered username");
		loginpage.enterPassword("manager");
		logger.info("entered password");
		loginpage.clicklogin();
		logger.info("clicked loggin button");
		String actual = entertimepage.verifyUserLoggedIn();
		Assert.assertEquals(actual, "John Doe");
		logger.pass("user logged in successfully");
		entertimepage.clickLogout();
		logger.info("clicked logout");
		
	}
	
	
	@Test
	public void testLoginFunctionInValidUser()
	{
		logger=report.createTest("Login with Invalid Credientials");
		
		loginpage.enterUsername("admin");
		logger.info("entered username");
		loginpage.enterPassword("damager");
		logger.info("entered incorrect password");
		loginpage.clicklogin();
		logger.info("clicked loggin button");
		String errormessage = loginpage.verifyErrorMessage();
		System.out.println(errormessage);
		Assert.assertTrue(errormessage.contains("Username or Password is invalid"));
		logger.pass("verified the error message");
	}
	

}