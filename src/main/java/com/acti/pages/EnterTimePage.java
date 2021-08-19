package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

/*
 * Title: DriverScript
 * Description: 
 * Developed By: Pooja Prahlad
 * Data : 30/07/2021
 * Approved By: Shantosh Kumar
 * Approved Date: 30/07/2021
 */

public class EnterTimePage extends DriverScript {

//******************************Page Elements ***************************************************************
	@FindBy(id="logoutLink") WebElement linkLogout;
	@FindBy(xpath="//a[@class='userProfileLink username ']") WebElement textUserLoggedIn;
	@FindBy(id="container_tasks") WebElement menuTask;
	
//*******************************Page Initialization*********************************************************	
	public EnterTimePage()
	{
		PageFactory.initElements(driver, this);
	}

//**********************************Page Actions**************************************************************	
	public void clickLogout()
	{
		linkLogout.click();
	}
	
	public String verifyUserLoggedIn()
	{
		return textUserLoggedIn.getText();		
	}
	
	public void clickTaskMenu()
	{
		menuTask.click();
	}
	

}
