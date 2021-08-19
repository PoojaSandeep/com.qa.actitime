package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.acti.util.Helper;

public class TaskPageTest extends BaseTest {
	

	@Test(dataProvider="actidata")
	public void testCreateCustomer(String username, String password)
	{
		logger=report.createTest("Creating New Customer");
		
		loginpage.enterUsername(username);
		logger.info("entered username");
		loginpage.enterPassword(password);
		logger.info("entered password");
		loginpage.clicklogin();
		logger.info("clicked login button");
		entertimepage.clickTaskMenu();
		logger.info("clicked task menu");
		tasklistpage.clickAddNew();
		logger.info("clicked addnew button");
		tasklistpage.clickOptionNewCustomer();
		logger.info("clicked option new customer");
		tasklistpage.enterCustomerName("Dummy Customer1");
		logger.info("entered customer name");
		tasklistpage.enterCustomerDescription("Testing Create Customer");
		logger.info("entered customer description");
		tasklistpage.clickCreateCustomer();
		logger.info("clicked create customer");
		Helper.sleep();
		String message = tasklistpage.validateSuccessMessage();
		System.out.println(message);
		Assert.assertTrue(message.contains("created"));
		logger.pass("customer created successfully");
		Helper.sleep();
		entertimepage.clickLogout();
		logger.info("logged out from the applicaiton");
	}

	
	@Test(dataProvider="actidata")
	public void testDeleteCustomer(String username, String password)
	{
		logger=report.createTest("Deleting Added Customer");
		
		loginpage.enterUsername(username);
		logger.info("entered username");
		loginpage.enterPassword(password);
		logger.info("entered password");
		loginpage.clicklogin();
		logger.info("clicked login button");
		entertimepage.clickTaskMenu();
		logger.info("clicked task menu");
		tasklistpage.enterStartTyping("Dummy Customer1");
		logger.info("searched customer name");
		tasklistpage.clickSearchedCustomer();
		logger.info("clicked searched customer");
		tasklistpage.clickEditButton();
		logger.info("clicked edit button");
		tasklistpage.clickActionButton();
		logger.info("clicked action button");
		tasklistpage.clickDeleteButton();
		logger.info("clicked delete button");
		tasklistpage.clickDeletePermanentelyButton();
		logger.info("clicked delete permanently button");
		String message = tasklistpage.validateSuccessMessage();
		System.out.println(message);
		Assert.assertTrue(message.contains("Customer"));
		logger.pass("customer deleted successfully");
		Helper.sleep();
		entertimepage.clickLogout();
		logger.info("logged out from the applicaiton");
	}
	
	
	

}
